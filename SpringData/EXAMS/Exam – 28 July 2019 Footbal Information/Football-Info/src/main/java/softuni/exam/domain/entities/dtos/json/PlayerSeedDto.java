package softuni.exam.domain.entities.dtos.json;

import com.google.gson.annotations.Expose;
import softuni.exam.domain.entities.enums.Position;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class PlayerSeedDto {

    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private int number;
    @Expose
    private BigDecimal salary;
    @Expose
    private Position position;
    @Expose
    private PictureUrlDto picture;
    @Expose
    private TeamNameDto team;

    @NotBlank
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @NotBlank
    @Size (min = 3,max = 15)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Min(1)
    @Max(99)
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Min(0)
    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @NotNull

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public PictureUrlDto getPicture() {
        return picture;
    }

    public void setPicture(PictureUrlDto picture) {
        this.picture = picture;
    }

    public TeamNameDto getTeam() {
        return team;
    }

    public void setTeam(TeamNameDto team) {
        this.team = team;
    }
}
