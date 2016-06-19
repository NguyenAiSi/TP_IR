/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import dao.Categorie;
import dao.Client;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sessions.CategorieFacade;
import sessions.ClientFacade;

/**
 *
 * @author Epulapp
 */
public class ClientServlet extends HttpServlet {

    @EJB
    private ClientFacade clientF;

    @EJB
    private CategorieFacade categorieF;

    private String erreur;

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String demande;
        String vueReponse = "/login.jsp";
        erreur = "";
        try {
            demande = getDemande(request);
            if (demande.equalsIgnoreCase("login.cpt")) {
                vueReponse = login(request);
            } else if (demande.equalsIgnoreCase("connecter.cpt")) {
                vueReponse = connecter(request);
            } else if (demande.equalsIgnoreCase("deconnecter.cpt")) {
                vueReponse = deconnecter(request);
            } else if (demande.equalsIgnoreCase("voirCompte.cpt")) {
                vueReponse = getListCategories(request);
            } else if (demande.equalsIgnoreCase("validerCompte.cpt")) {
                vueReponse = modifierCompte(request);
            } else if (demande.equalsIgnoreCase("creerCompte.cpt")) {
                vueReponse = ajouterCompte(request);
            }

        } catch (Exception e) {
            erreur = e.getMessage();
        } finally {
            request.setAttribute("erreurR", erreur);
            request.setAttribute("pageR", vueReponse);
            RequestDispatcher dsp = request.getRequestDispatcher("/index.jsp");
            if (vueReponse.contains(".oe")) {
                dsp = request.getRequestDispatcher(vueReponse);
            }
            dsp.forward(request, response);
        }
    }

    private String connecter(HttpServletRequest request) throws Exception {
        String login, pwd, vueReponse;
        try {
            vueReponse = "/login.jsp";
            login = request.getParameter("txtLogin");
            pwd = request.getParameter("txtPwd");
            if (clientF.connecter(login, pwd)) {
                Client client = clientF.getClient();
                vueReponse = "/menu.jsp";
                HttpSession session = request.getSession(true);
                session.setAttribute("userId", client.getIdClient());
            } else {
                erreur = "Login ou mot de passe inconnus !";
            }
            return (vueReponse);
        } catch (Exception e) {
            throw e;
        }
    }

    private String deconnecter(HttpServletRequest request) throws Exception {
        try {
            HttpSession session = request.getSession(true);
            session.setAttribute("userId", null);
            return ("/login.jsp");
        } catch (Exception e) {
            throw e;
        }
    }

    private String login(HttpServletRequest request) throws Exception {
        try {
            return ("/login.jsp");
        } catch (Exception e) {
            throw e;
        }
    }

    private String getDemande(HttpServletRequest request) {
        String demande = "";
        demande = request.getRequestURI();
        demande = demande.substring(demande.lastIndexOf("/") + 1);
        return demande;
    }

    private String getListCategories(HttpServletRequest request) throws Exception {
        String vueReponse = "/login.jsp";
        try {
            Integer idCLient = (Integer) request.getSession().getAttribute("userId");
            Client client = clientF.getClient(idCLient);
            List<Categorie> categories = categorieF.getListCategories();

            request.setAttribute("titre", "Consulter/modifier son compte");
            request.setAttribute("clientR", client);
            request.setAttribute("listeCategoriesR", categories);
            vueReponse = "/client.jsp";

        } catch (Exception e) {
            throw e;
        }
        return vueReponse;
    }

    private String modifierCompte(HttpServletRequest request) throws Exception {
        String vueReponse = "/login.jsp";
        try {
            Integer idCLient = Integer.parseInt(request.getParameter("id_client"));
            Client client = clientF.getClient(idCLient);

            String identite = request.getParameter("txtIdentite");
            String adresse = request.getParameter("txtAdresse");
            String login = request.getParameter("txtLogin");
            String mdp = request.getParameter("txtPwd");
            int idCateg = Integer.parseInt(request.getParameter("cbCategories"));

            if (!"".equals(login) && !"".equals(mdp) && idCateg > 0) {
                client.setLoginClient(login);
                client.setPwdClient(mdp);
                client.getCategorie().setIdCategorie(idCateg);
                client.setIdentiteClient(identite);
                client.setAdresseClient(adresse);
            }

            client = clientF.modifierClient(client);

            List<Categorie> categories = categorieF.getListCategories();

            request.setAttribute("clientR", client);
            request.setAttribute("listeCategoriesR", categories);

            vueReponse = "dernierArticle.na";

        } catch (Exception e) {
            throw e;
        }
        return vueReponse;
    }

    private String ajouterCompte(HttpServletRequest request) throws Exception {
        String vueReponse;
        try {
            vueReponse = "/login.jsp";
            return (vueReponse);
        } catch (Exception e) {
            throw e;
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
