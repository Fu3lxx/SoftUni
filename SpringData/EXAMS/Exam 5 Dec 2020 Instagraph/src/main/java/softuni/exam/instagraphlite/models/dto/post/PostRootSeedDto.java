package softuni.exam.instagraphlite.models.dto.post;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement (name = "posts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PostRootSeedDto {

    @XmlElement(name = "post")
    private List<PostSeedDto> postSeedDtos;

    public List<PostSeedDto> getPostSeedDtos() {
        return postSeedDtos;
    }

    public void setPostSeedDtos(List<PostSeedDto> postSeedDtos) {
        this.postSeedDtos = postSeedDtos;
    }
}
