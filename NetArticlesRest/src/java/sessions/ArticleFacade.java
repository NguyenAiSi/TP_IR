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

/**
 *
 * @author Epulapp
 */
@Stateless
@LocalBean
public class ArticleFacade {

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
     * @param idArticle
     * @return
     */
    public Article getArticle(int idArticle) {
        Query query = em.createNamedQuery("Article.findByIdArticle");
        query.setParameter("idArticle", idArticle);
        
        return (Article) query.getSingleResult();
    }

    /**
     *
     * @param idDomaine
     * @return
     */
    public List<Article> getListArticlesByDomaine(int idDomaine) {
        Query requete = em.createQuery("SELECT a FROM Article a WHERE a.domaine.idDomaine = :idDomaine");
        requete.setParameter("idDomaine", idDomaine);

        return (List<Article>) requete.getResultList();
    }

    /**
     *
     * @return
     */
    public Article getDernierArticle() {
        try {
            Query requete = em.createQuery("SELECT c.valCle FROM Cles c WHERE c.idCle = :idCle");
            requete.setParameter("idCle", "ARTICLE");
            int idArticle = (int) requete.getSingleResult();
            Query requete2 = em.createNamedQuery("Article.findByIdArticle");
            requete2.setParameter("idArticle", idArticle);

            return (Article) requete2.getSingleResult();
        } catch (Exception ex) {
            throw ex;
        }
    }
}
