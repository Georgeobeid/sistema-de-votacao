package com.georgeobeid.sistemadevotacao.repository;

import com.georgeobeid.sistemadevotacao.model.Empreendimentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpreendimentosRepository extends JpaRepository<Empreendimentos, Long> {
    Optional<Empreendimentos> findBynome(String nome);
}
