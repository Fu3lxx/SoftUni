package softuni.exam.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "towns")
public class Town extends BaseEntity{

    private String townName;
    private int population;

    @Column (name = "town_name",unique = true,nullable = false)
    public String getTownName() {
        return townName;
    }

    public void setTownName(String name) {
        this.townName = name;
    }

    @Column(nullable = false)
    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
