/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import dao.Article;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@LocalBean
public class ArticleFacade {

    @PersistenceContext(unitName = "NetArticlesRestPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return this.em;
    }

    public List<Article> listerByDomaine(int idDomaine) throws Exception {
        try {
            Query requete = em.createNamedQuery("Article.findByIdDomaine");
            requete.setParameter("id_domaine", idDomaine);
            return requete.getResultList();
        } catch (Exception e) {
            throw e;
        }
    }
}
