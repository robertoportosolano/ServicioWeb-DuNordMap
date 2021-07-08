/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import edu.uninorte.Building;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author usuario
 */
@Stateless
@Path("edu.uninorte.building")
public class BuildingFacadeREST extends AbstractFacade<Building> {
    @PersistenceContext(unitName = "DuNordMapPU")
    private EntityManager em;

    public BuildingFacadeREST() {
        super(Building.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Building entity) {
        super.create(entity);
    }

    @PUT
    @Override
    @Consumes({"application/xml", "application/json"})
    public void edit(Building entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") BigDecimal id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Building find(@PathParam("id") BigDecimal id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Building> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Building> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @GET
    @Path("near/{lon}/{lat}")
    @Produces({"application/json"})
    public List<Building> findNear(@PathParam("lon") Double lon, @PathParam("lat") Double lat) {
        List<Building> b = super.findAll();
        HashMap<Double,Building> map = new HashMap<Double, Building>();
        for (Building building : b) {
            map.put(new Double(building.Euclidean_distance(lat, lon)), building);
        }
        b.clear();
        for (Map.Entry<Double, Building> entry : map.entrySet()) {
            Double double1 = entry.getKey();
            Building building = entry.getValue();
            b.add(building);
        }
        return b;
    }
    
    @GET
    @Path("allinfo/{id}")
    @Produces({"application/json"})
    public Building findAllInfo(@PathParam("id") BigDecimal id) {
         
          Building b= super.find(id);
          //BuildingInfoFacadeREST binfo = new BuildingInfoFacadeREST();
          //b.setBuildingInfoCollection(binfo.findbyBuilding(id));          
          return b;
    }
    
}
