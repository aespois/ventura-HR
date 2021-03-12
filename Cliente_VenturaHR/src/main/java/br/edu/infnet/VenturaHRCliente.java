package br.edu.infnet;

import br.edu.infnet.domain.usuarios.Usuario;
import br.edu.infnet.infra.usuarios.UsuarioService;
import br.edu.infnet.domain.vagas.Criterio;
import br.edu.infnet.domain.vagas.Vaga;
import br.edu.infnet.infra.vagas.VagaService;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class VenturaHRCliente implements CommandLineRunner {
    
    private final String NOT_FOUND = "404";
    private Logger log = LoggerFactory.getLogger(VenturaHRCliente.class);
    @Autowired
    private UsuarioService usuarioService;
    private VagaService vagaService;
    
    public static void main(String[] args) {
        SpringApplication.run(VenturaHRCliente.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        
        // Teste de Login
        Usuario empresa = this.logarNoSite("ana@espois.com", "123");
        if (empresa != null && empresa.getTipo() == 'E') {
            
            log.info(empresa.getId() + " - " + empresa.getNome());
            
            // Teste de Criação de Vaga
            Vaga v1 = new Vaga();
            v1.setCargo("Scrum Master");
            //vaga.setCidade("Rio de Janeiro - RJ");
            v1.setFormaContratacao("CLT");
            v1.setIdUsuario(empresa.getId());
            
            // Teste de Criação de Critérios
            Criterio c1 = new Criterio();
            c1.setDescricao("Proficiência em Métodos Ágeis");
            c1.setPerfil(5);
            c1.setPeso(5);
            c1.setVaga(v1);
            
            Criterio c2 = new Criterio();
            c2.setDescricao("Língua Inglesa");
            c2.setPerfil(4);
            c2.setPeso(4);
            c2.setVaga(v1);
            
            // Teste de Relacionamento Vaga x Critério
            ArrayList<Criterio> criterios = new ArrayList<>();
            criterios.add(c1);
            criterios.add(c2);
            v1.setCriterioList(criterios);
            
            // Teste de Publicar Vaga
            Vaga gravado =  vagaService.publicarVaga(v1);
            log.info(gravado.getId() + " - " + gravado.getCargo());
            
            // Teste de Listar por Usuário
            List<Vaga> listaVagas = vagaService.listarPorIdUsuario(empresa.getId());
            for (Vaga unitVaga : listaVagas) {
                log.info(unitVaga.getId() + " - " + unitVaga.getCargo());
            }
            
        } else {
            log.info("Login Inválido!");
        }            
            
        // Teste de Criar Conta
        Usuario usuarioTeste = new Usuario();
        Usuario gravado = this.manterUsuario(usuarioTeste);
        
        // Teste de Alterar Conta
        
    }

    private Usuario logarNoSite(String email, String senha) {
        Usuario retorno = null;
        
        if (StringUtils.isNotBlank(email) && StringUtils.isNotBlank(senha)) {
            Usuario usuario = null;
            
            try {
                usuario = usuarioService.obterPorEmail(email);
            } catch (Exception e) {
                //log.info(e.getMessage());
                if (e.getMessage().contains(NOT_FOUND)) {
                    log.info("Empresa Não Encontrada");
                }
            }           
            
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
