/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andre Vitor
 */
@Entity
@Table(name = "filme")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Filme.findAll", query = "SELECT f FROM Filme f")
    , @NamedQuery(name = "Filme.findByCodFilme", query = "SELECT f FROM Filme f WHERE f.codFilme = :codFilme")
    , @NamedQuery(name = "Filme.findByTitulo", query = "SELECT f FROM Filme f WHERE f.titulo = :titulo")
    , @NamedQuery(name = "Filme.findByDuracao", query = "SELECT f FROM Filme f WHERE f.duracao = :duracao")})
public class Filme implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_filme")
    private Integer codFilme;
    @Size(max = 100)
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "duracao")
    @Temporal(TemporalType.TIME)
    private Date duracao;

    public Filme() {
    }

    public Filme(Integer codFilme) {
        this.codFilme = codFilme;
    }

    public Integer getCodFilme() {
        return codFilme;
    }

    public void setCodFilme(Integer codFilme) {
        this.codFilme = codFilme;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getDuracao() {
        return duracao;
    }

    public void setDuracao(Date duracao) {
        this.duracao = duracao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codFilme != null ? codFilme.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Filme)) {
            return false;
        }
        Filme other = (Filme) object;
        if ((this.codFilme == null && other.codFilme != null) || (this.codFilme != null && !this.codFilme.equals(other.codFilme))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Filme[ codFilme=" + codFilme + " ]";
    }
    
}
