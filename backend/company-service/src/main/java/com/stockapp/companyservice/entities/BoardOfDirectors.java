package com.stockapp.companyservice.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
public class BoardOfDirectors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public BoardOfDirectors(){

    }

    public BoardOfDirectors(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}