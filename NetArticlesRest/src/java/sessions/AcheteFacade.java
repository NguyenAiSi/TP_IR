/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import dao.Achete;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Epulapp
 */
@Stateless
@LocalBean
public class AcheteFacade {

    @PersistenceContext(unitName = "NetArticlesRestPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return this.em;
    }

    /**
     * Liste des catégories
     *
     * @return : Collection de Categorie
     * @throws Exception
     */
    public List<Achete> lister() throws Exception {
        try {
            return (em.createNamedQuery("Categorie.findAll").getResultList());
        } catch (Exception e) {
            throw e;
        }
    }
}
