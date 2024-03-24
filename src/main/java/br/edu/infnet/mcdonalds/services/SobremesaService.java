package br.edu.infnet.mcdonalds.services;

import br.edu.infnet.mcdonalds.model.Sobremesa;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SobremesaService {

    void save(Sobremesa bebida);
    List<Sobremesa> findAll();
    Optional<Sobremesa> findById(UUID id);
    Sobremesa update(UUID id, Sobremesa atualizada);
    void deleteById(UUID id);

}
