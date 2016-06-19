/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Epulapp
 */
@Embeddable
public class RedigePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_article")
    private int idArticle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_auteur")
    private int idAuteur;

    /**
     *
     */
    public RedigePK() {
    }

    /**
     *
     * @param idArticle
     * @param idAuteur
     */
    public RedigePK(int idArticle, int idAuteur) {
        this.idArticle = idArticle;
        this.idAuteur = idAuteur;
    }

    /**
     *
     * @return
     */
    public int getIdArticle() {
        return idArticle;
    }

    /**
     *
     * @param idArticle
     */
    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    /**
     *
     * @return
     */
    public int getIdAuteur() {
        return idAuteur;
    }

    /**
     *
     * @param idAuteur
     */
    public void setIdAuteur(int idAuteur) {
        this.idAuteur = idAuteur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idArticle;
        hash += (int) idAuteur;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RedigePK)) {
            return false;
        }
        RedigePK other = (RedigePK) object;
        if (this.idArticle != other.idArticle) {
            return false;
        }
        if (this.idAuteur != other.idAuteur) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.RedigePK[ idArticle=" + idArticle + ", idAuteur=" + idAuteur + " ]";
    }
    
}
