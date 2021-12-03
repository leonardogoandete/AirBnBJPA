package com.example.demo.service;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository userRepo;

    public void addUsuario(Usuario usr){
        userRepo.save(usr);
    }

    public void apaga(Long id){
        userRepo.deleteById(id);
    }

    public List<Usuario> buscaNome(String filtro){
        return (filtro != null) ? userRepo.findByUserContaining(filtro) : userRepo.findAll();
    }
}
