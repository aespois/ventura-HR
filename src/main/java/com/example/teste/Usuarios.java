package com.example.teste;

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
import javax.persistence.UniqueConstraint;

/**
 * @author ana.espois
 */
@Entity

@Table(catalog = "sdi_test", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"cpf"}),
    @UniqueConstraint(columnNames = {"email"})})

@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findById", query = "SELECT u FROM Usuarios u WHERE u.id = :id"),
    @NamedQuery(name = "Usuarios.findByNome", query = "SELECT u FROM Usuarios u WHERE u.nome = :nome"),
    @NamedQuery(name = "Usuarios.findByEndereco", query = "SELECT u FROM Usuarios u WHERE u.endereco = :endereco"),
    @NamedQuery(name = "Usuarios.findByTelefone", query = "SELECT u FROM Usuarios u WHERE u.telefone = :telefone"),
    @NamedQuery(name = "Usuarios.findByEmail", query = "SELECT u FROM Usuarios u WHERE u.email = :email"),
    @NamedQuery(name = "Usuarios.findBySenha", query = "SELECT u FROM Usuarios u WHERE u.senha = :senha"),
    @NamedQuery(name = "Usuarios.findByCpf", query = "SELECT u FROM Usuarios u WHERE u.cpf = :cpf"),
    @NamedQuery(name = "Usuarios.findByRazaoSocial", query = "SELECT u FROM Usuarios u WHERE u.razaoSocial = :razaoSocial"),
    @NamedQuery(name = "Usuarios.findByCnpj", query = "SELECT u FROM Usuarios u WHERE u.cnpj = :cnpj"),
    @NamedQuery(name = "Usuarios.findByTipo", query = "SELECT u FROM Usuarios u WHERE u.tipo = :tipo")})

public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String nome;
    
    @Column(length = 100)
    private String endereco;
    
    @Basic(optional = false)
    @Column(nullable = false, length = 20)
    private String telefone;
    
    @Basic(optional = false)
    @Column(nullable = false, length = 30)
    private String email;
    
    @Basic(optional = false)
    @Column(nullable = false, length = 32)
    private String senha;
    
    @Basic(optional = false)
    @Column(nullable = false, length = 11)
    private String cpf;
    
    @Column(name = "razao_social", length = 50)
    private String razaoSocial;
    
    @Column(length = 14)
    private String cnpj;
    
    @Basic(optional = false)
    
    @Column(nullable = false)
    private Character tipo;

    public Usuarios() {
    }

    public Usuarios(Integer id) {
        this.id = id;
    }

    public Usuarios(Integer id, String nome, String telefone, String email, String senha, String cpf, Character tipo) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
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
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.teste.Usuarios[ id=" + id + " ]";
    }
    
}
