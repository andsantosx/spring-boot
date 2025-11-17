package com.spring_boot.api.repositories;

import com.spring_boot.api.domain.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {
    Optional<Tecnico> findByCpf(String cpf);
    Optional<Tecnico> findByEmail(String email);
}
