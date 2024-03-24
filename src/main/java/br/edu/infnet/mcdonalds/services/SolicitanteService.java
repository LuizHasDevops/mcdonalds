package br.edu.infnet.mcdonalds.services;

import br.edu.infnet.mcdonalds.model.Solicitante;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SolicitanteService {
    void save(Solicitante bebida);
    List<Solicitante> findAll();
    Optional<Solicitante> findById(Long id);
    Solicitante update(Long id, Solicitante atualizada);
    void deleteById(Long id);
}
