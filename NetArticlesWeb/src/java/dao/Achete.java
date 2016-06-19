/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Epulapp
 */
public class Achete implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    protected AchetePK achetePK;
    private Date dateAchat;
    private Article article;
    private Client client;

    /**
     *
     */
    public Achete() {
    }

    /**
     *
     * @param achetePK
     */
    public Achete(AchetePK achetePK) {
        this.achetePK = achetePK;
    }

    /**
     *
     * @param idClient
     * @param idArticle
     */
    public Achete(int idClient, int idArticle) {
        this.achetePK = new AchetePK(idClient, idArticle);
    }

    /**
     *
     * @return
     */
    public AchetePK getAchetePK() {
        return achetePK;
    }

    /**
     *
     * @param achetePK
     */
    public void setAchetePK(AchetePK achetePK) {
        this.achetePK = achetePK;
    }

    /**
     *
     * @return
     */
    public Date getDateAchat() {
        return dateAchat;
    }

    /**
     *
     * @param dateAchat
     */
    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    /**
     *
     * @return
     */
    public Article getArticle() {
        return article;
    }

    /**
     *
     * @param article
     */
    public void setArticle(Article article) {
        this.article = article;
    }

    /**
     *
     * @return
     */
    public Client getClient() {
        return client;
    }

    /**
     *
     * @param client
     */
    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (achetePK != null ? achetePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Achete)) {
            return false;
        }
        Achete other = (Achete) object;
        if ((this.achetePK == null && other.achetePK != null) || (this.achetePK != null && !this.achetePK.equals(other.achetePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Achete[ achetePK=" + achetePK + " ]";
    }

}