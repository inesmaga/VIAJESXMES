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
 * @author inesm
 */
@Entity
@Table(name = "agenda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agenda.findAll", query = "SELECT a FROM Agenda a")
    , @NamedQuery(name = "Agenda.findByCodigo", query = "SELECT a FROM Agenda a WHERE a.codigo = :codigo")
    , @NamedQuery(name = "Agenda.findByIdmes", query = "SELECT a FROM Agenda a WHERE a.idmes = :idmes")
    , @NamedQuery(name = "Agenda.findByIdpersona", query = "SELECT a FROM Agenda a WHERE a.idpersona = :idpersona")
    , @NamedQuery(name = "Agenda.findByIdviaje", query = "SELECT a FROM Agenda a WHERE a.idviaje = :idviaje")
    , @NamedQuery(name = "Agenda.findByNameviaje", query = "SELECT a FROM Agenda a WHERE a.nameviaje = :nameviaje")
    , @NamedQuery(name = "Agenda.findByEstado", query = "SELECT a FROM Agenda a WHERE a.estado = :estado")
    , @NamedQuery(name = "Agenda.findByFavorito", query = "SELECT a FROM Agenda a WHERE a.favorito = :favorito")
    , @NamedQuery(name = "Agenda.findByValorado", query = "SELECT a FROM Agenda a WHERE a.valorado = :valorado")
    , @NamedQuery(name = "Agenda.findByOpinado", query = "SELECT a FROM Agenda a WHERE a.opinado = :opinado")
    , @NamedQuery(name = "Agenda.findByIdopinion", query = "SELECT a FROM Agenda a WHERE a.idopinion = :idopinion")
    , @NamedQuery(name = "Agenda.findByIdvalorac", query = "SELECT a FROM Agenda a WHERE a.idvalorac = :idvalorac")})
public class Agenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)

    @Column(name = "idmes")
    private int idmes;
    @Basic(optional = false)

    @Column(name = "idpersona")
    private int idpersona;
    @Basic(optional = false)

    @Column(name = "idviaje")
    private int idviaje;
    @Basic(optional = false)


    @Column(name = "nameviaje")
    private String nameviaje;
    @Basic(optional = false)
   
   
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)

    @Column(name = "favorito")
    private boolean favorito;
    @Basic(optional = false)

    @Column(name = "valorado")
    private boolean valorado;
    @Basic(optional = false)
    
    @Column(name = "opinado")
    private boolean opinado;
    @Basic(optional = false)
    @Column(name = "idopinion")
    private int idopinion;
    @Basic(optional = false)
   
    @Column(name = "idvalorac")
    private int idvalorac;

    public Agenda() {
    }

    public Agenda(Integer codigo) {
        this.codigo = codigo;
    }

    public Agenda(Integer codigo, int idmes, int idpersona, int idviaje, String nameviaje, String estado, boolean favorito, boolean valorado, boolean opinado, int idopinion, int idvalorac) {
        this.codigo = codigo;
        this.idmes = idmes;
        this.idpersona = idpersona;
        this.idviaje = idviaje;
        this.nameviaje = nameviaje;
        this.estado = estado;
        this.favorito = favorito;
        this.valorado = valorado;
        this.opinado = opinado;
        this.idopinion = idopinion;
        this.idvalorac = idvalorac;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public int getIdmes() {
        return idmes;
    }

    public void setIdmes(int idmes) {
        this.idmes = idmes;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public int getIdviaje() {
        return idviaje;
    }

    public void setIdviaje(int idviaje) {
        this.idviaje = idviaje;
    }

    public String getNameviaje() {
        return nameviaje;
    }

    public void setNameviaje(String nameviaje) {
        this.nameviaje = nameviaje;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean getFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    public boolean getValorado() {
        return valorado;
    }

    public void setValorado(boolean valorado) {
        this.valorado = valorado;
    }

    public boolean getOpinado() {
        return opinado;
    }

    public void setOpinado(boolean opinado) {
        this.opinado = opinado;
    }

    public int getIdopinion() {
        return idopinion;
    }

    public void setIdopinion(int idopinion) {
        this.idopinion = idopinion;
    }

    public int getIdvalorac() {
        return idvalorac;
    }

    public void setIdvalorac(int idvalorac) {
        this.idvalorac = idvalorac;
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
