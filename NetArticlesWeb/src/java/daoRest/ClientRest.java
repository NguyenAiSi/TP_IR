/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoRest;

import dao.Client;
import javax.json.JsonObject;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import outils.Utilitaire;

/**
 *
 * @author Epulapp
 */
public class ClientRest extends NetArticlesRest {

    /**
     *
     */
    public ClientRest() {
        super();
    }

    /**
     *
     * @param <T>
     * @param responseType
     * @param login
     * @return
     * @throws ClientErrorException
     * @throws Exception
     */
    public <T> T connecter(Class<T> responseType, String login) throws ClientErrorException, Exception {
        WebTarget resource = target;
        resource = resource.path(java.text.MessageFormat.format("connecter/{0}", new Object[]{login}));
        Response response = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get();
        
        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            JsonObject jsonObject = Utilitaire.convertJson(response.readEntity(String.class));
            String message = jsonObject.getString("message");
            throw new Exception(message);
        }
        
        return response.readEntity(responseType);
    }

    /**
     *
     * @param idClient
     * @return
     * @throws ClientErrorException
     * @throws Exception
     */
    public Client getClient(int idClient) throws ClientErrorException, Exception {
        WebTarget resource = target;
        resource = resource.path(java.text.MessageFormat.format("getClient/{0}", new Object[]{idClient}));
        Response response = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get();
        
        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            JsonObject jsonObject = Utilitaire.convertJson(response.readEntity(String.class));
            String message = jsonObject.getString("message");
            throw new Exception(message);
        }
        
        return response.readEntity(new GenericType<Client>(){});
    }

    /**
     *
     * @param client
     * @return
     * @throws Exception
     */
    public Client modifierClient(Client client) throws Exception {
        WebTarget resource = target;
        Response response = resource.path("modifierClient").request(MediaType.APPLICATION_JSON).post(Entity.entity(client, MediaType.APPLICATION_JSON), Response.class);
        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            JsonObject jsonObject = Utilitaire.convertJson(response.readEntity(String.class));
            String message = jsonObject.getString("message");
            throw new Exception(message);
        }
        
        return response.readEntity(new GenericType<Client>(){});
    }
}
