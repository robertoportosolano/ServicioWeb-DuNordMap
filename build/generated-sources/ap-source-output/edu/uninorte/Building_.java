package edu.uninorte;

import edu.uninorte.Building;
import edu.uninorte.BuildingAdditionalInfo;
import edu.uninorte.BuildingInfo;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2012-09-29T12:52:15")
@StaticMetamodel(Building.class)
public class Building_ { 

    public static volatile SingularAttribute<Building, BigDecimal> id;
    public static volatile SingularAttribute<Building, Double> lon;
    public static volatile SingularAttribute<Building, String> name;
    public static volatile CollectionAttribute<Building, Building> buildingCollection;
    public static volatile SingularAttribute<Building, Building> mainBuilding;
    public static volatile CollectionAttribute<Building, BuildingAdditionalInfo> buildingAdditionalInfoCollection;
    public static volatile SingularAttribute<Building, Double> lat;
    public static volatile CollectionAttribute<Building, BuildingInfo> buildingInfoCollection;

}