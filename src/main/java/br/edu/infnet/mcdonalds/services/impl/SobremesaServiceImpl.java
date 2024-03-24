package br.edu.infnet.mcdonalds.services.impl;

import br.edu.infnet.mcdonalds.model.Sobremesa;
import br.edu.infnet.mcdonalds.repositories.SobremesaRepository;
import br.edu.infnet.mcdonalds.services.SobremesaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class SobremesaServiceImpl implements SobremesaService {

    @Autowired
    SobremesaRepository sobremesaRepository;
    @Override
    public void save(Sobremesa sobremesa) {
        sobremesaRepository.save(sobremesa);
    }

    @Override
    public List<Sobremesa> findAll() {
        return sobremesaRepository.findAll();
    }

    @Override
    public Optional<Sobremesa> findById(UUID id) {
        return sobremesaRepository.findById(id);
    }

    @Override
    public Sobremesa update(UUID id, Sobremesa atualizada) {
        atualizada.setCodigo(id);
        return sobremesaRepository.save(atualizada);
    }

    @Override
    public void deleteById(UUID id) {
        sobremesaRepository.deleteById(id);
    }
}
