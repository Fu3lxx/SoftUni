package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.passenger.PassengerSeedDto;
import softuni.exam.models.entities.Passenger;
import softuni.exam.models.entities.Town;
import softuni.exam.repository.PassengerRepository;
import softuni.exam.service.PassengerService;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {

    private final PassengerRepository passengerRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validator;
    private final TownService townService;
    public static final String FILE_PATH = "src/main/resources/files/json/passengers.json";

    public PassengerServiceImpl(PassengerRepository passengerRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validator, TownService townService) {
        this.passengerRepository = passengerRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validator = validator;
        this.townService = townService;
    }

    @Override
    public boolean areImported() {
        return passengerRepository.count() > 0;
    }

    @Override
    public String readPassengersFileContent() throws IOException {
        return Files.readString(Path.of(FILE_PATH));
    }

    @Override
    public String importPassengers() throws IOException {
        StringBuilder output = new StringBuilder();
        PassengerSeedDto[] passengerSeedDtos = gson.fromJson(readPassengersFileContent(),PassengerSeedDto[].class);

        for (PassengerSeedDto passengerSeedDto : passengerSeedDtos) {
            boolean isValid = validator.isValid(passengerSeedDto);

            if (isValid){
                Passenger passenger = modelMapper.map(passengerSeedDto,Passenger.class);
                Town town = townService.findTownByName(passengerSeedDto.getTown());
                passenger.setTown(town);
                passengerRepository.save(passenger);
                output.append(String.format("Successfully imported Passenger %s - %s",
                        passenger.getLastName(),passenger.getEmail()));
            }else {
                output.append("Invalid Passenger");
            }
            output.append(System.lineSeparator());
        }

        return output.toString();
    }

    @Override
    public Passenger getPassengerByEmail(String email) {
        return passengerRepository.findByEmail(email);
    }

    @Override
    public String getPassengersOrderByTicketsCountDescendingThenByEmail() {
        List<Passenger> passengers = passengerRepository.findallOrderByTicketsCountAndEmail();
        StringBuilder output = new StringBuilder();
        for (Passenger passenger : passengers) {
            output.append(String.format("Passenger %s  %s%n",passenger.getFirstName(),passenger.getLastName()));
            output.append(String.format("\tEmail - %s%n",passenger.getEmail()));
            output.append(String.format("\tPhone - %s%n",passenger.getPhoneNumber()));
            output.append(String.format("\tNumber of tickets - %d%n",passenger.getTickets().size()));
            output.append(System.lineSeparator());
        }
        return output.toString();
    }
}
