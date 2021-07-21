package org.primefaces.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import lombok.Data;
import lombok.Value;

@Data
@Named
@ViewScoped
public class TestView implements Serializable {
    
    private List<Car> data = new ArrayList<>();

    private List<String> colors = Arrays.asList(
        "Black", "White", "Green", "Red", "Blue", "Orange", "Silver", "Yellow", "Brown", "Maroon"
    );

    private List<String> brands = Arrays.asList(
        "BMW", "Mercedes", "Volvo", "Audi", "Renault", "Fiat", "Volkswagen", "Honda", "Jagular", "Ford"
    );

    @PostConstruct
    void init() {
        IntStream.range(0, 30).mapToObj(i -> new Car(getRandomId(), getRandomBrand(), getRandomColor(), getRandomYear())).forEach(data::add);
    }

    private String getRandomId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
    private String getRandomBrand() {
        return brands.get((int) (Math.random()*10));
    }
    private String getRandomColor() {
        return colors.get((int) (Math.random()*10));
    }
    private int getRandomYear() {
        return (int) (Math.random()*50*1960);
    }

    @Value
    public static class Car {
        private String id;
        private String brand;
        private String color;
        private int year;
    }

}
