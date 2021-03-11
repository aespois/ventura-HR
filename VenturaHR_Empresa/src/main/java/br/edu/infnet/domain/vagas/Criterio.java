package br.edu.infnet.domain.vagas;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "criterios", catalog = "db_venturahr", schema = "")
@NamedQueries({
    @NamedQuery(name = "Criterio.findAll", query = "SELECT c FROM Criterio c"),
    @NamedQuery(name = "Criterio.findById", query = "SELECT c FROM Criterio c WHERE c.id = :id"),
    @NamedQuery(name = "Criterio.findByDescricao", query = "SELECT c FROM Criterio c WHERE c.descricao = :descricao"),
    @NamedQuery(name = "Criterio.findByPerfil", query = "SELECT c FROM Criterio c WHERE c.perfil = :perfil"),
    @NamedQuery(name = "Criterio.findByPeso", query = "SELECT c FROM Criterio c WHERE c.peso = :peso"),
    @NamedQuery(name = "Criterio.findByIdVaga", query = "SELECT c FROM Criterio c WHERE c.idVaga = :idVaga")})

public class Criterio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    
    private String descricao;
    @Basic(optional = false)
    @Column(nullable = false)
    
    private int perfil;
    @Basic(optional = false)
    @Column(nullable = false)
    
    private int peso;
    @Basic(optional = false)
    @Column(name = "id_vaga", nullable = false)
    
    private int idVaga;

    public Criterio() {
    }

    public Criterio(Integer id) {
        this.id = id;
    }

    public Criterio(Integer id, String descricao, int perfil, int peso, int idVaga) {
        this.id = id;
        this.descricao = descricao;
        this.perfil = perfil;
        this.peso = peso;
        this.idVaga = idVaga;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPerfil() {
        return perfil;
    }

    public void setPerfil(int perfil) {
        this.perfil = perfil;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getIdVaga() {
        return idVaga;
    }

    public void setIdVaga(int idVaga) {
        this.idVaga = idVaga;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Criterio)) {
            return false;
        }
        Criterio other = (Criterio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.infnet.domain.vagas.Criterio[ id=" + id + " ]";
    }
    
}
