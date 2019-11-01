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
import javax.persistence.Lob;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author inesm
 */
@Entity
@Table(name = "opinion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Opinion.findAll", query = "SELECT o FROM Opinion o")
    , @NamedQuery(name = "Opinion.findByCodigo", query = "SELECT o FROM Opinion o WHERE o.codigo = :codigo")
    , @NamedQuery(name = "Opinion.findByIdviaje", query = "SELECT o FROM Opinion o WHERE o.idviaje = :idviaje")
    , @NamedQuery(name = "Opinion.findByIdpersona", query = "SELECT o FROM Opinion o WHERE o.idpersona = :idpersona")
    , @NamedQuery(name = "Opinion.findByFechaop", query = "SELECT o FROM Opinion o WHERE o.fechaop = :fechaop")
    , @NamedQuery(name = "Opinion.findByValorac", query = "SELECT o FROM Opinion o WHERE o.valorac = :valorac")})
public class Opinion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)

    @Column(name = "idviaje")
    private int idviaje;
    @Basic(optional = false)
 
    @Column(name = "idpersona")
    private int idpersona;
    @Basic(optional = false)

    @Lob
    @Column(name = "opinion")
    private String opinion;
    @Basic(optional = false)

    @Column(name = "fechaop")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaop;
    @Column(name = "valorac")
    private Integer valorac;

    public Opinion() {
    }

    public Opinion(Integer codigo) {
        this.codigo = codigo;
    }

    public Opinion(Integer codigo, int idviaje, int idpersona, String opinion, Date fechaop) {
        this.codigo = codigo;
        this.idviaje = idviaje;
        this.idpersona = idpersona;
        this.opinion = opinion;
        this.fechaop = fechaop;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public int getIdviaje() {
        return idviaje;
    }

    public void setIdviaje(int idviaje) {
        this.idviaje = idviaje;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public Date getFechaop() {
        return fechaop;
    }

    public void setFechaop(Date fechaop) {
        this.fechaop = fechaop;
    }

    public Integer getValorac() {
        return valorac;
    }

    public void setValorac(Integer valorac) {
        this.valorac = valorac;
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
        if (!(object instanceof Opinion)) {
            return false;
        }
        Opinion other = (Opinion) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Opinion[ codigo=" + codigo + " ]";
    }
    
}
