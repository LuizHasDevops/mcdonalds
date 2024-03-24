package br.edu.infnet.mcdonalds.repositories;

import br.edu.infnet.mcdonalds.model.Solicitante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SolicitanteRepository extends JpaRepository<Solicitante, Long> {
}
