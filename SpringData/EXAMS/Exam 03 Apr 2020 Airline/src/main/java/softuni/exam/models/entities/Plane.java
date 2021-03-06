package softuni.exam.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "planes")
public class Plane extends BaseEntity{

    private String registerNumber;
    private int capacity;
    private String airline;

    @Column (name = "register_number",unique = true)
    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    @Column
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Column (name = "air_line")
    public String getAirline() {
        return airline;
    }

    public void setAirline(String airLine) {
        this.airline = airLine;
    }
}
