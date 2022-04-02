package softuni.exam.models.entity;

import softuni.exam.models.enums.ApartmentType;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table (name = "apartments")
public class Apartment extends BaseEntity{

    private ApartmentType apartmentType;
    private BigDecimal area;
    private Town town;

    @Enumerated (EnumType.STRING)
    public ApartmentType getApartmentType() {
        return apartmentType;
    }

    public void setApartmentType(ApartmentType apartmentType) {
        this.apartmentType = apartmentType;
    }

    @Column(nullable = false)
    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    @ManyToOne (fetch = FetchType.EAGER)
    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }
}
