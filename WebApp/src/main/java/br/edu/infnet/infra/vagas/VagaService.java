package br.edu.infnet.infra.vagas;

import br.edu.infnet.domain.vagas.Vaga;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "http://localhost:8082/vagas", name="Vagas")
public interface VagaService {
        
    @GetMapping(path = {"/"})
    List<Vaga> listarVagas();
    
    @GetMapping(path = {"/usuario/{idUsuario}"})
    List<Vaga> listarPorIdUsuario(@PathVariable int idUsuario);
    
    //@GetMapping(path = "/cargo/{pesquisa}")
    //List<Vaga> pesquisarVagasPorCargo(@PathVariable String pesquisa);
    
    //@GetMapping(path = "/cidade/{pesquisa}")
    //List<Vaga> pesquisarVagasPorCidade(@PathVariable String pesquisa);
    
    @PostMapping
    Vaga publicarVaga(@RequestBody Vaga vaga);
}