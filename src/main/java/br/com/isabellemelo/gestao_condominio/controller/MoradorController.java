package br.com.isabellemelo.gestao_condominio.controller;

import br.com.isabellemelo.gestao_condominio.model.Morador;
import br.com.isabellemelo.gestao_condominio.repository.MoradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moradores")
public class MoradorController {

    @Autowired
    private MoradorRepository repository;

    @PostMapping
    public Morador cadastrar(@RequestBody Morador morador) {
        return repository.save(morador);
    }
    @GetMapping
    public List<Morador> listar() {
        return repository.findAll();
    }
}