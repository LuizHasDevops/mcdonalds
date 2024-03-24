package br.edu.infnet.mcdonalds.repositories;

import br.edu.infnet.mcdonalds.model.Comida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComidaRepository extends JpaRepository<Comida,Long> {
}
