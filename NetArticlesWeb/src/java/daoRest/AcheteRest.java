/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoRest;

import dao.Achete;
import java.util.List;
import javax.json.JsonObject;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import outils.Utilitaire;

/**
 *
 * @author Epulapp
 */
public class AcheteRest extends NetArticlesRest {
    
    /**
     *
     */
    public AcheteRest() {
        super();
    }
    
    /**
     *
     * @param idClient
     * @param idArticle
     * @throws Exception
     */
    public void ajouterAchete(int idClient, int idArticle) throws Exception {
        WebTarget resource = target;
        resource = resource.path("ajouterAchete");
        Response response = resource.queryParam("idClient", idClient).queryParam("idArticle", idArticle).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get();
        
        if(response.getStatus() != Response.Status.OK.getStatusCode()){
            JsonObject jsonObject = Utilitaire.convertJson(response.readEntity(String.class));
            String message = jsonObject.getString("message");
            throw new Exception(message);           
        }
    }
    
    /**
     *
     * @param idClient
     * @return
     * @throws Exception
     */
    public List<Achete> getListAchetesByClient(int idClient) throws Exception{
        WebTarget resource = target;
        resource = resource.path(java.text.MessageFormat.format("getListAchetesByClient/{0}", new Object[]{idClient}));
        Response response = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get();
        
        if(response.getStatus() != Response.Status.OK.getStatusCode()){
            JsonObject jsonObject = Utilitaire.convertJson(response.readEntity(String.class));
            String message = jsonObject.getString("message");
            throw new Exception(message);           
        }
        
        return response.readEntity(new GenericType<List<Achete>>(){});
    }
}
