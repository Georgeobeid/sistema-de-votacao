package com.georgeobeid.sistemadevotacao.controller;

import com.georgeobeid.sistemadevotacao.model.Empreendimentos;
import com.georgeobeid.sistemadevotacao.repository.EmpreendimentosRepository;
import com.georgeobeid.sistemadevotacao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/empreedimentos")
public class EmpreendimentosController {
    @Autowired
    private UserService userService;
    @Autowired
    private EmpreendimentosRepository empreendimentosRepository;

    @GetMapping(path = "/view")
    public @ResponseBody
    String viewTest() {
        return "found";
    }

    @PostMapping(path = "/registration")
    public @ResponseBody
    String addNewEmp(@RequestParam String name, @RequestParam String imgUrl) {
        Empreendimentos em = new Empreendimentos();
        em.setNome(name);
        em.setEnderecoImagem(imgUrl);
        empreendimentosRepository.save(em);
        return "Saved";
    }
}
