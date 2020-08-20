package com.georgeobeid.sistemadevotacao.controller;

import com.georgeobeid.sistemadevotacao.model.Empreendimentos;
import com.georgeobeid.sistemadevotacao.model.User;
import com.georgeobeid.sistemadevotacao.model.Votacao;
import com.georgeobeid.sistemadevotacao.repository.EmpreendimentosRepository;
import com.georgeobeid.sistemadevotacao.repository.UserRepository;
import com.georgeobeid.sistemadevotacao.repository.VotosRepository;
import com.georgeobeid.sistemadevotacao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/votos")
public class VotosController {
    @Autowired
    private UserService userService;
    @Autowired
    private EmpreendimentosRepository empreendimentosRepository;
    @Autowired
    private VotosRepository votosRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/votoslejardin")
    public @ResponseBody
    String getAllVotosLeJardin() {
        int i = 0;
        Optional<Empreendimentos> emp = empreendimentosRepository.findById(1L);
        List<Votacao> votosList = votosRepository.findByidEmpreendimento(emp.get());
        List<String> nomes = new ArrayList<>();
        for (Votacao vot : votosList) {
            nomes.add(vot.getIdUser().getUsername());
            i++;
        }
        String todosOsNomes = "As " + i + " pessoas que votaram no Le Jardin sao : " + nomes;
        return todosOsNomes;
    }

    @GetMapping(path = "/votosevian")
    public @ResponseBody
    String getAllVotosEvian() {
        int i = 0;
        Optional<Empreendimentos> emp = empreendimentosRepository.findById(2L);
        List<Votacao> votosList = votosRepository.findByidEmpreendimento(emp.get());
        List<String> nomes = new ArrayList<>();
        for (Votacao vot : votosList) {
            nomes.add(vot.getIdUser().getUsername());
            i++;
        }
        String todosOsNomes = "As " + i + " pessoas que votaram no Evian sao : " + nomes;
        return todosOsNomes;
    }

    @GetMapping(path = "/votosolimpiathermas")
    public @ResponseBody
    String getAllVotosOlimpiaThermas() {
        int i = 0;
        Optional<Empreendimentos> emp = empreendimentosRepository.findById(3L);
        List<Votacao> votosList = votosRepository.findByidEmpreendimento(emp.get());
        List<String> nomes = new ArrayList<>();
        for (Votacao vot : votosList) {
            nomes.add(vot.getIdUser().getUsername());
            i++;
        }
        String todosOsNomes = "As " + i + " pessoas que votaram no Olimpia-Thermas sao : " + nomes;
        return todosOsNomes;
    }

    @RequestMapping(value = "/votar", method = RequestMethod.POST)
    public @ResponseBody
    String addVotar(@RequestParam("username") String username, @RequestParam("empid") String empid) {
        Votacao votacao = new Votacao();
        User usuario = userRepository.findByUsername(username);
        Optional<Empreendimentos> em = empreendimentosRepository.findById((Long.parseLong(empid)));
        Optional<Votacao> votacao1 = votosRepository.findByIdUser(usuario);

        if (votacao1.isPresent()) {
            return "Você ja votou!!";
        } else {
            if (em.isPresent()) {
                votacao.setIdUser(usuario);
                votacao.setIdEmpreendimento(em.get());
                votosRepository.save(votacao);
            } else {
                return "não foi encontrado um dos dois";
            }
        }

        return "Agradecemos seu voto.";
    }
}
