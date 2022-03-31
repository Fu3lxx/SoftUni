package softuni.exam.domain.entities.dtos.json;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotBlank;

public class TeamNameDto {

    @Expose
    private String name;
    @Expose
    private PictureUrlDto picture;

    @NotBlank
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PictureUrlDto getPicture() {
        return picture;
    }

    public void setPicture(PictureUrlDto picture) {
        this.picture = picture;
    }
}
