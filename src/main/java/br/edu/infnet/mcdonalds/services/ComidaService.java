package br.edu.infnet.mcdonalds.services;


import br.edu.infnet.mcdonalds.model.Comida;

import java.util.List;
import java.util.Optional;

public interface ComidaService {

    void save(Comida comida);
    List<Comida> findAll();
    Optional<Comida> findById(Long id);
    Comida update(Long id, Comida atualizada);
    void deleteById(Long id);
}
