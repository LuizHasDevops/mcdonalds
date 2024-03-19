package br.edu.infnet.mcdonalds.services;

import br.edu.infnet.mcdonalds.model.Bebida;

import java.util.List;
import java.util.Optional;

public interface BebidaService {

    void save(Bebida bebida);
    List<Bebida> findAll();
    Optional<Bebida> findById(Long id);
    Bebida update(Long id, Bebida atualizada);
    void deleteById(Long id);
}
