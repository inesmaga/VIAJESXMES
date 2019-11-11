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
 * @author inesm
 */
@Entity
@Table(name = "valoracion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Valoracion.findAll", query = "SELECT v FROM Valoracion v")
    , @NamedQuery(name = "Valoracion.findByCodigo", query = "SELECT v FROM Valoracion v WHERE v.codigo = :codigo")
    , @NamedQuery(name = "Valoracion.findCByIdviajeP", query = "SELECT v.codigo FROM Valoracion v WHERE v.idviaje = :idviaje and v.idpersona = :idpersona")
    , @NamedQuery(name = "Valoracion.findByIdpersona", query = "SELECT v FROM Valoracion v WHERE v.idpersona = :idpersona")
    , @NamedQuery(name = "Valoracion.findByIdviaje", query = "SELECT v FROM Valoracion v WHERE v.idviaje = :idviaje")
    , @NamedQuery(name = "Valoracion.findValorByIdviajeP", query = "SELECT v FROM Valoracion v WHERE v.idviaje = :idviaje and v.idpersona = :idpersona")
    , @NamedQuery(name = "Valoracion.findByFechaval", query = "SELECT v FROM Valoracion v WHERE v.fechaval = :fechaval")
    , @NamedQuery(name = "Valoracion.findByValorac", query = "SELECT v FROM Valoracion v WHERE v.valorac = :valorac")})
public class Valoracion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    
    @Column(name = "idpersona")
    private int idpersona;
    @Basic(optional = false)

    @Column(name = "idviaje")
    private int idviaje;
    @Basic(optional = false)

    @Column(name = "fechaval")
    @Temporal(TemporalType.DATE)
    private Date fechaval;
    @Basic(optional = false)
 
    @Column(name = "valorac")
    private int valorac;

    public Valoracion() {
    }

    public Valoracion(Integer codigo) {
        this.codigo = codigo;
    }

    public Valoracion(Integer codigo, int idpersona, int idviaje, Date fechaval, int valorac) {
        this.codigo = codigo;
        this.idpersona = idpersona;
        this.idviaje = idviaje;
        this.fechaval = fechaval;
        this.valorac = valorac;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
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

    public Date getFechaval() {
        return fechaval;
    }

    public void setFechaval(Date fechaval) {
        this.fechaval = fechaval;
    }

    public int getValorac() {
        return valorac;
    }

    public void setValorac(int valorac) {
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
        if (!(object instanceof Valoracion)) {
            return false;
        }
        Valoracion other = (Valoracion) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Valoracion[ codigo=" + codigo + " ]";
    }
    
    
    
}
