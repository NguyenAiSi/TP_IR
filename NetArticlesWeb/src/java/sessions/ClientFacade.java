/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import dao.Client;
import daoRest.ClientRest;
import javax.ejb.Stateless;

/**
 *
 * @author Epulapp
 */
@Stateless
public class ClientFacade {

    private Client client;

    /**
     *
     * @return
     */
    public Client getClient() {
        return client;
    }

    /**
     *
     * @param client
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     *
     * @param login
     * @return
     * @throws Exception
     */
    public Client connecter(String login) throws Exception {
        try {
            ClientRest clientR = new ClientRest();
            return clientR.connecter(Client.class, login);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     *
     * @param login
     * @param pwd
     * @return
     * @throws Exception
     */
    public boolean connecter(String login, String pwd) throws Exception {
        boolean retour = false;
        try {
            this.client = connecter(login);
            
            if (pwd.equals(client.getPwdClient())) {
                retour = true;
            }
            
            return retour;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     *
     * @param idClient
     * @return
     * @throws Exception
     */
    public Client getClient(int idClient) throws Exception {
        try {
            ClientRest clientR = new ClientRest();
            
            return clientR.getClient(idClient);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     *
     * @param client
     * @return
     * @throws Exception
     */
    public Client modifierClient(Client client) throws Exception {
        try {
            ClientRest clientR = new ClientRest();
            
            return clientR.modifierClient(client);
        } catch (Exception e) {
            throw e;
        }
    }
}
