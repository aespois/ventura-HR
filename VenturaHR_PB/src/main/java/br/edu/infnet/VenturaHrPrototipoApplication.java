package br.edu.infnet;

import br.edu.infnet.domain.usuarios.Usuario;
import br.edu.infnet.infra.usuarios.UsuarioService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class VenturaHrPrototipoApplication implements CommandLineRunner {
    
    private Logger log = LoggerFactory.getLogger(VenturaHrPrototipoApplication.class);
    @Autowired
    private UsuarioService usuarioService;
    
    public static void main(String[] args) {
            SpringApplication.run(VenturaHrPrototipoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Usuario empresa = this.logarNoSite("ana@espois.com", "123");
            log.info(empresa.getId() + " - " + empresa.getNome());
    }

    private Usuario logarNoSite(String email, String senha) {
        Usuario retorno = null;
        
        if (StringUtils.isNotBlank(email) && StringUtils.isNotBlank(senha)) {
            Usuario usuario = usuarioService.obterPorEmail(email);
            
            if (usuario != null && senha.equals(usuario.getSenha())) {
                retorno = usuario;
            }
        }        
        return retorno;
    }
    
    private Usuario manterUsuario(Usuario usuario) {
        Usuario retorno = null;
        
        if (usuario != null && usuario.getId() == null) {
            // Incluir usuário
        } else if (usuario != null && usuario.getId() != null){
            // Alterar usuário
        }
        return retorno;
    }
}
