/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.Achete;
import dao.Article;
import dao.Categorie;
import dao.Client;
import dao.Domaine;
import java.util.List;
import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import outils.Utilitaire;
import sessions.AcheteFacade;
import sessions.ArticleFacade;
import sessions.CategorieFacade;
import sessions.ClientFacade;
import sessions.DomaineFacade;

/**
 * REST Web Service
 *
 * @author Epulapp
 */
@Path("webService")
public class WebServiceRessource {

    @EJB
    AcheteFacade achatF;

    @EJB
    ArticleFacade articleF;

    @EJB
    CategorieFacade categorieF;

    @EJB
    ClientFacade clientF;

    @EJB
    DomaineFacade domaineF;

    /**
     * Creates a new instance of webressource
     */
    public WebServiceRessource() {
    }

    /**
     *
     * @param login
     * @return
     * @throws Exception
     */
    @GET
    @Path("connecter/{login}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response connecter(@PathParam("login") String login) throws Exception {
        Response response = null;

        try {
            Client client = clientF.connecter(login);
            response = Response.status(Response.Status.OK).entity(client).header("content-type", "application/json; charset=UTF-8").build();
        } catch (Exception ex) {
            String msg = Utilitaire.getExceptionCause(ex);
            JsonObject retour = Json.createObjectBuilder().add("message", Utilitaire.getExceptionCause(ex)).build();
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(retour).build();
        }
        return response;
    }

    /**
     *
     * @param client
     * @return
     */
    @POST
    @Path("modifierClient")
    @Produces(MediaType.APPLICATION_JSON)
    public Response modifierClient(Client client) {
        Response response = null;

        try {
            if (client != null) {
                clientF.modifierClient(client);
                response = Response.status(Response.Status.OK).entity(client).header("content-type", "application/json; charset=UTF-8").build();
            }
        } catch (Exception ex) {
            String msg = Utilitaire.getExceptionCause(ex);
            JsonObject retour = Json.createObjectBuilder().add("message", msg).build();
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(retour).build();
        }
        return response;
    }

    /**
     *
     * @param idClient
     * @return
     * @throws Exception
     */
    @GET
    @Path("getClient/{idClient}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClient(@PathParam("idClient") int idClient) throws Exception {
        Response response = null;

        try {
            Client client = clientF.getClientById(idClient);
            response = Response.status(Response.Status.OK).entity(client).header("content-type", "application/json; charset=UTF-8").build();
        } catch (Exception ex) {
            String msg = Utilitaire.getExceptionCause(ex);
            JsonObject retour = Json.createObjectBuilder().add("message", msg).build();
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(retour).build();
        }
        return response;
    }

    /**
     *
     * @param idClient
     * @return
     * @throws Exception
     */
    @GET
    @Path("getListAcheteByClient/{idClient}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListAcheteByClient(@PathParam("idClient") int idClient) throws Exception {
        Response response = null;

        try {
            List<Achete> listeArticle = achatF.getListAchetesByClient(idClient);
            response = Response.status(Response.Status.OK).entity(listeArticle).header("content-type", "application/json; charset=UTF-8").build();
        } catch (Exception ex) {
            String msg = Utilitaire.getExceptionCause(ex);
            JsonObject retour = Json.createObjectBuilder().add("message", msg).build();
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(retour).build();
        }
        return response;
    }

    /**
     *
     * @param idClient
     * @param idArticle
     * @return
     * @throws Exception
     */
    @GET
    @Path("ajouterAchete")
    @Produces(MediaType.APPLICATION_JSON)
    public Response ajouterAchete(@PathParam("idClient") int idClient, @PathParam("idArticle") int idArticle) throws Exception {
        Response response = null;

        try {
            achatF.ajouterAchete(idClient, idArticle);
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
     * @param idCategorie
     * @return
     * @throws Exception
     */
    @GET
    @Path("getCategorie/{idCategorie}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCategorie(@PathParam("idCategorie") int idCategorie) throws Exception {
        Response response = null;

        try {
            Categorie categorie = categorieF.getCategorie(idCategorie);
            response = Response.status(Response.Status.OK).entity(categorie).header("content-type", "application/json; charset=UTF-8").build();
        } catch (Exception ex) {
            String msg = Utilitaire.getExceptionCause(ex);
            JsonObject retour = Json.createObjectBuilder().add("message", msg).build();
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(retour).build();
        }
        return response;
    }

    /**
     *
     * @return
     * @throws Exception
     */
    @GET
    @Path("getListCategories")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListCategories() throws Exception {
        Response response = null;

        try {
            List<Categorie> listeCategories = categorieF.getListCategories();
            response = Response.status(Response.Status.OK).entity(listeCategories).header("content-type", "application/json; charset=UTF-8").build();
        } catch (Exception ex) {
            String msg = Utilitaire.getExceptionCause(ex);
            JsonObject retour = Json.createObjectBuilder().add("message", msg).build();
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(retour).build();
        }
        return response;
    }

    /**
     *
     * @return
     * @throws Exception
     */
    @GET
    @Path("getListDomaines")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListDomaines() throws Exception {
        Response response = null;

        try {
            List<Domaine> listeDomaines = domaineF.getListDomaines();
            response = Response.status(Response.Status.OK).entity(listeDomaines).header("content-type", "application/json; charset=UTF-8").build();
        } catch (Exception ex) {
            String msg = Utilitaire.getExceptionCause(ex);
            JsonObject retour = Json.createObjectBuilder().add("message", msg).build();
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(retour).build();
        }
        return response;
    }

    /**
     *
     * @param idArticle
     * @return
     * @throws Exception
     */
    @GET
    @Path("getArticle/{idArticle}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getArticle(@PathParam("idArticle") int idArticle) throws Exception {
        Response response = null;

        try {
            Article article = articleF.getArticle(idArticle);
            response = Response.status(Response.Status.OK).entity(article).header("content-type", "application/json; charset=UTF-8").build();
        } catch (Exception ex) {
            String msg = Utilitaire.getExceptionCause(ex);
            JsonObject retour = Json.createObjectBuilder().add("message", msg).build();
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(retour).build();
        }
        return response;
    }

    /**
     *
     * @return
     * @throws Exception
     */
    @GET
    @Path("getDernierArticle")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDernierArticle() throws Exception {
        Response response = null;

        try {
            Article article = articleF.getDernierArticle();
            response = Response.status(Response.Status.OK).entity(article).header("content-type", "application/json; charset=UTF-8").build();
        } catch (Exception ex) {
            String msg = Utilitaire.getExceptionCause(ex);
            JsonObject retour = Json.createObjectBuilder().add("message", msg).build();
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(retour).build();
        }
        return response;
    }

    /**
     *
     * @param idDomaine
     * @return
     * @throws Exception
     */
    @GET
    @Path("getListArticlesByDomaine/{idDomaine}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListArticlesByDomaine(@PathParam("idDomaine") int idDomaine) throws Exception {
        Response response = null;

        try {
            List<Article> listeArticles = articleF.getListArticlesByDomaine(idDomaine);
            response = Response.status(Response.Status.OK).entity(listeArticles).header("content-type", "application/json; charset=UTF-8").build();
        } catch (Exception ex) {
            String msg = Utilitaire.getExceptionCause(ex);
            JsonObject retour = Json.createObjectBuilder().add("message", msg).build();
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(retour).build();
        }
        return response;
    }
}
