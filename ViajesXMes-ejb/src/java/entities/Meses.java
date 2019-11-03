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
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author inesm
 */
@Entity
@Table(name = "meses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Meses.findAll", query = "SELECT m FROM Meses m")
    , @NamedQuery(name = "Meses.findByIdmes", query = "SELECT m FROM Meses m WHERE m.idmes = :idmes")
    , @NamedQuery(name = "Meses.findByNommes", query = "SELECT m FROM Meses m WHERE m.nommes = :nommes")})
public class Meses implements Serializable {

    @Basic(optional = false)
  
    @NotNull()
    @Size(min = 1, max = 11)
    @Column(name = "nommes")
    private String nommes;
    @Basic(optional = false)
    
    @NotNull
    @Lob()
    @Size(min = 1, max = 16777215)
    @Column(name = "adonde")
    private String adonde;
    @Basic(optional = false)
 
    @NotNull
    @Lob()
    @Size(min = 1, max = 16777215)
    @Column(name = "condtiemp")
    private String condtiemp;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
   
    @Column(name = "idmes")
    private Integer idmes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmes")
    private List<Viajes> viajesList;
    

    public Meses() {
    }

    public Meses(Integer idmes) {
        this.idmes = idmes;
    }

    public Meses(Integer idmes, String nommes, String adonde, String condtiemp) {
        this.idmes = idmes;
        this.nommes = nommes;
        this.adonde = adonde;
        this.condtiemp = condtiemp;
    }

    public Integer getIdmes() {
        return idmes;
    }

    public void setIdmes(Integer idmes) {
        this.idmes = idmes;
    }


    @XmlTransient
    public List<Viajes> getViajesList() {
        return viajesList;
    }

    public void setViajesList(List<Viajes> viajesList) {
        this.viajesList = viajesList;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmes != null ? idmes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Meses)) {
            return false;
        }
        Meses other = (Meses) object;
        if ((this.idmes == null && other.idmes != null) || (this.idmes != null && !this.idmes.equals(other.idmes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Meses[ idmes=" + idmes + " ]";
    }

    public String getNommes() {
        return nommes;
    }

    public void setNommes(String nommes) {
        this.nommes = nommes;
    }

    public String getAdonde() {
        return adonde;
    }

    public void setAdonde(String adonde) {
        this.adonde = adonde;
    }

    public String getCondtiemp() {
        return condtiemp;
    }

    public void setCondtiemp(String condtiemp) {
        this.condtiemp = condtiemp;
    }
    
}
