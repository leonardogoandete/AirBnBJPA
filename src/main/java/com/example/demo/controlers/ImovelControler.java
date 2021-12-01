package com.example.demo.controlers;

import com.example.demo.model.Imovel;
import com.example.demo.model.Usuario;
import com.example.demo.repository.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/imoveis")
public class ImovelControler {
    @Autowired
    private ImovelRepository imovelRepo;

    // lista de imoveis
    @GetMapping
    public List<Imovel> listarImovel() {
        return imovelRepo.findAll();
    }

    @GetMapping("/{id}")
    public Imovel listaImovelId(@PathVariable Long id){
        return imovelRepo.findById(id).get();
    }

    // cadastra imovel
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Imovel adicionarImovel(@RequestBody Imovel imovel) {
        return imovelRepo.save(imovel);
    }

    // deleta um imovel
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletaImovel(@PathVariable Long id) {
        imovelRepo.deleteById(id);
    }
}
