package exam.service.impl;

import exam.model.dto.shop.ShopSeedDto;
import exam.model.dto.shop.ShopSeedRootDto;
import exam.model.entity.Shop;
import exam.model.entity.Town;
import exam.repository.ShopRepository;
import exam.service.ShopService;
import exam.service.TownService;
import exam.util.ValidationUtil;
import exam.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class ShopServiceImpl implements ShopService {

    private final XmlParser xmlParser;
    private final ShopRepository shopRepository;
    private final ValidationUtil validator;
    private final ModelMapper modelMapper;
    private final TownService townService;
    private static final String FILE_PATH = "src/main/resources/files/xml/shops.xml";

    public ShopServiceImpl(XmlParser xmlParser, ShopRepository shopRepository, ValidationUtil validator, ModelMapper modelMapper, TownService townService) {
        this.xmlParser = xmlParser;
        this.shopRepository = shopRepository;
        this.validator = validator;
        this.modelMapper = modelMapper;
        this.townService = townService;
    }

    @Override
    public boolean areImported() {
        return shopRepository.count() > 0;
    }

    @Override
    public String readShopsFileContent() throws IOException {
        return Files.readString(Path.of(FILE_PATH));
    }

    @Override
    public String importShops() throws JAXBException, FileNotFoundException {
        StringBuilder output = new StringBuilder();

        ShopSeedRootDto shopSeedRootDto = xmlParser.fromFile(FILE_PATH,ShopSeedRootDto.class);
        for (ShopSeedDto shopDto:shopSeedRootDto.getShops()){
            boolean isValid = validator.isValid(shopDto);

            if (isValid && shopRepository.findByName(shopDto.getName()) == null){
                Town town = townService.getTownByName(shopDto.getTown().getName());
                Shop shop = modelMapper.map(shopDto,Shop.class);
                shop.setTown(town);
                shopRepository.save(shop);
                output.append(String.format("Successfully imported Shop %s - %.0f",shopDto.getName(),shopDto.getIncome()));

            }else {
                output.append("Invalid shop");
            }
            output.append(System.lineSeparator());
        }

        return output.toString();
    }

    @Override
    public boolean isThereShopWithName(String name) {
        Shop shop = shopRepository.findByName(name);
        if (shop != null){
            return true;
        }
        return false;
    }

    @Override
    public Shop findShopByName(String name) {
        return shopRepository.findByName(name);
    }
}
