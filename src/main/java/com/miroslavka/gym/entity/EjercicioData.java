package com.miroslavka.gym.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ejercicioData")
public class EjercicioData {

    @Id
    private int id;

}
