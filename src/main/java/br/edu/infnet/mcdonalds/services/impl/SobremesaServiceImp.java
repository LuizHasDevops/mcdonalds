package br.edu.infnet.mcdonalds.services.impl;

import br.edu.infnet.mcdonalds.model.Sobremesa;
import br.edu.infnet.mcdonalds.repositories.SobremesaRepository;
import br.edu.infnet.mcdonalds.services.SobremesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SobremesaServiceImp implements SobremesaService {


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
    public Optional<Sobremesa> findById(Long id) {
        return findById(id);
    }

    @Override
    public Sobremesa update(Long id, Sobremesa atualizada) {
        atualizada.setCodigo(id);
        return sobremesaRepository.save(atualizada);
    }

    @Override
    public void deleteById(Long id) {
        sobremesaRepository.deleteById(id);
    }
}
