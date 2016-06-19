/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoRest;

import dao.Article;
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
public class ArticleRest extends NetArticlesRest {

    /**
     *
     */
    public ArticleRest() {
        super();
    }

    /**
     *
     * @param idArticle
     * @return
     * @throws ClientErrorException
     * @throws Exception
     */
    public Article getArticle(int idArticle) throws ClientErrorException, Exception {
        WebTarget resource = target;
        resource = resource.path(java.text.MessageFormat.format("getArticle/{0}", new Object[]{idArticle}));
        Response response = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get();
        
        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            JsonObject jsonObject = Utilitaire.convertJson(response.readEntity(String.class));
            String message = jsonObject.getString("message");
            throw new Exception(message);
        }
        
        return response.readEntity(new GenericType<Article>(){});
    }

    /**
     *
     * @return
     * @throws ClientErrorException
     * @throws Exception
     */
    public Article getDernierArticle() throws ClientErrorException, Exception {
        WebTarget resource = target;
        resource = resource.path("getDernierArticle");
        Response response = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get();
        
        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            JsonObject jsonObject = Utilitaire.convertJson(response.readEntity(String.class));
            String message = jsonObject.getString("message");
            throw new Exception(message);
        }
        
        return response.readEntity(new GenericType<Article>(){});
    }

    /**
     *
     * @param idDomaine
     * @return
     * @throws ClientErrorException
     * @throws Exception
     */
    public List<Article> getListArticlesByDomaine(int idDomaine) throws ClientErrorException, Exception {
        WebTarget resource = target;
        resource = resource.path(java.text.MessageFormat.format("getListArticlesByDomaine/{0}", new Object[]{idDomaine}));
        Response response = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get();
        
        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            JsonObject jsonObject = Utilitaire.convertJson(response.readEntity(String.class));
            String message = jsonObject.getString("message");
            throw new Exception(message);
        }
        
        return response.readEntity(new GenericType<List<Article>>(){});
    }
}
