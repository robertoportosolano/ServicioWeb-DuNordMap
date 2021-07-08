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
@Table(name = "building_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BuildingInfo.findAll", query = "SELECT b FROM BuildingInfo b"),
    @NamedQuery(name = "BuildingInfo.findByArea", query = "SELECT b FROM BuildingInfo b WHERE b.area = :area"),
    @NamedQuery(name = "BuildingInfo.findById", query = "SELECT b FROM BuildingInfo b WHERE b.id = :id"),
    @NamedQuery(name = "BuildingInfo.findByPicture", query = "SELECT b FROM BuildingInfo b WHERE b.picture = :picture"),
    @NamedQuery(name = "BuildingInfo.findbyBuilding", query = "SELECT b FROM BuildingInfo b WHERE b.idBuilding = :id")
})
public class BuildingInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 50)
    @Column(name = "area")
    private String area;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "picture")
    private String picture;
    @JoinColumn(name = "id_building", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Building idBuilding;

    public BuildingInfo() {
    }

    public BuildingInfo(BigDecimal id) {
        this.id = id;
    }

    public BuildingInfo(BigDecimal id, String picture) {
        this.id = id;
        this.picture = picture;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
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
        if (!(object instanceof BuildingInfo)) {
            return false;
        }
        BuildingInfo other = (BuildingInfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uninorte.BuildingInfo[ id=" + id + " ]";
    }
    
}
