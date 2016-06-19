/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import dao.Domaine;
import java.util.List;
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
public class DomaineFacade {

    @PersistenceContext(unitName = "NetArticlesRestPU")
    private EntityManager em;

    /**
     *
     * @return
     */
    protected EntityManager getEntityManager() {
        return this.em;
    }

    /**
     *
     * @return
     */
    public List<Domaine> getListDomaines() {
        try {
            Query query = em.createNamedQuery("Domaine.findAll");

            return (List<Domaine>)query.getResultList();
        } catch (Exception ex) {
            throw ex;
        }
    }

}
