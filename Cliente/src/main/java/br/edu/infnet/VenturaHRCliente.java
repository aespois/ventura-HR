package br.edu.infnet;

import br.edu.infnet.domain.usuarios.Usuario;
import br.edu.infnet.infra.usuarios.UsuarioService;
import br.edu.infnet.domain.vagas.Vaga;
import br.edu.infnet.infra.vagas.VagaService;
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
    
    @Autowired
    private VagaService vagaService;
    
    public static void main(String[] args) {
        SpringApplication.run(VenturaHRCliente.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        
        // Teste de Login - Empresa
        log.info("--- Login Empresa ---");
        Usuario empresa = this.logarNoSite("ana@espois.com", "123");
        if (empresa != null && empresa.getTipo() == 'E') {
            log.info(empresa.getId() + " - " + empresa.getNome());
            
            // Teste de Criação de Vaga
            log.info("--- Publicação de Vaga ---");
            //Vaga vaga = new Vaga();
            //vaga.setCargo("Desenvolvedor FullStack");
            //vaga.setCidade("Remoto");
            //vaga.setFormaContratacao("PJ");
            //vaga.setIdUsuario(empresa.getId());
            
            // Criação de Critérios
            //Criterio c1 = new Criterio();
            //c1.setDescricao("Back e Front-end");
            //c1.setPerfil(1);
            //c1.setPeso(2);
            //c1.setVaga(vaga);
            
            //Criterio c2 = new Criterio();
            //c2.setDescricao("Arquitetura");
            //c2.setPerfil(1);
            //c2.setPeso(3);
            //c2.setVaga(vaga);
            
            //Criterio c3 = new Criterio();
            //c3.setDescricao("Banco de Dados NoSQL");
            //c3.setPerfil(1);
            //c3.setPeso(3);
            //c3.setVaga(vaga);
            
            // Relacionamento Vaga x Critério
            //ArrayList<Criterio> criterios = new ArrayList<>();
            //criterios.add(c1);
            //criterios.add(c2);
            //criterios.add(c3);
            //vaga.setCriterioList(criterios);
            
            // Publicar Vaga
            //Vaga gravado = vagaService.publicarVaga(vaga);
            //log.info(gravado.getId() + " - " + gravado.getCargo());
            
            // Teste de Listar Vagas por Usuário
            log.info("--- Vagas Cadastradas por " + empresa.getNome() + " ---");
            List<Vaga> listaVagas = vagaService.listarPorIdUsuario(empresa.getId());
            for (Vaga unitVaga : listaVagas) {
                log.info(unitVaga.getId() + " - " + unitVaga.getCargo());
            }           
        } else {
            log.info("Login Inválido!");
        }       
        
        // Teste de Login - Candidato
        log.info("--- Login Candidato ---");
        Usuario candidato = this.logarNoSite("eric@jardim.com", "123");          
        if (candidato != null && candidato.getTipo() == 'C') {
            
            log.info(candidato.getId() + " - " + candidato.getNome());
            
            log.info("--- Vagas Pesquisadas por Cargo pelo candidato " + candidato.getNome() + " ---");
            List<Vaga> listarPorCargo = vagaService.pesquisarVagasPorCargo("Desenvolvedor");
            for (Vaga unitVaga : listarPorCargo) {
                log.info(unitVaga.getId() + " - " + unitVaga.getCargo());
            }
            
            log.info("--- Vagas Pesquisadas por Cidade pelo candidato " + candidato.getNome() + " ---");
            List<Vaga> listarPorCidade = vagaService.pesquisarVagasPorCidade("São Paulo");
            for (Vaga unitVaga : listarPorCidade) {
                log.info(unitVaga.getId() + " - " + unitVaga.getCargo());
            }            
        } else {
            log.info("Login Inválido!");
        }     
    }

    private Usuario logarNoSite(String email, String senha) {
        Usuario retorno = null;
        
        if (StringUtils.isNotBlank(email) && StringUtils.isNotBlank(senha)) {
            Usuario usuario = null;
            
            try {
                usuario = usuarioService.obterPorEmail(email);
            } catch (Exception e) {
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
}
