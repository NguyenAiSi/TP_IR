/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoRest;

import javax.ws.rs.client.WebTarget;

/**
 *
 * @author Epulapp
 */
public class NetArticlesRest {

    /**
     *
     */
    protected WebTarget target;

    /**
     *
     */
    protected javax.ws.rs.client.Client client;

    /**
     *
     */
    protected static final String BASE_URI = "http://localhost:8080/NetArticlesRest/webresources";

    /**
     *
     */
    public NetArticlesRest() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        target = client.target(BASE_URI).path("webservice");
    }
}
