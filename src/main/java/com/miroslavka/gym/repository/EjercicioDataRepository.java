package com.miroslavka.gym.repository;

import com.miroslavka.gym.entity.Ejercicio;
import com.miroslavka.gym.entity.EjercicioData;
import com.miroslavka.gym.entity.GrupoMuscular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EjercicioDataRepository extends JpaRepository<EjercicioData, Integer> {


    Optional<EjercicioData> findByNombre(String nombre);
    List<EjercicioData> findByGrupoMuscular (GrupoMuscular grupoMuscular);

}
