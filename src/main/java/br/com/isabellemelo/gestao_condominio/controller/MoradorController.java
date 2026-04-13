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

    //metodo para atualizar um morador existente
    @PutMapping("/{id}")
    public Morador atualizar(@PathVariable Long id, @RequestBody Morador moradorAtualizado){
        // Primeiro, o sistema vai no banco procurar se o morador existe
        Morador moradorExistente = repository.findById(id).orElseThrow();

        // Atualiza os dados com o que veio da internet
        moradorExistente.setNome(moradorAtualizado.getNome());
        moradorExistente.setApartamento(moradorAtualizado.getApartamento());
        moradorExistente.setEmail(moradorAtualizado.getEmail());

        // Salva as alterações no banco
        return repository.save(moradorExistente);
    }

    // Método para Deletar um morador
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        repository.deleteById(id);
    }

}