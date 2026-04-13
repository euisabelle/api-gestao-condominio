package br.com.isabellemelo.gestao_condominio.repository;

import br.com.isabellemelo.gestao_condominio.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    boolean existsByDataReservaAndEspaco(java.time.LocalDate dataReserva, String espaco);
}
