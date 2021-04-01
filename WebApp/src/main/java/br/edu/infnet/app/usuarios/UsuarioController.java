package br.edu.infnet.app.usuarios;

import br.edu.infnet.domain.usuarios.Usuario;
import br.edu.infnet.domain.vagas.Vaga;
import br.edu.infnet.infra.usuarios.UsuarioService;
import br.edu.infnet.infra.vagas.VagaService;
import java.util.List;
import javax.validation.Valid;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private VagaService vagaService;
    
    @RequestMapping("/login")
    public ModelAndView logarNoSite(String email, String senha) {
        
        ModelAndView retorno = new ModelAndView("index");
        if(StringUtils.isNoneBlank(email) && StringUtils.isNoneBlank(senha)) {
            
            Usuario usuario = usuarioService.obterPorEmail(email);
            if(usuario != null && senha.equals(usuario.getSenha())) {
                
                String destino = "";
                switch(usuario.getTipo()) {
                    
                    case 'E':
                        destino = "empresa/index";
                        
                        try {
                            List<Vaga> publicadas = vagaService.listarPorIdUsuario(usuario.getId());
                            retorno.addObject("publicadas", publicadas);
                        } catch (Exception e) {
                        }
                        break;
                        
                    case 'C':
                        destino = "candidato/index";
                        
                        try {
                            List<Vaga> publicadas = vagaService.listarVagas();
                            retorno.addObject("publicadas", publicadas);
                        } catch (Exception e) {
                        }
                        break;
                }
                retorno.setViewName(destino);
                retorno.addObject("usuario", usuario);
            } else {
                
                retorno.addObject("erro", "Login inválido");
            }
        } else {
            
            retorno.addObject("erro", "Os campos são obrigatórios");
        }
        return retorno;
    }
    
    @RequestMapping("usuario/criarConta")
    public ModelAndView criarConta(@Valid Usuario usuario, BindingResult br) {
        
        ModelAndView retorno = new ModelAndView("usuario/manter");
        
        if(br.hasErrors()) {
            retorno.addObject("erros", br.getFieldErrors());
            
        } else {
            Usuario gravado = usuarioService.inserirUsuario(usuario);
            String destino = "";
                switch(usuario.getTipo()) {                    
                    case 'E':
                        destino = "empresa/index";
                        break;
                    case 'C':
                        destino = "candidato/index";
                        break;
                }
                retorno.setViewName(destino);
                retorno.addObject("usuario", gravado);
            }        
        return retorno;
    }
    
    // inserir Alterar dados
}
