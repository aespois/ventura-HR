package br.edu.infnet.domain.vagas;

import java.util.List;
import javax.validation.constraints.NotBlank;

public class Vaga {

    private Integer id;
    @NotBlank(message = "O campo Cargo é obrigatório")
    private String cargo;
    @NotBlank(message = "O campo Cidade é obrigatório")
    private String cidade;
    private String formaContratacao;
    private int idUsuario;
    private List<Criterio> criterioList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getFormaContratacao() {
        return formaContratacao;
    }

    public void setFormaContratacao(String formaContratacao) {
        this.formaContratacao = formaContratacao;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<Criterio> getCriterioList() {
        return criterioList;
    }

    public void setCriterioList(List<Criterio> criterioList) {
        this.criterioList = criterioList;
    }
    
}