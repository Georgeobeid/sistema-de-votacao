package com.georgeobeid.sistemadevotacao.service;

import com.georgeobeid.sistemadevotacao.model.Empreendimentos;

import java.util.Optional;

public interface EmpreendimentoService {
    Optional<Empreendimentos> findById(Long empreendimentoId);
}
