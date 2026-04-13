package br.com.isabellemelo.gestao_condominio.service;

import br.com.isabellemelo.gestao_condominio.model.Morador;
import br.com.isabellemelo.gestao_condominio.model.Reserva;
import br.com.isabellemelo.gestao_condominio.repository.MoradorRepository;
import br.com.isabellemelo.gestao_condominio.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Avisa o Spring que aqui ficam as regras de negócio
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private MoradorRepository moradorRepository;

    public Reserva fazerReserva(Long moradorId, Reserva reserva) {
        //Verifica no banco se o morador que quer fazer a reserva realmente existe
        Morador morador = moradorRepository.findById(moradorId)
                .orElseThrow(() -> new RuntimeException("Morador não encontrado no sistema!"));

        //Verifica se o espaço já está reservado nesse dia
        boolean dataOcupada = reservaRepository.existsByDataReservaAndEspaco(reserva.getDataReserva(), reserva.getEspaco());

        if (dataOcupada) {
            // Se já tem alguém, o sistema mostra um erro e para tudo!
            throw new RuntimeException("Ops! Este espaço já está reservado nesta data.");
        }

        //Se passou pelas regras, associa a reserva ao morador e salva
        reserva.setMorador(morador);
        return reservaRepository.save(reserva);
    }
}