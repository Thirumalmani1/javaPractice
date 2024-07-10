package net.javaguides.ems.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Coffee {
    private String name;
    private String brand;
    private LocalDateTime date;

    public Coffee(String name, String brand, LocalDateTime date) {
        this.name = name;
        this.brand = brand;
        this.date = date;
    }}
