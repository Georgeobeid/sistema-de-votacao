package com.georgeobeid.sistemadevotacao.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "empreendimentos")
public class Empreendimentos {
    @Id
    private Long id;
    private String nome;
    private String enderecoImagem;

    @OneToMany(mappedBy = "idEmpreendimento")
    private List<Votacao> votacaos;

    public List<Votacao> getVotacaos() {
        return votacaos;
    }

    public void setVotacaos(List<Votacao> votacaos) {
        this.votacaos = votacaos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEnderecoImagem() {
        return enderecoImagem;
    }

    public void setEnderecoImagem(String enderecoImagem) {
        this.enderecoImagem = enderecoImagem;
    }

}
