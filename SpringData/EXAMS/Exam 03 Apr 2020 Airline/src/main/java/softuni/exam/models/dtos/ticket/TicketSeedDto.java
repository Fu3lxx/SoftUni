package softuni.exam.models.dtos.ticket;

import com.sun.istack.NotNull;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

@XmlAccessorType (XmlAccessType.FIELD)
public class TicketSeedDto {

    @XmlElement (name = "serial-number" )
    private String serialNumber;
    @XmlElement (name = "price")
    private BigDecimal price;
    @XmlElement(name = "take-off")
    private String takeoff;
    @XmlElement (name = "from-town")
    private TownNameDto fromTown;
    @XmlElement (name = "to-town")
    private TownNameDto toTown;
    @XmlElement
    private TicketPassengerNameDto passenger;
    @XmlElement
    private TicketPlaneNumberDto plane;

    @Size (min = 2)
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Positive
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTakeoff() {
        return takeoff;
    }

    public void setTakeoff(String takeoff) {
        this.takeoff = takeoff;
    }

    public TownNameDto getFromTown() {
        return fromTown;
    }

    public void setFromTown(TownNameDto fromTown) {
        this.fromTown = fromTown;
    }

    public TownNameDto getToTown() {
        return toTown;
    }

    public void setToTown(TownNameDto toTown) {
        this.toTown = toTown;
    }

    public TicketPassengerNameDto getPassenger() {
        return passenger;
    }

    public void setPassenger(TicketPassengerNameDto passenger) {
        this.passenger = passenger;
    }

    public TicketPlaneNumberDto getPlane() {
        return plane;
    }

    public void setPlane(TicketPlaneNumberDto plane) {
        this.plane = plane;
    }
}
