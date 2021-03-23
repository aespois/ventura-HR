package br.edu.infnet.app.vagas;

import br.edu.infnet.domain.vagas.Vaga;
import br.edu.infnet.infra.vagas.VagaService;
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
    public ModelAndView publicarVaga(@Valid Vaga vaga, BindingResult br) {
        
        ModelAndView retorno = new ModelAndView("empresa/publicar");
        
        if(br.hasErrors()) {
            retorno.addObject("erros", br.getFieldErrors());
            
        } else {     
            Vaga gravada = vagaService.publicarVaga(vaga);
            String destino = "empresa/index";
            retorno.setViewName(destino);
            retorno.addObject("usuario", gravada);
        }
        return retorno;
    }
}
