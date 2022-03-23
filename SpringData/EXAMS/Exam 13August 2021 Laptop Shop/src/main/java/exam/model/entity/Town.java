package exam.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "towns")
public class Town extends BaseEntity{

    private String name;
    private int population;
    private String travelGuide;


    @Column(unique = true,nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Column (name = "travel_guide",columnDefinition = "TEXT",nullable = false)
    public String getTravelGuide() {
        return travelGuide;
    }

    public void setTravelGuide(String travelGuild) {
        this.travelGuide = travelGuild;
    }


}
