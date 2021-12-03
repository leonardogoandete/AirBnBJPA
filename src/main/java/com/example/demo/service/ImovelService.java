package com.example.demo.service;

import com.example.demo.model.Imovel;
import com.example.demo.repository.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImovelService {

    @Autowired
    private ImovelRepository imovelRepo;

    public List<Imovel> buscaTipo(String tipo){
        return (tipo != null) ? imovelRepo.findByTipoContaining(tipo) : imovelRepo.findAll();
    }
}
