package softuni.exam.models.dto.xml.apartment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement (name = "apartments")
@XmlAccessorType (XmlAccessType.FIELD)
public class ApartmentRootSeedDto {

    private List<ApartmentSeedDto> apartamentss;

    @XmlElement (name = "apartment")
    public List<ApartmentSeedDto> getApartment() {
        return apartamentss;
    }

    public void setApartment(List<ApartmentSeedDto> apartment) {
        this.apartamentss = apartment;
    }
}
