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
public class Auteur implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idAuteur;
    private String identiteAuteur;
    private String adresseAuteur;
    private String loginAuteur;
    private String pwdAuteur;
    private List<Redige> redigeList;
    private List<Droits> droitsList;

    /**
     *
     */
    public Auteur() {
    }

    /**
     *
     * @param idAuteur
     */
    public Auteur(Integer idAuteur) {
        this.idAuteur = idAuteur;
    }

    /**
     *
     * @param idAuteur
     * @param loginAuteur
     * @param pwdAuteur
     */
    public Auteur(Integer idAuteur, String loginAuteur, String pwdAuteur) {
        this.idAuteur = idAuteur;
        this.loginAuteur = loginAuteur;
        this.pwdAuteur = pwdAuteur;
    }

    /**
     *
     * @return
     */
    public Integer getIdAuteur() {
        return idAuteur;
    }

    /**
     *
     * @param idAuteur
     */
    public void setIdAuteur(Integer idAuteur) {
        this.idAuteur = idAuteur;
    }

    /**
     *
     * @return
     */
    public String getIdentiteAuteur() {
        return identiteAuteur;
    }

    /**
     *
     * @param identiteAuteur
     */
    public void setIdentiteAuteur(String identiteAuteur) {
        this.identiteAuteur = identiteAuteur;
    }

    /**
     *
     * @return
     */
    public String getAdresseAuteur() {
        return adresseAuteur;
    }

    /**
     *
     * @param adresseAuteur
     */
    public void setAdresseAuteur(String adresseAuteur) {
        this.adresseAuteur = adresseAuteur;
    }

    /**
     *
     * @return
     */
    public String getLoginAuteur() {
        return loginAuteur;
    }

    /**
     *
     * @param loginAuteur
     */
    public void setLoginAuteur(String loginAuteur) {
        this.loginAuteur = loginAuteur;
    }

    /**
     *
     * @return
     */
    public String getPwdAuteur() {
        return pwdAuteur;
    }

    /**
     *
     * @param pwdAuteur
     */
    public void setPwdAuteur(String pwdAuteur) {
        this.pwdAuteur = pwdAuteur;
    }

    /**
     *
     * @return
     */
    @XmlTransient
    public List<Redige> getRedigeList() {
        return redigeList;
    }

    /**
     *
     * @param redigeList
     */
    public void setRedigeList(List<Redige> redigeList) {
        this.redigeList = redigeList;
    }

    /**
     *
     * @return
     */
    @XmlTransient
    public List<Droits> getDroitsList() {
        return droitsList;
    }

    /**
     *
     * @param droitsList
     */
    public void setDroitsList(List<Droits> droitsList) {
        this.droitsList = droitsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAuteur != null ? idAuteur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auteur)) {
            return false;
        }
        Auteur other = (Auteur) object;
        if ((this.idAuteur == null && other.idAuteur != null) || (this.idAuteur != null && !this.idAuteur.equals(other.idAuteur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Auteur[ idAuteur=" + idAuteur + " ]";
    }

}
