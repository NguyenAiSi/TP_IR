/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.Compte;
import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import outils.Utilitaire;
import sessions.CompteFacade;

/**
 * REST Web Service
 *
 * @author Epulapp
 */
@Path("webService")
public class WebServiceResource {

    @EJB
    private CompteFacade compteF;

    /**
     * Creates a new instance of WebServiceResource
     */
    public WebServiceResource() {
    }

    /**
     * Retrieves representation of an instance of services.WebServiceResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of WebServiceResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }

    /**
     *
     * @param idCompte
     * @return
     * @throws Exception
     */
    @GET
    @Path("getCompteById/{idCompte}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCompteById(@PathParam("idCompte") int idCompte) throws Exception {
        Response response = null;
        try {
            Compte compte = compteF.getCompteById(idCompte);
            response = Response.status(Response.Status.OK).entity(compte).header("content-type", "application/json; charset=UTF-8").build();
        } catch (Exception ex) {
            String msg = Utilitaire.getExceptionCause(ex);
            JsonObject retour = Json.createObjectBuilder().add("message", msg).build();
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(retour).build();
        }
        return response;
    }

    /**
     *
     * @param idCompte
     * @param somme
     * @return
     * @throws Exception
     */
    @GET
    @Path("status/{idCompte}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response autorisation(@PathParam("idCompte") int idCompte, @PathParam("montantPanier") int somme) throws Exception {
        Response response = null;
        JsonObject resultat = null; 
        
        try {

            boolean status = compteF.Autorisation(idCompte, somme);
            
            if (status) {
                resultat = Json.createObjectBuilder().add("resultat", "true").build();
            } else {
                resultat = Json.createObjectBuilder().add("resultat", "false").build();
            }
            response = Response.status(Response.Status.OK).entity(resultat).header("content-type", "application/json; charset=UTF-8").build();
        } catch (Exception ex) {
            String msg = Utilitaire.getExceptionCause(ex);
            JsonObject retour = Json.createObjectBuilder().add("message", msg).build();
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(retour).build();
        }
        
        return response;
    }

    /**
     *
     * @param idCompte
     * @param somme
     * @return
     * @throws Exception
     */
    @GET
    @Path("payer/{idCompte}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response payer(@PathParam("idCompte") int idCompte, @PathParam("somme") int somme) throws Exception {
        Response response = null;
        try {
            compteF.payer(idCompte, somme);
            response = Response.status(Response.Status.OK).header("content-type", "application/json; charset=UTF-8").build();
        } catch (Exception ex) {
            String msg = Utilitaire.getExceptionCause(ex);
            JsonObject retour = Json.createObjectBuilder().add("message", msg).build();
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(retour).build();
        }
        
        return response;
    }

    /**
     *
     * @param idCompte
     * @param solde
     * @return
     * @throws Exception
     */
    @GET
    @Path("modifier/{idCompte}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response modifier(@PathParam("idCompte") int idCompte, @PathParam("solde") int solde) throws Exception {
        Response response = null;
        
        try {
            compteF.modifier(idCompte, solde);
            response = Response.status(Response.Status.OK).header("content-type", "application/json; charset=UTF-8").build();

        } catch (Exception ex) {
            String msg = Utilitaire.getExceptionCause(ex);
            JsonObject retour = Json.createObjectBuilder().add("message", msg).build();
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(retour).build();
        }
        return response;
    }
}
