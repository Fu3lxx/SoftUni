package softuni.exam.domain.entities.dtos.xml.teams;

import softuni.exam.domain.entities.dtos.xml.picture.PictureSeedDto;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType (XmlAccessType.FIELD)
public class TeamSeedDto {

    @XmlElement
    private String name;
    @XmlElement (name = "picture")
    private PictureSeedDto picture;

    @Size (min = 3,max = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PictureSeedDto getPicture() {
        return picture;
    }

    public void setPicture(PictureSeedDto picture) {
        this.picture = picture;
    }
}
