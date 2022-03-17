package com.example.xmlexercise.models.dto.userDto;

import com.example.xmlexercise.models.dto.productDto.ProductWhitBuyerDto;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement
@XmlAccessorType (XmlAccessType.FIELD)
public class UsersWithProductsDto {

    @XmlAttribute (name = "first-name")
    private String firstName;
    @XmlAttribute (name = "last-name")
    private String lastName;

    @XmlElement (name = "product")
    private List<ProductWhitBuyerDto> products;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<ProductWhitBuyerDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductWhitBuyerDto> products) {
        this.products = products;
    }
}
