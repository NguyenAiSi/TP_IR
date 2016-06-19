/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import dao.Categorie;
import daoRest.CategorieRest;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author Epulapp
 */
@Stateless
public class CategorieFacade {

    /**
     *
     * @param idCategorie
     * @return
     */
    public Categorie getCategorie(int idCategorie) {
        CategorieRest categorieR = new CategorieRest();
        Categorie categorie = null;
        try {
            categorie = categorieR.getCategorie(idCategorie);
        } catch (Exception ex) {
            Logger.getLogger(CategorieFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categorie;
    }

    /**
     *
     * @return
     */
    public List<Categorie> getListCategories() {
        CategorieRest categorieR = new CategorieRest();
        List<Categorie> categories = null;
        try {
            categories = categorieR.getListCategories();
        } catch (Exception ex) {
            Logger.getLogger(CategorieFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categories;
    }

}
