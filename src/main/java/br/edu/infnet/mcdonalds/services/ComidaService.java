package br.edu.infnet.mcdonalds.services;

import br.edu.infnet.mcdonalds.model.Comida;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ComidaService {

    void save(Comida bebida);
    List<Comida> findAll();
    Optional<Comida> findById(UUID id);
    Comida update(UUID id, Comida atualizada);
    void deleteById(UUID id);
}
