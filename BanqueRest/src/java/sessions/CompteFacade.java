/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import dao.Compte;
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
public class CompteFacade {

    @PersistenceContext(unitName = "BanqueRestPU")
    private EntityManager em;

    /**
     *
     * @return
     */
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     *
     * @param idCompte
     * @return
     * @throws Exception
     */
    public Compte getCompteById(int idCompte) throws Exception {
        try {
            Query query = em.createNamedQuery("Compte.findByIdCompte");
            query.setParameter("idCompte", idCompte);

            return (Compte) query.getSingleResult();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     *
     * @param idCompte
     * @param somme
     * @return
     * @throws Exception
     */
    public boolean Autorisation(int idCompte, double somme) throws Exception {

        try {
            Compte compte = getCompteById(idCompte);
            boolean status = false;
            if (compte.getSolde() - somme >= 0) {
                status = true;
            }

            return status;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     *
     * @param idCompte
     * @param somme
     * @throws Exception
     */
    public void payer(int idCompte, int somme) throws Exception {
        try {
            Compte compte = getCompteById(idCompte);
            compte.setSolde(compte.getSolde() - (int) somme);
            em.merge(compte);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     *
     * @param idCompte
     * @param solde
     * @throws Exception
     */
    public void modifier(int idCompte, int solde) throws Exception {
        try {
            Compte compte = getCompteById(idCompte);
            compte.setSolde(solde);
            em.merge(compte);
        } catch (Exception e) {
            throw e;
        }
    }
}
