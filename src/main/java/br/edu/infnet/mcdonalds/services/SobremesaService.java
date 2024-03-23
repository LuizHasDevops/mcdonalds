package br.edu.infnet.mcdonalds.services;

import br.edu.infnet.mcdonalds.model.Sobremesa;

import java.util.List;
import java.util.Optional;

public interface SobremesaService {

    void save(Sobremesa sobremesa);
    List<Sobremesa> findAll();
    Optional<Sobremesa> findById(Long id);
    Sobremesa update(Long id, Sobremesa atualizada);
    void deleteById(Long id);
}

