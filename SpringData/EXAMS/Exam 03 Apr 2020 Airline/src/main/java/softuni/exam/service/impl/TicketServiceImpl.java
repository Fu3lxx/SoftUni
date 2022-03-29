package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.ticket.TicketSeedDto;
import softuni.exam.models.dtos.ticket.TicketSeedRootDto;
import softuni.exam.models.entities.Passenger;
import softuni.exam.models.entities.Plane;
import softuni.exam.models.entities.Ticket;
import softuni.exam.models.entities.Town;
import softuni.exam.repository.TicketRepository;
import softuni.exam.service.PassengerService;
import softuni.exam.service.PlaneService;
import softuni.exam.service.TicketService;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class TicketServiceImpl implements TicketService {

    private final XmlParser xmlParser;
    private final ValidationUtil validator;
    private final ModelMapper modelMapper;
    private final TicketRepository ticketRepository;
    private final TownService townService;
    private final PlaneService planeService;
    private final PassengerService passengerService;
    private static final String FILE_PATH = "src/main/resources/files/xml/tickets.xml";

    public TicketServiceImpl(XmlParser xmlParser, ValidationUtil validationUtil, ModelMapper modelMapper, TicketRepository ticketRepository,
                             TownService townService, PlaneService planeService, PassengerService passengerService) {
        this.xmlParser = xmlParser;
        this.validator = validationUtil;
        this.modelMapper = modelMapper;
        this.ticketRepository = ticketRepository;
        this.townService = townService;
        this.planeService = planeService;
        this.passengerService = passengerService;
    }

    @Override
    public boolean areImported() {
        return ticketRepository.count() > 0;
    }

    @Override
    public String readTicketsFileContent() throws IOException {
        return Files.readString(Path.of(FILE_PATH));
    }

    @Override
    public String importTickets() throws JAXBException, FileNotFoundException {
        StringBuilder output = new StringBuilder();
        TicketSeedRootDto ticketSeedRootDto = xmlParser.fromFile(FILE_PATH,TicketSeedRootDto.class);

        for (TicketSeedDto ticketSeedDto: ticketSeedRootDto.getTickets()){
            boolean isValid = validator.isValid(ticketSeedDto);

            if (isValid){
                Ticket ticket = modelMapper.map(ticketSeedDto,Ticket.class);
                Town fromTown = townService.findTownByName(ticketSeedDto.getFromTown().getName());
                Town toTown = townService.findTownByName(ticketSeedDto.getToTown().getName());
                Passenger passenger = passengerService.getPassengerByEmail(ticketSeedDto.getPassenger().getEmail());
                Plane plane = planeService.findPlaneByRegNumber(ticketSeedDto.getPlane().getRegisterNumber());

                ticket.setFromTown(fromTown);
                ticket.setToTown(toTown);
                ticket.setPassenger(passenger);
                ticket.setPlane(plane);
                ticketRepository.save(ticket);
                output.append(String.format("Successfully imported Ticket %s – %s",
                        ticketSeedDto.getFromTown().getName(),ticketSeedDto.getToTown().getName()));
            }else {
                output.append("Invalid Ticket");
            }
            output.append(System.lineSeparator());
        }

        return output.toString();
    }
}
