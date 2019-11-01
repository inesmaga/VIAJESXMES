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
@Table(name = "contactos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contactos.findAll", query = "SELECT c FROM Contactos c")
    , @NamedQuery(name = "Contactos.findByCodigo", query = "SELECT c FROM Contactos c WHERE c.codigo = :codigo")
    , @NamedQuery(name = "Contactos.findByIdpersona", query = "SELECT c FROM Contactos c WHERE c.idpersona = :idpersona")
    , @NamedQuery(name = "Contactos.findByFechacont", query = "SELECT c FROM Contactos c WHERE c.fechacont = :fechacont")
    , @NamedQuery(name = "Contactos.findByTema", query = "SELECT c FROM Contactos c WHERE c.tema = :tema")})
public class Contactos implements Serializable {

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

    @Column(name = "fechacont")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacont;
    @Basic(optional = false)
 
    @Column(name = "tema")
    private String tema;
    @Basic(optional = false)

    @Lob
   
    @Column(name = "descripcion")
    private String descripcion;

    public Contactos() {
    }

    public Contactos(Integer codigo) {
        this.codigo = codigo;
    }

    public Contactos(Integer codigo, int idpersona, Date fechacont, String tema, String descripcion) {
        this.codigo = codigo;
        this.idpersona = idpersona;
        this.fechacont = fechacont;
        this.tema = tema;
        this.descripcion = descripcion;
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

    public Date getFechacont() {
        return fechacont;
    }

    public void setFechacont(Date fechacont) {
        this.fechacont = fechacont;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        if (!(object instanceof Contactos)) {
            return false;
        }
        Contactos other = (Contactos) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Contactos[ codigo=" + codigo + " ]";
    }
    
}
