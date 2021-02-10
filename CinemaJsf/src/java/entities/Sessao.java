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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andre Vitor
 */
@Entity
@Table(name = "sessao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sessao.findAll", query = "SELECT s FROM Sessao s")
    , @NamedQuery(name = "Sessao.findByCodSessao", query = "SELECT s FROM Sessao s WHERE s.codSessao = :codSessao")
    , @NamedQuery(name = "Sessao.findByCodFilme", query = "SELECT s FROM Sessao s WHERE s.codFilme = :codFilme")
    , @NamedQuery(name = "Sessao.findByCodSala", query = "SELECT s FROM Sessao s WHERE s.codSala = :codSala")
    , @NamedQuery(name = "Sessao.findByData", query = "SELECT s FROM Sessao s WHERE s.data = :data")
    , @NamedQuery(name = "Sessao.findByHorario", query = "SELECT s FROM Sessao s WHERE s.horario = :horario")})
public class Sessao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_sessao")
    private Integer codSessao;
    @Column(name = "cod_filme")
    private Integer codFilme;
    @Column(name = "cod_sala")
    private Integer codSala;
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "horario")
    @Temporal(TemporalType.TIME)
    private Date horario;

    public Sessao() {
    }

    public Sessao(Integer codSessao) {
        this.codSessao = codSessao;
    }

    public Integer getCodSessao() {
        return codSessao;
    }

    public void setCodSessao(Integer codSessao) {
        this.codSessao = codSessao;
    }

    public Integer getCodFilme() {
        return codFilme;
    }

    public void setCodFilme(Integer codFilme) {
        this.codFilme = codFilme;
    }

    public Integer getCodSala() {
        return codSala;
    }

    public void setCodSala(Integer codSala) {
        this.codSala = codSala;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codSessao != null ? codSessao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sessao)) {
            return false;
        }
        Sessao other = (Sessao) object;
        if ((this.codSessao == null && other.codSessao != null) || (this.codSessao != null && !this.codSessao.equals(other.codSessao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Sessao[ codSessao=" + codSessao + " ]";
    }
    
}
