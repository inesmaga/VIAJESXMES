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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author inesm
 */
@Entity
@Table(name = "agenda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agenda.findAll", query = "SELECT a FROM Agenda a")
    , @NamedQuery(name = "Agenda.findByCodigo", query = "SELECT a FROM Agenda a WHERE a.codigo = :codigo")
    , @NamedQuery(name = "Agenda.findByEstado", query = "SELECT a FROM Agenda a WHERE a.estado = :estado")
    , @NamedQuery(name = "Agenda.findByValorado", query = "SELECT a FROM Agenda a WHERE a.valorado = :valorado")
    , @NamedQuery(name = "Agenda.findByOpinado", query = "SELECT a FROM Agenda a WHERE a.opinado = :opinado")
    , @NamedQuery(name = "Agenda.findByIdOpinion", query = "SELECT a FROM Agenda a WHERE a.idOpinion = :idOpinion")})
public class Agenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
 
    @Size(min = 1, max = 2)
    @Column(name = "estado")
    private String estado;
    @Column(name = "valorado")
    private Boolean valorado;
    @Column(name = "opinado")
    private Boolean opinado;
    @Column(name = "idOpinion")
    private Integer idOpinion;
    @JoinColumn(name = "idviajes", referencedColumnName = "idviajes")
    @ManyToOne(optional = false)
    private Viajes idviajes;
    @JoinColumn(name = "idmes", referencedColumnName = "idmes")
    @ManyToOne(optional = false)
    private Meses idmes;
    @JoinColumn(name = "idpersona", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Persona idpersona;

    public Agenda() {
    }

    public Agenda(Integer codigo) {
        this.codigo = codigo;
    }

    public Agenda(Integer codigo, String estado) {
        this.codigo = codigo;
        this.estado = estado;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Boolean getValorado() {
        return valorado;
    }

    public void setValorado(Boolean valorado) {
        this.valorado = valorado;
    }

    public Boolean getOpinado() {
        return opinado;
    }

    public void setOpinado(Boolean opinado) {
        this.opinado = opinado;
    }

    public Integer getIdOpinion() {
        return idOpinion;
    }

    public void setIdOpinion(Integer idOpinion) {
        this.idOpinion = idOpinion;
    }

    public Viajes getIdviajes() {
        return idviajes;
    }

    public void setIdviajes(Viajes idviajes) {
        this.idviajes = idviajes;
    }

    public Meses getIdmes() {
        return idmes;
    }

    public void setIdmes(Meses idmes) {
        this.idmes = idmes;
    }

    public Persona getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Persona idpersona) {
        this.idpersona = idpersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agenda)) {
            return false;
        }
        Agenda other = (Agenda) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Agenda[ codigo=" + codigo + " ]";
    }
    
}
