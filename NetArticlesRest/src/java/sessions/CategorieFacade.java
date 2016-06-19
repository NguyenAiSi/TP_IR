/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import dao.Categorie;
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
public class CategorieFacade {

    @PersistenceContext(unitName = "NetArticlesRestPU")
    private EntityManager em;

    /**
     *
     * @return
     */
    public List<Categorie> getListCategories() {
        Query query = em.createNamedQuery("Categorie.findAll");

        return (List<Categorie>) query.getResultList();
    }

    /**
     *
     * @param idCategorie
     * @return
     */
    public Categorie getCategorie(int idCategorie) {
        Query query = em.createNamedQuery("Categorie.findByIdCategorie");
        query.setParameter("idCategorie", idCategorie);

        return (Categorie) query.getSingleResult();
    }

}
