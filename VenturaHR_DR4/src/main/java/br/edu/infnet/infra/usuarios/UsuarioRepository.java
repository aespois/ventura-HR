package br.edu.infnet.infra.usuarios;

import br.edu.infnet.domain.usuarios.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    Usuario findByEmail(String email);
}
