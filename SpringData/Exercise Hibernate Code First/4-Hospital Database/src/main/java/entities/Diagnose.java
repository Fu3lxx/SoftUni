package entities;

import entities.interfaces.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "diagnose")
public class Diagnose extends BaseEntity {

    private String name;
    private String comments;

    public Diagnose(String name, String comments) {
        this.name = name;
        this.comments = comments;
    }

    @Column(name = "name",nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "coments")
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
