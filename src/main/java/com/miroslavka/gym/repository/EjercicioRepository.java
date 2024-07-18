package com.miroslavka.gym.repository;

import com.miroslavka.gym.entity.Ejercicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EjercicioRepository extends JpaRepository <Ejercicio, Integer> {

    Optional<Ejercicio> findByEjercicio (String nombre);
}
