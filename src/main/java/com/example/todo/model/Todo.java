package com.example.todo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity //creating table in database using java classes

public class Todo {
    @Id // use tp make primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // use to auto increment
    private int id;
    private String title;
    private boolean status;

}
