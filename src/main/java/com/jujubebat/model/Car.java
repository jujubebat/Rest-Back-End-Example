package com.jujubebat.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Entity
public class Car {

    @Id
    @GeneratedValue
    private Long id;

    private  String carName;

    @Column
    private  String speed;

    private  String weight;

    @ManyToMany
    private List<Parts> parts = new ArrayList<>();

    public Car(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) &&
                Objects.equals(carName, car.carName) &&
                Objects.equals(speed, car.speed) &&
                Objects.equals(weight, car.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, carName, speed, weight);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
