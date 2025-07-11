package com.makers.makersbnb.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Table(name = "spaces")
@Getter @Setter @NoArgsConstructor
public class Space {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PROTECTED)
    private Long id;

    private String name;
    private String weather;
    private float price;
    private Date available_date;

    public Space(String name, String weather, float price, Date available_date){
        this.name = name;
        this.weather = weather;
        this.price = price;
        this.available_date = available_date;
    }
}
