package exam.service.impl;

import com.google.gson.Gson;
import exam.model.dto.laptop.LaptopSeedDto;
import exam.model.entity.Laptop;
import exam.model.entity.Shop;
import exam.repository.LaptopRepository;
import exam.service.LaptopService;
import exam.service.ShopService;
import exam.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class LaptopServiceImpl implements LaptopService {

    private final LaptopRepository laptopRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validator;
    private final Gson gson;
    private final ShopService shopService;
    public static final String FILE_PATH = "src/main/resources/files/json/laptops.json";

    public LaptopServiceImpl(LaptopRepository laptopRepository, ModelMapper modelMapper, ValidationUtil validator,
                             Gson gson, ShopService shopService) {
        this.laptopRepository = laptopRepository;
        this.modelMapper = modelMapper;
        this.validator = validator;
        this.gson = gson;
        this.shopService = shopService;
    }


    @Override
    public boolean areImported() {
        return laptopRepository.count() > 0;
    }

    @Override
    public String readLaptopsFileContent() throws IOException {
        return Files.readString(Path.of(FILE_PATH));
    }

    @Override
    public String importLaptops() throws IOException {
        StringBuilder output = new StringBuilder();
        LaptopSeedDto[] laptopDtos = gson.fromJson(readLaptopsFileContent(),LaptopSeedDto[].class);

        for (LaptopSeedDto laptopDto : laptopDtos) {
            boolean isValid = validator.isValid(laptopDto);

            if (isValid && laptopRepository.findByMacAddress(laptopDto.getMacAddress()) == null){
                Laptop laptop = modelMapper.map(laptopDto,Laptop.class);
                Shop shop = shopService.findShopByName(laptopDto.getShop().getName());
                laptop.setShop(shop);

                laptopRepository.save(laptop);
                output.append(String.format("Successfully imported Laptop %s-%.2f-%d-%d",
                        laptopDto.getMacAddress(),laptopDto.getCpuSpeed(),laptopDto.getRam(),laptopDto.getStorage()));
            }
            else {
                output.append("Invalid Laptop");
            }
            output.append(System.lineSeparator());
        }

        return output.toString();
    }

    @Override
    public String exportBestLaptops() {
        List<Laptop> laptops = laptopRepository.findBestLaptops();
        StringBuilder output = new StringBuilder();

        for (Laptop laptop : laptops) {
            output.append(String.format("Laptop - %s%n",laptop.getMacAddress()));
            output.append(String.format("*Cpu speed - %.2f%n",laptop.getCpuSpeed()));
            output.append(String.format("**Ram - %d%n",laptop.getRam()));
            output.append(String.format("***Storage - %d%n",laptop.getStorage()));
            output.append(String.format("****Price - %.2f%n",laptop.getPrice()));
            output.append(String.format("#Shop name - %s%n",laptop.getShop().getName()));
            output.append(String.format("##Town - %s%n",laptop.getShop().getTown().getName()));
            output.append(System.lineSeparator());
        }
        return output.toString();
    }
}
