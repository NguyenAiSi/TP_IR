/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import dao.Achete;
import daoRest.AcheteRest;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author Epulapp
 */
@Stateless
public class AcheteFacade {

    /**
     *
     * @param idClient
     * @param idArticle
     */
    public void ajouterAchete(int idClient, int idArticle) {
        try {
            AcheteRest acheteR = new AcheteRest();
            acheteR.ajouterAchete(idClient, idArticle);
        } catch (Exception ex) {
            Logger.getLogger(AcheteFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param idClient
     * @return
     */
    public List<Achete> getListAchetesByClient(int idClient) {
        List<Achete> articles = null;
        try {
            AcheteRest acheteR = new AcheteRest();
            articles = acheteR.getListAchetesByClient(idClient);
        } catch (Exception ex) {
            Logger.getLogger(AcheteFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return articles;
    }
}
