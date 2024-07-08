package com.miroslavka.gym.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exercises")
public class ExercisesController {

    @GetMapping("/saludo")
    public String saludo (){
        return "Hola, mundo!";
    }
}
