package com.georgeobeid.sistemadevotacao.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
