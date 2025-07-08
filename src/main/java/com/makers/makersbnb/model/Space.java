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
    @Setter(AccessLevel.NONE)
    private Long id;

    private String name;
    private String description;
    private Number price;

    public Space(String name, String description, Number price){
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
