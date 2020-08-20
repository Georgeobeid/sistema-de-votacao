package com.georgeobeid.sistemadevotacao.controller;

import com.georgeobeid.sistemadevotacao.model.Empreendimentos;
import com.georgeobeid.sistemadevotacao.model.User;
import com.georgeobeid.sistemadevotacao.repository.EmpreendimentosRepository;
import com.georgeobeid.sistemadevotacao.service.SecurityService;
import com.georgeobeid.sistemadevotacao.service.UserService;
import com.georgeobeid.sistemadevotacao.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    EmpreendimentosRepository empreendimentosRepository;


    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @GetMapping({"/", "/welcome"})
    public String welcome(Model model) {

        Optional<Empreendimentos> e1 = empreendimentosRepository.findBynome("Le Jardin");
        Optional<Empreendimentos> e2 = empreendimentosRepository.findBynome("Evian");
        Optional<Empreendimentos> e3 = empreendimentosRepository.findBynome("Olimpia Thermas");
        if (e1.isPresent() && e2.isPresent() && e3.isPresent()) {
            return "welcome";
        } else {
            Empreendimentos empreendimentoLeJardin = new Empreendimentos();
            empreendimentoLeJardin.setId(1L);
            empreendimentoLeJardin.setNome("Le Jardin");
            empreendimentoLeJardin.setEnderecoImagem(null); //Caso precisar
            empreendimentosRepository.save(empreendimentoLeJardin);

            Empreendimentos empreendimentoEvian = new Empreendimentos();
            empreendimentoEvian.setId(2L);
            empreendimentoEvian.setNome("Evian");
            empreendimentoEvian.setEnderecoImagem(null);//Caso precisar
            empreendimentosRepository.save(empreendimentoEvian);

            Empreendimentos empreendimentoOlimpiaThermas = new Empreendimentos();
            empreendimentoOlimpiaThermas.setId(3L);
            empreendimentoOlimpiaThermas.setNome("Olimpia Thermas");
            empreendimentoOlimpiaThermas.setEnderecoImagem(null);//Caso precisar
            empreendimentosRepository.save(empreendimentoOlimpiaThermas);
        }
        return "welcome";
    }
}
