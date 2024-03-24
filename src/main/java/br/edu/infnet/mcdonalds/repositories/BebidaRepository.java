package br.edu.infnet.mcdonalds.repositories;

import br.edu.infnet.mcdonalds.model.Bebida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BebidaRepository extends JpaRepository<Bebida, UUID>{

}
