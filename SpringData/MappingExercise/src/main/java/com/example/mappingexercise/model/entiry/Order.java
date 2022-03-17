package com.example.mappingexercise.model.entiry;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table (name = "orders")
public class Order extends BaseEntity {


    private User buyer;

    private Set<Game> games;

    @ManyToOne
    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User user) {
        this.buyer = user;
    }

    @ManyToMany

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }
}
