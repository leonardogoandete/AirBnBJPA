package com.example.demo.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class Imovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String tipo;
    @Column(nullable = false)
    private String cidade;
    @Column(nullable = false)
    private double valor_diaria;
}
