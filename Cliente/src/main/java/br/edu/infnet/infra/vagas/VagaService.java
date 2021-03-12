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
    
    @PostMapping
    Vaga publicarVaga(@RequestBody Vaga vaga);
    
    @GetMapping(path = {"/usuario/{idUsuario}"})
    List<Vaga> listarPorIdUsuario(@PathVariable int idUsuario);
}
