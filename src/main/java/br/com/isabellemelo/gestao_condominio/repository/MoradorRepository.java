package br.com.isabellemelo.gestao_condominio.repository;

import br.com.isabellemelo.gestao_condominio.model.Morador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoradorRepository extends JpaRepository<Morador, Long> {
}