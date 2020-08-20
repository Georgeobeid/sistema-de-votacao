package com.georgeobeid.sistemadevotacao.service;

import com.georgeobeid.sistemadevotacao.model.Empreendimentos;
import com.georgeobeid.sistemadevotacao.repository.EmpreendimentosRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class EmpreendimentoServiceImpl implements EmpreendimentoService {

    @Autowired
    EmpreendimentosRepository empreendimentosRepository;


    @Override
    public Optional<Empreendimentos> findById(Long empreendimentoId) {
        return empreendimentosRepository.findById(empreendimentoId);
    }
}
