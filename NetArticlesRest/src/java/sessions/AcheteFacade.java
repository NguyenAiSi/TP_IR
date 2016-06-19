/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import dao.Achete;
import java.util.Date;
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
public class AcheteFacade {

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
     * @param idClient
     * @param idArticle
     */
    public void ajouterAchete(int idClient, int idArticle){
        Achete a = new Achete(idClient, idArticle);
        a.setDateAchat(new Date());
        em.persist(a);
    }
    
    /**
     *
     * @param idClient
     * @return
     */
    public List<Achete> getListAchetesByClient(int idClient){
       Query query = em.createNamedQuery("Achete.findByIdClient");
       query.setParameter("idClient", idClient);
       
       return (List<Achete>)query.getResultList();
    }
}
