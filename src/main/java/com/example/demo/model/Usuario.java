package com.example.demo.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String user;

    @Column(nullable = false)
    private String senha;

    @Column
    private String tipo;

}