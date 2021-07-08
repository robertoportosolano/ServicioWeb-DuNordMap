package edu.uninorte;

import edu.uninorte.Building;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2012-09-29T12:52:15")
@StaticMetamodel(BuildingAdditionalInfo.class)
public class BuildingAdditionalInfo_ { 

    public static volatile SingularAttribute<BuildingAdditionalInfo, BigDecimal> id;
    public static volatile SingularAttribute<BuildingAdditionalInfo, Building> idBuilding;
    public static volatile SingularAttribute<BuildingAdditionalInfo, String> name;
    public static volatile SingularAttribute<BuildingAdditionalInfo, String> value;

}