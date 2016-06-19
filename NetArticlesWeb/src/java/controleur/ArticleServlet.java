/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import dao.Article;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import outils.Utilitaire;
import sessions.ArticleFacade;

/**
 *
 * @author Epulapp
 */
@WebServlet(name = "ArticleServlet", urlPatterns = {"/ArticleServlet"})
public class ArticleServlet extends HttpServlet {

    @EJB
    private ArticleFacade articleF;

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

            if (demande.equalsIgnoreCase("dernierArticle.na")) {
                vueReponse = dernierArticle(request);
            } else if (demande.equalsIgnoreCase("voirArticle.na")) {
                vueReponse = article(request);
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

    private String dernierArticle(HttpServletRequest request) throws Exception {
        String vueReponse = "/login.jsp";
        erreur = "";
        try {

            Article article = articleF.getDernierArticle();
            vueReponse = "/voirArticle.jsp";

            request.setAttribute("titre", "Dernier article paru");
            request.setAttribute("articleR", article);

        } catch (Exception e) {
            erreur = e.getMessage();
            e.printStackTrace();
        } finally {
            return (vueReponse);
        }
    }

    private String article(HttpServletRequest request) throws Exception {
        String vueReponse = "/login.jsp";
        erreur = "";
        try {
            Integer idArticle = Integer.parseInt(request.getParameter("id_article"));
            Article article = articleF.getArticle(idArticle);
            vueReponse = "/voirArticle.jsp";

            Integer idDomaine = Integer.parseInt(request.getParameter("id_article"));

            request.setAttribute("titre", "Résumé de l'article n° " + idArticle);
            request.setAttribute("articleR", article);
            request.setAttribute("id_domaineR", idDomaine);
        } catch (Exception e) {
            erreur = e.getMessage();
            e.printStackTrace();
        } finally {
            return (vueReponse);
        }
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
