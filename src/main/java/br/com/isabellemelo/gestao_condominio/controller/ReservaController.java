package br.com.isabellemelo.gestao_condominio.controller;

import br.com.isabellemelo.gestao_condominio.model.Reserva;
import br.com.isabellemelo.gestao_condominio.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService service;

    // A URL vai ser ex: /reservas/morador/1 (onde 1 é o id de quem tá alugando)
    @PostMapping("/morador/{moradorId}")
    public Reserva agendar(@PathVariable Long moradorId, @RequestBody Reserva reserva) {
        return service.fazerReserva(moradorId, reserva);
    }
}