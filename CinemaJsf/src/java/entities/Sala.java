/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andre Vitor
 */
@Entity
@Table(name = "sala")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sala.findAll", query = "SELECT s FROM Sala s")
    , @NamedQuery(name = "Sala.findByCodSala", query = "SELECT s FROM Sala s WHERE s.codSala = :codSala")
    , @NamedQuery(name = "Sala.findByCapacidade", query = "SELECT s FROM Sala s WHERE s.capacidade = :capacidade")})
public class Sala implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_sala")
    private Integer codSala;
    @Column(name = "capacidade")
    private Integer capacidade;

    public Sala() {
    }

    public Sala(Integer codSala) {
        this.codSala = codSala;
    }

    public Integer getCodSala() {
        return codSala;
    }

    public void setCodSala(Integer codSala) {
        this.codSala = codSala;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codSala != null ? codSala.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sala)) {
            return false;
        }
        Sala other = (Sala) object;
        if ((this.codSala == null && other.codSala != null) || (this.codSala != null && !this.codSala.equals(other.codSala))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Sala[ codSala=" + codSala + " ]";
    }
    
}
