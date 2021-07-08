/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uninorte;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author usuario
 */
@Entity
@Table(name = "building")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Building.findAll", query = "SELECT b FROM Building b"),
    @NamedQuery(name = "Building.findById", query = "SELECT b FROM Building b WHERE b.id = :id"),
    @NamedQuery(name = "Building.findByName", query = "SELECT b FROM Building b WHERE b.name = :name"),
    @NamedQuery(name = "Building.findByLon", query = "SELECT b FROM Building b WHERE b.lon = :lon"),
    @NamedQuery(name = "Building.findByLat", query = "SELECT b FROM Building b WHERE b.lat = :lat")})
public class Building implements Serializable {
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
    @Column(name = "lon")
    private double lon;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lat")
    private double lat;
    @OneToMany(mappedBy = "mainBuilding")
    private Collection<Building> buildingCollection;
    @JoinColumn(name = "main_building", referencedColumnName = "id")
    @ManyToOne
    private Building mainBuilding;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBuilding")
    private Collection<BuildingAdditionalInfo> buildingAdditionalInfoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBuilding")
    private Collection<BuildingInfo> buildingInfoCollection;

    public Building() {
    }

    public Building(BigDecimal id) {
        this.id = id;
    }

    public Building(BigDecimal id, String name, double lon, double lat) {
        this.id = id;
        this.name = name;
        this.lon = lon;
        this.lat = lat;
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

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    @XmlTransient
    public Collection<Building> getBuildingCollection() {
        return buildingCollection;
    }

    public void setBuildingCollection(Collection<Building> buildingCollection) {
        this.buildingCollection = buildingCollection;
    }

    public Building getMainBuilding() {
        return mainBuilding;
    }

    public void setMainBuilding(Building mainBuilding) {
        this.mainBuilding = mainBuilding;
    }

    @XmlTransient
    public Collection<BuildingAdditionalInfo> getBuildingAdditionalInfoCollection() {
        return buildingAdditionalInfoCollection;
    }

    public void setBuildingAdditionalInfoCollection(Collection<BuildingAdditionalInfo> buildingAdditionalInfoCollection) {
        this.buildingAdditionalInfoCollection = buildingAdditionalInfoCollection;
    }

    @XmlTransient
    public Collection<BuildingInfo> getBuildingInfoCollection() {
        return buildingInfoCollection;
    }

    public void setBuildingInfoCollection(Collection<BuildingInfo> buildingInfoCollection) {
        this.buildingInfoCollection = buildingInfoCollection;
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
        if (!(object instanceof Building)) {
            return false;
        }
        Building other = (Building) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uninorte.Building[ id=" + id + " ]";
    }
    
    public double Euclidean_distance(double lat,double lon){
        return Math.sqrt(Math.pow(lat-this.lat, 2)+Math.pow(lon-this.lon,2));
    }
    
}
