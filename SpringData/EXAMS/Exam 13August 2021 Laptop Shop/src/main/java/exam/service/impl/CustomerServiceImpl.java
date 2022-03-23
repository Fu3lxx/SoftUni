package exam.service.impl;

import com.google.gson.Gson;
import exam.model.dto.customer.CustomerSeedDto;
import exam.model.entity.Customer;
import exam.model.entity.Town;
import exam.repository.CustomerRepository;
import exam.service.CustomerService;
import exam.service.TownService;
import exam.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validator;
    private final TownService townService;
    public static final String FILE_PATH = "src/main/resources/files/json/customers.json";

    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper,
                               Gson gson, ValidationUtil validator, TownService townService) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validator = validator;
        this.townService = townService;
    }


    @Override
    public boolean areImported() {
        return customerRepository.count() > 0;
    }

    @Override
    public String readCustomersFileContent() throws IOException {
        return Files.readString(Path.of(FILE_PATH));
    }

    @Override
    public String importCustomers() throws IOException {
        StringBuilder output = new StringBuilder();
        CustomerSeedDto[] customers = gson.fromJson(readCustomersFileContent(),CustomerSeedDto[].class);

        for (CustomerSeedDto customerDto : customers) {
            boolean isValid = validator.isValid(customerDto);

            if (isValid && !alreadyTakenEmail(customerDto.getEmail()) ){
                Customer customer = modelMapper.map(customerDto,Customer.class);
                Town town = townService.getTownByName(customerDto.getTown().getName());
                customer.setTown(town);

                customerRepository.save(customer);
                output.append(String.format("Successfully imported Customer %s %s - %s",customerDto.getFirstName()
                        ,customerDto.getLastName(),customerDto.getEmail()));
            }else {
                output.append("Invalid Customer");
            }
            output.append(System.lineSeparator());
        }
        return output.toString();
    }

    @Override
    public boolean alreadyTakenEmail(String email) {
        Customer customer = customerRepository.findByEmail(email);
        if (customer != null){
            return true;
        }
        return false;
    }
}
