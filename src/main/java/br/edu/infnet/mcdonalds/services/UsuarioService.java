package br.edu.infnet.mcdonalds.services;
import br.edu.infnet.mcdonalds.model.Role;
import br.edu.infnet.mcdonalds.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    void save(Usuario usuario);
    List<Usuario> findAll();
    Optional<Usuario> findById(Long id);
    Usuario update(Long id, Usuario atualizada);
    void deleteById(Long id);
    List<Usuario> findAllUsuariosAtivos();
    List<Usuario> findAllByRoles(List<Role> roles);

    Optional<Usuario> findByEmail(String email);
    Boolean hasRole(Usuario usuario,String role);
}
