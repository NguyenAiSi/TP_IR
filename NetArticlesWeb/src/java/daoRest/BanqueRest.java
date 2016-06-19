/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoRest;

import javax.json.JsonObject;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import outils.Utilitaire;

/**
 *
 * @author Epulapp
 */
public class BanqueRest {

    private WebTarget target;
    private javax.ws.rs.client.Client client;
    private static final String BASE_URI = "http://localhost:8080/BanqueRest/webresources";

    /**
     *
     */
    public BanqueRest() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        target = client.target(BASE_URI).path("banqueRest");
    }

    /**
     *
     * @param idCompte
     * @param somme
     * @return
     * @throws ClientErrorException
     * @throws Exception
     */
    public String Autorisation(int idCompte, int somme) throws ClientErrorException, Exception {
        WebTarget resource = target;
        resource = resource.path(java.text.MessageFormat.format("Autorisation/{0}", new Object[]{idCompte}));
        Response response = resource.queryParam("somme", somme).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get();
        JsonObject jsonObject = Utilitaire.convertJson(response.readEntity(String.class));
        String result = jsonObject.getString("resultat");

        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            String message = jsonObject.getString("message");
            throw new Exception(message);
        }
        
        return result;
    }

    /**
     *
     * @param idCompte
     * @param somme
     * @throws Exception
     */
    public void payer(int idCompte, int somme) throws Exception {
        WebTarget resource = target;
        resource = resource.path(java.text.MessageFormat.format("payer/{0}", new Object[]{idCompte}));
        Response response = resource.queryParam("somme", somme).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get();
        
        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            JsonObject jsonObject = Utilitaire.convertJson(response.readEntity(String.class));
            String message = jsonObject.getString("message");
            throw new Exception(message);
        }
    }
}
