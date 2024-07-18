package com.miroslavka.gym.repository;

import com.miroslavka.gym.entity.Entrenamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EntrenamientoRepository extends JpaRepository<Entrenamiento, Integer> {

        Optional<Entrenamiento> findByEntrenamiento (String nombre);
}
