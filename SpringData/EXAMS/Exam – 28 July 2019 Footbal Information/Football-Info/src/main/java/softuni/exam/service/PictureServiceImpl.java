package softuni.exam.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.domain.entities.Picture;
import softuni.exam.domain.entities.dtos.xml.picture.PictureSeedDto;
import softuni.exam.domain.entities.dtos.xml.picture.PictureSeedRootDto;
import softuni.exam.repository.PictureRepository;
import softuni.exam.util.FileUtilImpl;
import softuni.exam.util.ValidatorUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;

@Service
public class PictureServiceImpl implements PictureService {

    private final ValidatorUtil validator;
    private final PictureRepository pictureRepository;
    private final ModelMapper modelMapper;
    private final FileUtilImpl fileUtil;
    private final XmlParser xmlParser;
    public static final String FILE_PATH = "src/main/resources/files/xml/pictures.xml";

    public PictureServiceImpl(ValidatorUtil validator, PictureRepository pictureRepository, ModelMapper modelMapper, FileUtilImpl fileUtil, XmlParser xmlParser) {
        this.validator = validator;
        this.pictureRepository = pictureRepository;
        this.modelMapper = modelMapper;
        this.fileUtil = fileUtil;
        this.xmlParser = xmlParser;
    }

    @Override
    public String importPictures() throws JAXBException, FileNotFoundException {
        StringBuilder output = new StringBuilder();
        PictureSeedRootDto pictureSeedRootDto = xmlParser.fromFile(FILE_PATH,PictureSeedRootDto.class);
        System.out.println();
        for (PictureSeedDto pictureDto:pictureSeedRootDto.getPictures()){
            boolean isValid = validator.isValid(pictureDto);

            if (isValid){
                Picture picture = modelMapper.map(pictureDto,Picture.class);
                pictureRepository.save(picture);
                output.append(String.format("Successfully imported picture - %s",picture.getUrl()));
            }else {
                output.append("Invalid picture");
            }
            output.append(System.lineSeparator());
        }

        return output.toString();
    }

    @Override
    public boolean areImported() {
        return pictureRepository.count() > 0;
    }

    @Override
    public String readPicturesXmlFile() throws IOException {
        return fileUtil.readFile(FILE_PATH);
    }

    @Override
    public Picture findByPictureUrl(String url) {
        return pictureRepository.findByUrl(url);
    }

}
