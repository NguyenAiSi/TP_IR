/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import dao.Achete;
import dao.Article;
import dao.Domaine;
import dao.Panier;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import outils.Utilitaire;
import sessions.AcheteFacade;
import sessions.ArticleFacade;
import sessions.BanqueFacade;
import sessions.DomaineFacade;

/**
 *
 * @author Epulapp
 */
@WebServlet(name = "DomaineServlet", urlPatterns = {"/DomaineServlet"})
public class DomaineServlet extends HttpServlet {

    @EJB
    private AcheteFacade acheteF;

    @EJB
    private ArticleFacade articleF;

    @EJB
    private BanqueFacade banqueF;

    @EJB
    private DomaineFacade domaineF;

    private String erreur;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String demande;
        String vueReponse = "/menu.jsp";
        erreur = "";
        try {
            demande = getDemande(request);

            if (demande.equalsIgnoreCase("listeDomaines.cde")) {
                vueReponse = getListDomaines(request);
            } else if (demande.equalsIgnoreCase("listeArticlesDomaine.cde")) {
                vueReponse = getListArticlesByDomaine(request);
            } else if (demande.equalsIgnoreCase("ajoutPanier.cde")) {
                vueReponse = ajouterPanier(request);
            } else if (demande.equalsIgnoreCase("validerPanier.cde")) {
                vueReponse = valider(request);
            } else if (demande.equalsIgnoreCase("listeAchats.cde")) {
                vueReponse = getListAchetesByClient(request);
            } else if (demande.equalsIgnoreCase("voirPanier.cde")) {
                vueReponse = panier(request);
            } else if (demande.equalsIgnoreCase("supprimerPanier.cde")) {
                vueReponse = supprimerPanier(request);
            }

        } catch (Exception e) {
            erreur = Utilitaire.getExceptionCause(e);
        } finally {
            request.setAttribute("erreurR", erreur);
            request.setAttribute("pageR", vueReponse);
            RequestDispatcher dsp = request.getRequestDispatcher("/index.jsp");
            if (vueReponse.contains(".user")) {
                dsp = request.getRequestDispatcher(vueReponse);
            }
            dsp.forward(request, response);
        }
    }
    
    private String getDemande(HttpServletRequest request) {
        String demande = "";
        demande = request.getRequestURI();
        demande = demande.substring(demande.lastIndexOf("/") + 1);
        return demande;
    }
    
    private String getListDomaines(HttpServletRequest request){
        String vueReponse = "/login.jsp";
        erreur = "";
        try {            
            List<Domaine> domaines = domaineF.getListDomaines();
            vueReponse = "/rechercher.jsp";

            request.setAttribute("lDomainesR", domaines);  
            request.setAttribute("titre", "Liste des articles d'un domaine");
               
        } catch (Exception e) {
            erreur = e.getMessage();
            e.printStackTrace();
        }
        finally{
            return (vueReponse);            
        }
    }
    
    private String getListArticlesByDomaine(HttpServletRequest request){
        String vueReponse = "/login.jsp";
        erreur = "";
        try {           
            String idDomaine = request.getParameter("cbDomaines");
            List<Domaine> domaines = domaineF.getListDomaines();           
            List<Article> articles = articleF.getListArticlesByDomaine(Integer.parseInt(idDomaine));
            vueReponse = "/rechercher.jsp";

            request.setAttribute("titre", "Liste des articles d'un domaine");
            request.setAttribute("lArticlesR", articles);  
            request.setAttribute("lDomainesR", domaines);  
            request.setAttribute("id_domaineR", idDomaine);  
               
        } catch (Exception e) {
            erreur = e.getMessage();
            e.printStackTrace();
        }
        finally{
            return (vueReponse);            
        }
    }
    
    /**
     *
     * @param request
     * @return
     */
    public String ajouterPanier(HttpServletRequest request){
        String vueReponse="/panier.jsp";
        
        int idArticle = Integer.parseInt(request.getParameter("id_article"));
        HttpSession session = request.getSession();
        Panier panier = (Panier)session.getAttribute("panier");
        if (panier == null){
            panier = new Panier();
            session.setAttribute("panier",panier);
        }
   
        Article articleAdd = articleF.getArticle(idArticle);
        panier.ajouterArticle(articleAdd);
        panier.setSomme(articleAdd.getPrix().doubleValue() + panier.getSomme());

        session.setAttribute("panier", panier);
        request.setAttribute("titre", "Votre panier");
        return vueReponse;
    }
    
    /**
     *
     * @param request
     * @return
     */
    public String getListAchetesByClient(HttpServletRequest request){
        String vueReponse = "/login.jsp";
        HttpSession session = request.getSession();
        Integer idClient = (Integer)session.getAttribute("userId");
        
        List<Achete> articles = acheteF.getListAchetesByClient(idClient);
        request.setAttribute("lAchetesR", articles);
        
        vueReponse="/listeAchats.jsp";
        
        return vueReponse;
    }
    
    /**
     *
     * @param request
     * @return
     */
    public String valider(HttpServletRequest request){
        String vueReponse = "/login.jsp";
        HttpSession session = request.getSession();
        Integer idCompte = (Integer)session.getAttribute("userId");
        if(idCompte != null){
            Panier panier = (Panier)session.getAttribute("panier");
            int montantPanier = (int)panier.getSomme();
            String isPossible = banqueF.Autorisation(idCompte, montantPanier);
            
            if("true".equals(isPossible)){
                banqueF.payer(idCompte, montantPanier);
                for(Article a:panier.getArticles()){
                    acheteF.ajouterAchete(idCompte, a.getIdArticle());
                }
            } else {
                erreur = "Le compte n'est pas suffisamment approvisionné";
            }
        }else{
            erreur = "Il faut s'identifier pour valider un panier !";            
        }
        
        return vueReponse;
    }
    
    private String panier(HttpServletRequest request) {
        String vueReponse = "/panier.jsp";
        
        HttpSession session = request.getSession();
        Panier panier = (Panier)session.getAttribute("panier");
        request.setAttribute("lArticlesPanierR", panier.getArticles());
        request.setAttribute("montantTotalR", panier.getSomme()); 
        
        return vueReponse;
    }
    
    /**
     *
     * @param request
     * @return
     */
    public String supprimerPanier(HttpServletRequest request){
        String vueReponse = "/panier.jsp";
        
        HttpSession session = request.getSession();
        Integer idArticle = Integer.parseInt(request.getParameter("id_article"));
        Panier panier = (Panier)session.getAttribute("panier");
        List<Article> articlesPanier = panier.getArticles();
        for(Article a:articlesPanier){
            if(a.getIdArticle() == idArticle){
                panier.enlever(a.getPrix().doubleValue());
                articlesPanier.remove(a);
            }
        }
        
        request.setAttribute("lArticlesPanierR", articlesPanier);
        request.setAttribute("montantTotalR", panier.getSomme()); 
        
        return vueReponse;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
