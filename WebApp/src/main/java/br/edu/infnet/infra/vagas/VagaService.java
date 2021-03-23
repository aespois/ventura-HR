package br.edu.infnet.infra.vagas;

import br.edu.infnet.domain.vagas.Vaga;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "http://localhost:8082/vagas", name="Vagas")
public interface VagaService {
    
    @PostMapping // Validar a inserção dos critérios
    Vaga publicarVaga(@RequestBody Vaga vaga);
    
}
