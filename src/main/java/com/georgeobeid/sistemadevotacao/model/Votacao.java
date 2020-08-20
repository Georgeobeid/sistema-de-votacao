package com.georgeobeid.sistemadevotacao.model;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

@Entity
@Table(name = "votos")
public class Votacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User idUser;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "empreendimentoId", referencedColumnName = "id")
    private Empreendimentos idEmpreendimento;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public Empreendimentos getIdEmpreendimento() {
        return idEmpreendimento;
    }

    public void setIdEmpreendimento(Empreendimentos idEmpreendimento) {
        this.idEmpreendimento = idEmpreendimento;
    }

    @Override
    public String toString() {
        return "Votacao{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", idEmpreendimento=" + idEmpreendimento +
                '}';
    }
}
