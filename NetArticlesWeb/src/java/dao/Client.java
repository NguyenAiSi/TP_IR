/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Epulapp
 */
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idClient;
    private String identiteClient;
    private String adresseClient;
    private Integer credits;
    private String loginClient;
    private String pwdClient;
    private List<Achete> acheteList;
    private Categorie categorie;

    /**
     *
     */
    public Client() {
    }

    /**
     *
     * @param idClient
     */
    public Client(Integer idClient) {
        this.idClient = idClient;
    }

    /**
     *
     * @param idClient
     * @param loginClient
     * @param pwdClient
     */
    public Client(Integer idClient, String loginClient, String pwdClient) {
        this.idClient = idClient;
        this.loginClient = loginClient;
        this.pwdClient = pwdClient;
    }

    /**
     *
     * @return
     */
    public Integer getIdClient() {
        return idClient;
    }

    /**
     *
     * @param idClient
     */
    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    /**
     *
     * @return
     */
    public String getIdentiteClient() {
        return identiteClient;
    }

    /**
     *
     * @param identiteClient
     */
    public void setIdentiteClient(String identiteClient) {
        this.identiteClient = identiteClient;
    }

    /**
     *
     * @return
     */
    public String getAdresseClient() {
        return adresseClient;
    }

    /**
     *
     * @param adresseClient
     */
    public void setAdresseClient(String adresseClient) {
        this.adresseClient = adresseClient;
    }

    /**
     *
     * @return
     */
    public Integer getCredits() {
        return credits;
    }

    /**
     *
     * @param credits
     */
    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    /**
     *
     * @return
     */
    public String getLoginClient() {
        return loginClient;
    }

    /**
     *
     * @param loginClient
     */
    public void setLoginClient(String loginClient) {
        this.loginClient = loginClient;
    }

    /**
     *
     * @return
     */
    public String getPwdClient() {
        return pwdClient;
    }

    /**
     *
     * @param pwdClient
     */
    public void setPwdClient(String pwdClient) {
        this.pwdClient = pwdClient;
    }

    /**
     *
     * @return
     */
    @XmlTransient
    public List<Achete> getAcheteList() {
        return acheteList;
    }

    /**
     *
     * @param acheteList
     */
    public void setAcheteList(List<Achete> acheteList) {
        this.acheteList = acheteList;
    }

    /**
     *
     * @return
     */
    public Categorie getCategorie() {
        return categorie;
    }

    /**
     *
     * @param categorie
     */
    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClient != null ? idClient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.idClient == null && other.idClient != null) || (this.idClient != null && !this.idClient.equals(other.idClient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Client[ idClient=" + idClient + " ]";
    }

    /**
     *
     * @param login
     * @param pwd
     * @return
     */
    public boolean connecter(String login, String pwd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
