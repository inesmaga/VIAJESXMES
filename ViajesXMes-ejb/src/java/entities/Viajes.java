/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author inesm
 */
@Entity
@Table(name = "viajes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Viajes.findAll", query = "SELECT v FROM Viajes v")
    , @NamedQuery(name = "Viajes.findByIdviajes", query = "SELECT v FROM Viajes v WHERE v.idviajes = :idviajes")
    , @NamedQuery(name = "Viajes.findByIdmenu", query = "SELECT v FROM Viajes v WHERE v.idmenu = :idmenu")
    , @NamedQuery(name = "Viajes.findByWeb", query = "SELECT v FROM Viajes v WHERE v.web = :web")
    , @NamedQuery(name = "Viajes.findByNSelect", query = "SELECT v FROM Viajes v WHERE v.nSelect = :nSelect")
    , @NamedQuery(name = "Viajes.findByValorac", query = "SELECT v FROM Viajes v WHERE v.valorac = :valorac")
    , @NamedQuery(name = "Viajes.findByIdOpinion", query = "SELECT v FROM Viajes v WHERE v.idOpinion = :idOpinion")})
public class Viajes implements Serializable {

    @Basic(optional = false)
 
    @Lob
  
    @Column(name = "Descripcion")
    private String descripcion;
    @Basic(optional = false)
    
    @Lob
   
    @Column(name = "CLL")
    private String cll;
    @Basic(optional = false)
  
    @Lob
  
    @Column(name = "CD")
    private String cd;
    @Basic(optional = false)
   
    @Lob
 
    @Column(name = "ET")
    private String et;
    @Basic(optional = false)
    
    @Lob

    @Column(name = "DD")
    private String dd;
    @Basic(optional = false)
  
    @Lob

    @Column(name = "DCO")
    private String dco;
    @Basic(optional = false)
  
    @Column(name = "WEB")
    private String web;

    @Column(name = "Valorac")
    private String valorac;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idviajes")
    private Integer idviajes;
    @Basic(optional = false)

    @Column(name = "idmenu")
    private int idmenu;
    @Column(name = "NSelect")
    private Integer nSelect;
    @Column(name = "idOpinion")
    private Integer idOpinion;
    @JoinColumn(name = "idmes", referencedColumnName = "idmes")
    @ManyToOne(optional = false)
    private Meses idmes;
   

    public Viajes() {
    }

    public Viajes(Integer idviajes) {
        this.idviajes = idviajes;
    }

    public Viajes(Integer idviajes, int idmenu, String descripcion, String cll, String cd, String et, String dd, String dco, String web) {
        this.idviajes = idviajes;
        this.idmenu = idmenu;
        this.descripcion = descripcion;
        this.cll = cll;
        this.cd = cd;
        this.et = et;
        this.dd = dd;
        this.dco = dco;
        this.web = web;
    }

    public Integer getIdviajes() {
        return idviajes;
    }

    public void setIdviajes(Integer idviajes) {
        this.idviajes = idviajes;
    }

    public int getIdmenu() {
        return idmenu;
    }

    public void setIdmenu(int idmenu) {
        this.idmenu = idmenu;
    }


    public Integer getNSelect() {
        return nSelect;
    }

    public void setNSelect(Integer nSelect) {
        this.nSelect = nSelect;
    }


    public Integer getIdOpinion() {
        return idOpinion;
    }

    public void setIdOpinion(Integer idOpinion) {
        this.idOpinion = idOpinion;
    }

    public Meses getIdmes() {
        return idmes;
    }

    public void setIdmes(Meses idmes) {
        this.idmes = idmes;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idviajes != null ? idviajes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Viajes)) {
            return false;
        }
        Viajes other = (Viajes) object;
        if ((this.idviajes == null && other.idviajes != null) || (this.idviajes != null && !this.idviajes.equals(other.idviajes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Viajes[ idviajes=" + idviajes + " ]";
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCll() {
        return cll;
    }

    public void setCll(String cll) {
        this.cll = cll;
    }

    public String getCd() {
        return cd;
    }

    public void setCd(String cd) {
        this.cd = cd;
    }

    public String getEt() {
        return et;
    }

    public void setEt(String et) {
        this.et = et;
    }

    public String getDd() {
        return dd;
    }

    public void setDd(String dd) {
        this.dd = dd;
    }

    public String getDco() {
        return dco;
    }

    public void setDco(String dco) {
        this.dco = dco;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getValorac() {
        return valorac;
    }

    public void setValorac(String valorac) {
        this.valorac = valorac;
    }
    
}
