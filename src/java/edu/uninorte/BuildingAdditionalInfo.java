/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uninorte;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "building_additional_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BuildingAdditionalInfo.findAll", query = "SELECT b FROM BuildingAdditionalInfo b"),
    @NamedQuery(name = "BuildingAdditionalInfo.findById", query = "SELECT b FROM BuildingAdditionalInfo b WHERE b.id = :id"),
    @NamedQuery(name = "BuildingAdditionalInfo.findByName", query = "SELECT b FROM BuildingAdditionalInfo b WHERE b.name = :name"),
    @NamedQuery(name = "BuildingAdditionalInfo.findByValue", query = "SELECT b FROM BuildingAdditionalInfo b WHERE b.value = :value")    
})
public class BuildingAdditionalInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "value")
    private String value;
    @JoinColumn(name = "id_building", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Building idBuilding;

    public BuildingAdditionalInfo() {
    }

    public BuildingAdditionalInfo(BigDecimal id) {
        this.id = id;
    }

    public BuildingAdditionalInfo(BigDecimal id, String name, String value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Building getIdBuilding() {
        return idBuilding;
    }

    public void setIdBuilding(Building idBuilding) {
        this.idBuilding = idBuilding;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BuildingAdditionalInfo)) {
            return false;
        }
        BuildingAdditionalInfo other = (BuildingAdditionalInfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uninorte.BuildingAdditionalInfo[ id=" + id + " ]";
    }
    
}
