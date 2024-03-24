package br.edu.infnet.mcdonalds.repositories;

import br.edu.infnet.mcdonalds.model.Sobremesa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SobremesaRepository extends JpaRepository<Sobremesa, UUID> {
}
