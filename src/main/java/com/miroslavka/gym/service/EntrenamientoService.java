package com.miroslavka.gym.service;

import com.miroslavka.gym.dtos.EjercicioDto;
import com.miroslavka.gym.entity.Ejercicio;
import com.miroslavka.gym.entity.EjercicioData;
import com.miroslavka.gym.entity.Entrenamiento;
import com.miroslavka.gym.entity.Usuario;
import com.miroslavka.gym.repository.EjercicioDataRepository;
import com.miroslavka.gym.repository.EjercicioRepository;
import com.miroslavka.gym.repository.EntrenamientoRepository;
import com.miroslavka.gym.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EntrenamientoService {


    @Autowired
    private EntrenamientoRepository entrenamientoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EjercicioRepository ejercicioRepository;

    @Autowired
    private EjercicioDataRepository ejercicioDataRepository;


    public Entrenamiento crearEntrenamiento(String entrenamiento, String observaciones, Integer userId) {

        if (entrenamientoRepository.findByEntrenamiento(entrenamiento).isPresent()) {
            throw new IllegalArgumentException("El entrenamiento con ese nombre ya existe.");
        }
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(userId);
        if (usuarioOptional.isEmpty()) {
            throw new IllegalArgumentException("El usuario no existe.");
        }
        Usuario usuario = usuarioOptional.get();

        Entrenamiento training = new Entrenamiento(LocalDate.now(), observaciones, entrenamiento, usuario);
        return entrenamientoRepository.save(training);
    }

    public List<Entrenamiento> getTrainingsByUser(int userId) {
        return entrenamientoRepository.findByUsuarioId(userId);
    }


    public Entrenamiento anyadirEjercicioAEntrenamiento(int trainingId, EjercicioDto ejercicioDto) {
        Optional<Entrenamiento> optionalTraining = entrenamientoRepository.findById(trainingId);
        if (optionalTraining.isEmpty()) {
            throw new IllegalArgumentException("Entrenamiento no encontrado");
        }

        Optional<EjercicioData> optionalEjercicioData = this.ejercicioDataRepository.findById(ejercicioDto.getEjercicioDataId());
        if (optionalEjercicioData.isEmpty()) {
            throw new IllegalArgumentException("Ejercicio data no encontrado");
        }

        Entrenamiento entrenamiento = optionalTraining.get();
        EjercicioData ejercicioData = optionalEjercicioData.get();

        Ejercicio ejercicio = new Ejercicio();
        ejercicio.setEjercicio(ejercicioDto.getNombreEjercicio());
        ejercicio.setSeries(ejercicioDto.getSets());
        ejercicio.setReps(ejercicioDto.getReps());
        ejercicio.setPesos(ejercicioDto.getPesos());
        ejercicio.setEjercicioData(ejercicioData);
        ejercicio.setEntrenamiento(entrenamiento);

        ejercicioRepository.save(ejercicio);

        entrenamiento.getEjerciciosRealizados().add(ejercicio);
        entrenamientoRepository.save(entrenamiento);

        return entrenamiento;
    }

    public Ejercicio actualizarEjercicioEnEntrenamiento(int trainingId, int ejercicioId, EjercicioDto ejercicioDto) {
        Optional<Entrenamiento> optionalTraining = entrenamientoRepository.findById(trainingId);
        if (optionalTraining.isEmpty()) {
            throw new IllegalArgumentException("Entrenamiento no encontrado");
        }

        Entrenamiento entrenamiento = optionalTraining.get();
        Optional<Ejercicio> optionalEjercicio = ejercicioRepository.findById(ejercicioId);
        if (optionalEjercicio.isEmpty()) {
            throw new IllegalArgumentException("Ejercicio no encontrado");
        }
        Optional<EjercicioData> optionalEjercicioData = ejercicioDataRepository.findById(ejercicioDto.getEjercicioDataId());
        if (optionalEjercicioData.isEmpty()) {
            throw new IllegalArgumentException("EjercicioData no encontrado");
        }

        Ejercicio ejercicio = optionalEjercicio.get();
        ejercicio.setEjercicio(ejercicioDto.getNombreEjercicio());
        ejercicio.setSeries(ejercicioDto.getSets());
        ejercicio.setReps(ejercicioDto.getReps());
        ejercicio.setPesos(ejercicioDto.getPesos());
        ejercicio.setEjercicioData(optionalEjercicioData.get());

        ejercicioRepository.save(ejercicio);
        return ejercicio;
    }


    public boolean eliminarEjercicioDeEntrenamiento(int trainingId, int ejercicioId) {
        Optional<Entrenamiento> optionalTraining = entrenamientoRepository.findById(trainingId);
        if (optionalTraining.isEmpty()) {
            throw new IllegalArgumentException("Entrenamiento no encontrado");
        }

        Entrenamiento entrenamiento = optionalTraining.get();
        Optional<Ejercicio> optionalEjercicio = ejercicioRepository.findById(ejercicioId);
        if (optionalEjercicio.isEmpty()) {
            throw new IllegalArgumentException("Ejercicio no encontrado");
        }

        Ejercicio ejercicio = optionalEjercicio.get();
        if (entrenamiento.getEjerciciosRealizados().remove(ejercicio)) {
            ejercicioRepository.delete(ejercicio);
            entrenamientoRepository.save(entrenamiento);
            return true;
        }

        return false;
    }


    public List<Entrenamiento> recuperarTodosEntrenamientos() {

        List<Entrenamiento> todosEntrenamientos = entrenamientoRepository.findAll();
        if (todosEntrenamientos.isEmpty()) {
            throw new IllegalArgumentException("No hay entrenamientos");
        }

        return todosEntrenamientos;
    }


    public ResponseEntity borrarEntrenamientoXId(int id) {
        Optional<Entrenamiento> optionalTraining = entrenamientoRepository.findById(id);
        if (optionalTraining.isPresent()) {
            entrenamientoRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.FOUND).body("Entrenamiento eliminado exitosamente");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entrenamiento no existe");
    }
}
