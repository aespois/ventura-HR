package br.edu.infnet.app.vagas;

import br.edu.infnet.domain.usuarios.Usuario;
import br.edu.infnet.domain.vagas.Criterio;
import br.edu.infnet.domain.vagas.Vaga;
import br.edu.infnet.infra.vagas.VagaService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VagaController {
    
    @Autowired
    private VagaService vagaService;
    
    @RequestMapping("empresa/publicarVaga") // Validar a inserção dos critérios
    public ModelAndView publicarVaga(@Valid Vaga vaga, Usuario usuario, BindingResult br) {
        
        ModelAndView retorno = new ModelAndView("empresa/publicar");
        
        List<Criterio> listaCriterio = vaga.getCriterioList();        
        
        if(br.hasErrors()) {
            retorno.addObject("erros", br.getFieldErrors());
            
        } else {     
            
            if(listaCriterio != null && !listaCriterio.isEmpty()) {
                
                listaCriterio.forEach(criterio -> {
                    criterio.setVaga(vaga);
                });
            
                Vaga gravada = vagaService.publicarVaga(vaga);
                String destino = "/";
                vaga.setIdUsuario(usuario.getId());
                retorno.setViewName(destino);
                retorno.addObject("vaga", gravada);
            }
        }
        return retorno;
    }
}
