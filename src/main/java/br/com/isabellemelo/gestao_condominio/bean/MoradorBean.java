package br.com.isabellemelo.gestao_condominio.bean; // Confirme o nome do seu pacote

import br.com.isabellemelo.gestao_condominio.model.Morador;
import br.com.isabellemelo.gestao_condominio.repository.MoradorRepository;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class MoradorBean implements Serializable {

    @Autowired
    private MoradorRepository repository;

    private List<Morador> moradores;
    private Morador novoMorador;

    // Esse método roda automaticamente assim que a tela abre
    @PostConstruct
    public void init() {
        moradores = repository.findAll(); // Busca todo mundo no banco
        novoMorador = new Morador();      // Prepara um morador vazio para o formulário
    }

    // Método que será chamado pelo botão "Salvar" na tela
    public void salvar() {
        repository.save(novoMorador);
        init(); // Recarrega a lista para mostrar o morador que acabou de ser salvo
    }

    // --- Getters e Setters para a tela conseguir acessar as variáveis ---
    public List<Morador> getMoradores() {
        return moradores;
    }

    public Morador getNovoMorador() {
        return novoMorador;
    }

    public void setNovoMorador(Morador novoMorador) {
        this.novoMorador = novoMorador;
    }
}