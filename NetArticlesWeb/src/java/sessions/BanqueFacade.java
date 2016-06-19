/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import daoRest.BanqueRest;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author Epulapp
 */
@Stateless
public class BanqueFacade {

    /**
     *
     * @param idCompte
     * @param solde
     * @return
     */
    public String Autorisation(int idCompte, int solde) {
        String status = "false";
        try {
            BanqueRest banqueR = new BanqueRest();
            status = banqueR.Autorisation(idCompte, solde);
        } catch (Exception ex) {
            Logger.getLogger(BanqueFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return status;
    }

    /**
     *
     * @param idCompte
     * @param somme
     */
    public void payer(int idCompte, int somme) {
        try {
            BanqueRest banqueR = new BanqueRest();
            banqueR.payer(idCompte, somme);
        } catch (Exception ex) {
            Logger.getLogger(BanqueFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
