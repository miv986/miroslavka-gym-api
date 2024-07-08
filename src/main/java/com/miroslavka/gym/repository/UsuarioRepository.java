package com.miroslavka.gym.repository;


import com.miroslavka.gym.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {


        Optional<Usuario> findByUsuario(String nombre);


}
