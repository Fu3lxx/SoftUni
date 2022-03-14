package com.example.xmlexercise.models.dto.userDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserViewRootDto {

    @XmlElement (name = "product")
    private List<UsersWithProductsDto> products;

    public UserViewRootDto() {
    }

    public List<UsersWithProductsDto> getProducts() {
        return products;
    }

    public void setProducts(List<UsersWithProductsDto> products) {
        this.products = products;
    }
}
