/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoRest;

import dao.Domaine;
import java.util.List;
import javax.json.JsonObject;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import outils.Utilitaire;

/**
 *
 * @author Epulapp
 */
public class DomaineRest extends NetArticlesRest {

    /**
     *
     */
    public DomaineRest() {
        super();
    }

    /**
     *
     * @return
     * @throws ClientErrorException
     * @throws Exception
     */
    public List<Domaine> getListDomaines() throws ClientErrorException, Exception {
        WebTarget resource = target;
        resource = resource.path("getListDomaines");
        Response response = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get();
        
        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            JsonObject jsonObject = Utilitaire.convertJson(response.readEntity(String.class));
            String message = jsonObject.getString("message");
            throw new Exception(message);
        }
        
        return response.readEntity(new GenericType<List<Domaine>>(){});
    }
}
