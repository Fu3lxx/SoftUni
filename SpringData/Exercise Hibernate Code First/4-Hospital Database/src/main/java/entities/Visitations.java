package entities;

import entities.interfaces.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table (name = "visitations")

public class Visitations extends BaseEntity {

    private LocalDateTime date;
    private String comets;

    public Visitations(LocalDateTime date, String comets) {
        this.date = date;
        this.comets = comets;
    }

    @Column(name = "date",nullable = false)
    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Column (name = "coments")
    public String getComets() {
        return comets;
    }

    public void setComets(String comets) {
        this.comets = comets;
    }
}
