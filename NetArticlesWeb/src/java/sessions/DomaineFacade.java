/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import dao.Domaine;
import daoRest.DomaineRest;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author Epulapp
 */
@Stateless
public class DomaineFacade {

    /**
     *
     * @return
     * @throws Exception
     */
    public List<Domaine> getListDomaines() throws Exception {
        List<Domaine> domaines = null;
        try {
            DomaineRest domaineR = new DomaineRest();
            domaines = domaineR.getListDomaines();
            
        } catch (Exception ex) {
            Logger.getLogger(ArticleFacade.class.getName()).log(Level.SEVERE, null, ex);
        }

        return domaines;

    }
}
