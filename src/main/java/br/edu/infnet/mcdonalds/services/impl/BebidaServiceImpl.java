package br.edu.infnet.mcdonalds.services.impl;

import br.edu.infnet.mcdonalds.model.Bebida;
import br.edu.infnet.mcdonalds.repositories.BebidaRepository;
import br.edu.infnet.mcdonalds.services.BebidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BebidaServiceImpl implements BebidaService {

    @Autowired
    BebidaRepository bebidaRepository;

    @Override
    public void save(Bebida bebida) {
        bebidaRepository.save(bebida);
    }

    @Override
    public List<Bebida> findAll() {
        return bebidaRepository.findAll();
    }

    @Override
    public Optional<Bebida> findById(Long id) {
        return findById(id);
    }

    @Override
    public Bebida update(Long id, Bebida atualizada) {
        atualizada.setCodigo(id);
        return bebidaRepository.save(atualizada);
    }

    @Override
    public void deleteById(Long id) {
        bebidaRepository.deleteById(id);
    }
}
