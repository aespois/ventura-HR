package br.edu.infnet.domain.vagas;

import java.util.List;

public class Vaga {

    private Integer id;
    private String cargo;
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
