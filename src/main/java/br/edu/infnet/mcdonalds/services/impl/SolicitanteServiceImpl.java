package br.edu.infnet.mcdonalds.services.impl;

import br.edu.infnet.mcdonalds.model.Solicitante;
import br.edu.infnet.mcdonalds.repositories.SolicitanteRepository;
import br.edu.infnet.mcdonalds.services.SolicitanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class SolicitanteServiceImpl implements SolicitanteService {

    @Autowired
    SolicitanteRepository solicitanteRepository;
    @Override
    public void save(Solicitante solicitante) {
        solicitanteRepository.save(solicitante);
    }

    @Override
    public List<Solicitante> findAll() {
        return solicitanteRepository.findAll();
    }

    @Override
    public Optional<Solicitante> findById(Long id) {
        return solicitanteRepository.findById(id);
    }

    @Override
    public Solicitante update(Long id, Solicitante atualizada) {
        atualizada.setCodigo(id);
        return solicitanteRepository.save(atualizada);
    }

    @Override
    public void deleteById(Long id) {
        solicitanteRepository.deleteById(id);
    }
}
