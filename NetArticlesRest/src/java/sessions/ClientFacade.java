/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import dao.Client;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Epulapp
 */
@Stateless
@LocalBean
public class ClientFacade {

    @PersistenceContext(unitName = "NetArticlesRestPU")
    private EntityManager em;

    /**
     *
     * @return
     */
    protected EntityManager getEntityManager() {
        return this.em;
    }

    private Client client;

    /**
     *
     * @return
     */
    public Client getClient() {
        return this.client;
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
     */
    public Client connecter(String login) {
        try {
            Query query = em.createNamedQuery("Client.findByLoginClient");
            query.setParameter("loginClient", login);

            return (Client) query.getSingleResult();
        } catch (Exception ex) {
            throw ex;
        }
    }

    /**
     *
     * @param idClient
     * @return
     */
    public Client getClientById(int idClient) {
        try {
            Query query = em.createNamedQuery("Client.findByIdClient");
            query.setParameter("idClient", idClient);
            
            return (Client) query.getSingleResult();
        } catch (Exception ex) {
            throw ex;
        }
    }

    /**
     *
     * @param client
     */
    public void modifierClient(Client client) {
        em.merge(client);
    }
}

