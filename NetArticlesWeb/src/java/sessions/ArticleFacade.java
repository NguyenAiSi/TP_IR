/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import dao.Article;
import daoRest.ArticleRest;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class ArticleFacade {

    /**
     *
     * @param idArticle
     * @return
     */
    public Article getArticle(int idArticle) {
        Article a = null;
        try {
            ArticleRest articleR = new ArticleRest();
            a = articleR.getArticle(idArticle);
        } catch (Exception ex) {
            Logger.getLogger(ArticleFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

    /**
     *
     * @return
     */
    public Article getDernierArticle() {
        Article a = null;
        try {
            ArticleRest articleR = new ArticleRest();
            a = articleR.getDernierArticle();
        } catch (Exception ex) {
            Logger.getLogger(ArticleFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

    /**
     *
     * @param idDomaine
     * @return
     */
    public List<Article> getListArticlesByDomaine(int idDomaine) {
        List<Article> articles = null;
        try {
            ArticleRest articleR = new ArticleRest();
            articles = articleR.getListArticlesByDomaine(idDomaine);
        } catch (Exception ex) {
            Logger.getLogger(ArticleFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return articles;
    }
}
