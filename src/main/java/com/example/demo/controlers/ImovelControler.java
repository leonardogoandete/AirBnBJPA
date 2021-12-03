package com.example.demo.controlers;

import com.example.demo.model.Imovel;
import com.example.demo.model.Usuario;
import com.example.demo.repository.ImovelRepository;
import com.example.demo.service.ImovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/imoveis")
public class ImovelControler {
    @Autowired
    private ImovelRepository imovelRepo;

    @Autowired
    private ImovelService imovelServ;

    // lista de imoveis
    @GetMapping
    public List<Imovel> listarImovel(@RequestParam(required = false)String tipo) {
        return imovelServ.buscaTipo(tipo);
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
