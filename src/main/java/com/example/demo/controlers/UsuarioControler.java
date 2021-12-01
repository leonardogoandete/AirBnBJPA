package com.example.demo.controlers;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/clientes")
public class UsuarioControler {
    @Autowired
    private UsuarioRepository usuarioRepo;

    // lista usuarios
    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioRepo.findAll();
    }

    @GetMapping("/{id}")
    public Usuario listaUsuarioId(@PathVariable Long id){
        return usuarioRepo.findById(id).get();
    }

    // cadastra um usuario
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario adicionarUsuario(@RequestBody Usuario usuario){
        return usuarioRepo.save(usuario);
    }

    // deleta um usuario
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletaUsuario(@PathVariable Long id){
        usuarioRepo.deleteById(id);
    }

}
