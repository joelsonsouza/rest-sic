package com.sic.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sic.apirest.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
        Usuario findByLogin(String login);
}
