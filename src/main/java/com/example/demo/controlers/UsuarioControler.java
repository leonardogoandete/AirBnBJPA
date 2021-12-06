package com.example.demo.controlers;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/clientes")
public class UsuarioControler {

    private final PasswordEncoder encoder;

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    private UsuarioService usuarioServ;

    public UsuarioControler(PasswordEncoder encoder, UsuarioRepository usuarioRepo) {
        this.encoder = encoder;
        this.usuarioRepo = usuarioRepo;
    }


    @GetMapping()
    public List<Usuario> listarUsuariosFiltro(@RequestParam(required = false) String filtro){
        return usuarioServ.buscaNome(filtro);
    }

    @GetMapping("/{id}")
    public Usuario listaUsuarioId(@PathVariable Long id){
        return usuarioRepo.findById(id).get();
    }

    // cadastra um usuario
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void adicionarUsuario(@RequestBody Usuario usuario){
        usuario.setSenha(encoder.encode(usuario.getSenha()));
        usuarioServ.addUsuario(usuario);
    }

    // deleta um usuario
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletaUsuario(@PathVariable Long id){
        usuarioServ.apaga(id);
    }


}
