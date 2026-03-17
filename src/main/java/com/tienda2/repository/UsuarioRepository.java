package com.tienda2.repository;

import com.tienda2.domain.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
     Optional<Usuario> findByUsernameAndActivoTrue(String username);
    
}
