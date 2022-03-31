package softuni.exam.domain.entities.dtos.json;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotBlank;

public class PictureUrlDto {

    @Expose
    private String url;

    @NotBlank
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
