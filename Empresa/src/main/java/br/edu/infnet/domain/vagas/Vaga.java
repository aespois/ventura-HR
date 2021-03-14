package br.edu.infnet.domain.vagas;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vagas", catalog = "db_venturahr", schema = "")
@NamedQueries({
    @NamedQuery(name = "Vaga.findAll", query = "SELECT v FROM Vaga v"),
    @NamedQuery(name = "Vaga.findById", query = "SELECT v FROM Vaga v WHERE v.id = :id"),
    @NamedQuery(name = "Vaga.findByCargo", query = "SELECT v FROM Vaga v WHERE v.cargo = :cargo"),
    @NamedQuery(name = "Vaga.findByCidade", query = "SELECT v FROM Vaga v WHERE v.cidade = :cidade"),
    @NamedQuery(name = "Vaga.findByFormaContratacao", query = "SELECT v FROM Vaga v WHERE v.formaContratacao = :formaContratacao"),
    @NamedQuery(name = "Vaga.findByIdUsuario", query = "SELECT v FROM Vaga v WHERE v.idUsuario = :idUsuario")})

public class Vaga implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String cargo;
    
    @Basic(optional = false)
    @Column(nullable = false, length = 100)
    private String cidade;
    
    @Basic(optional = false)
    @Column(name = "forma_contratacao", nullable = false, length = 45)
    private String formaContratacao;
    
    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vaga")
    private List<Criterio> criterioList;

    public Vaga() {
    }

    public Vaga(Integer id) {
        this.id = id;
    }

    public Vaga(Integer id, String cargo, String cidade, String formaContratacao, int idUsuario) {
        this.id = id;
        this.cargo = cargo;
        this.cidade = cidade;
        this.formaContratacao = formaContratacao;
        this.idUsuario = idUsuario;
    }

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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Vaga)) {
            return false;
        }
        Vaga other = (Vaga) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.infnet.domain.vagas.Vaga[ id=" + id + " ]";
    }
    
}
