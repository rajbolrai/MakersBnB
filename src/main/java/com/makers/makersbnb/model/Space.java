package com.makers.makersbnb.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "spaces")
@Getter @Setter @NoArgsConstructor
public class Space {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PROTECTED)
    private Long id;

    private String name;
    private String description;
    private float prices;

    public Space(String name, String description, float price){
        this.name = name;
        this.description = description;
        this.prices = price;
    }
}
