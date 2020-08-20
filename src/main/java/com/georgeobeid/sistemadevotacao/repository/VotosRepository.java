package com.georgeobeid.sistemadevotacao.repository;

import com.georgeobeid.sistemadevotacao.model.Empreendimentos;
import com.georgeobeid.sistemadevotacao.model.User;
import com.georgeobeid.sistemadevotacao.model.Votacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VotosRepository extends JpaRepository<Votacao, Long> {
    Optional<Votacao> findByIdUser(User user);

    List<Votacao> findByidEmpreendimento(Empreendimentos empreendimentos);
}
