package br.com.isabellemelo.gestao_condominio.bean; // Confirme o nome do seu pacote

import br.com.isabellemelo.gestao_condominio.model.Morador;
import br.com.isabellemelo.gestao_condominio.repository.MoradorRepository;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import java.util.Optional;

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
        // Busca no banco se já tem alguém com o email digitado
        Optional<Morador> moradorExistente = repository.findByEmail(novoMorador.getEmail());

        // Regra: Se achou alguém, temos que verificar se não é ele mesmo sendo editado
        if (moradorExistente.isPresent()) {
            Morador existente = moradorExistente.get();
            // Se estou criando um novo (id nulo) OU se estou editando mas o ID pertence a outra pessoa: BLOQUEIA!
            if (novoMorador.getId() == null || !existente.getId().equals(novoMorador.getId())) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", "Este e-mail já está cadastrado para outro morador."));
                return; // O 'return' faz o código parar aqui e não salva no banco!
            }
        }

        // Se passou pela regra, salva e recarrega a lista
        repository.save(novoMorador);
        init();

        // Mensagem de sucesso!
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso:", "Morador salvo com sucesso!"));
    }

    // Pega o morador clicado na tabela e joga para o formulário de cima
    public void prepararEdicao(Morador morador) {
        this.novoMorador = morador;
    }

    // Recebe o morador da linha clicada e apaga do banco
    public void excluir(Morador morador) {
        repository.delete(morador);
        init(); // Atualiza a lista na tela imediatamente
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