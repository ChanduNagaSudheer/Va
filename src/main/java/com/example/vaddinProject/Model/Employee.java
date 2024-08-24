package com.example.vaddinProject.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Employees")
@Getter
@Setter
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    private String company;
    private String location;
    private List<String> preference;

    public Employee( String name, String company, String location, List<String> preference) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.location = location;
        this.preference = preference;
    }
}
