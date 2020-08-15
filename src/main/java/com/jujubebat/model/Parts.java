package com.jujubebat.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Parts {

    @Id
    @GeneratedValue
    private Long id;

    private int price;

    @ManyToMany
    private List<Car> cars = new ArrayList<>();

}
