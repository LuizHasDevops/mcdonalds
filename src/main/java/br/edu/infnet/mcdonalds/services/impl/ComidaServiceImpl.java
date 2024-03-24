package br.edu.infnet.mcdonalds.services.impl;

import br.edu.infnet.mcdonalds.model.Comida;
import br.edu.infnet.mcdonalds.repositories.ComidaRepository;
import br.edu.infnet.mcdonalds.services.ComidaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ComidaServiceImpl implements ComidaService {
    @Autowired
    ComidaRepository comidaRepository;

    @Override
    public void save(Comida comida) {
        comidaRepository.save(comida);
    }

    @Override
    public List<Comida> findAll() {
        return comidaRepository.findAll();
    }

    @Override
    public Optional<Comida> findById(UUID id) {
        return comidaRepository.findById(id);
    }

    @Override
    public Comida update(UUID id, Comida atualizada) {
        atualizada.setCodigo(id);
        return comidaRepository.save(atualizada);
    }

    @Override
    public void deleteById(UUID id) {
        comidaRepository.deleteById(id);
    }
}
