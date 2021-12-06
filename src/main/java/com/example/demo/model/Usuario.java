package com.example.demo.model;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)  // unique define o nome como unico
    private String user;

    @Column(nullable = false)
    private String senha;

    @Column
    private String tipo;

}