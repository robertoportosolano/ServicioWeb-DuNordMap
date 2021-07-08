/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import edu.uninorte.BuildingInfo;
import java.math.BigDecimal;
import java.util.List;
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
@Path("edu.uninorte.buildinginfo")
public class BuildingInfoFacadeREST extends AbstractFacade<BuildingInfo> {
    @PersistenceContext(unitName = "DuNordMapPU")
    private EntityManager em;

    public BuildingInfoFacadeREST() {
        super(BuildingInfo.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(BuildingInfo entity) {
        super.create(entity);
    }

    @PUT
    @Override
    @Consumes({"application/xml", "application/json"})
    public void edit(BuildingInfo entity) {
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
    public BuildingInfo find(@PathParam("id") BigDecimal id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<BuildingInfo> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<BuildingInfo> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    @Path("infobuilding/{id}")
    @Produces({"application/json"})
    public List<BuildingInfo> findbyBuilding(@PathParam("id") BigDecimal id) {
        javax.persistence.criteria.CriteriaQuery cq = this.getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq).setParameter("id", id);
        return q.getResultList();
    }
    
}
