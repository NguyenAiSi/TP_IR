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
public class AchetePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_client")
    private int idClient;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_article")
    private int idArticle;

    /**
     *
     */
    public AchetePK() {
    }

    /**
     *
     * @param idClient
     * @param idArticle
     */
    public AchetePK(int idClient, int idArticle) {
        this.idClient = idClient;
        this.idArticle = idArticle;
    }

    /**
     *
     * @return
     */
    public int getIdClient() {
        return idClient;
    }

    /**
     *
     * @param idClient
     */
    public void setIdClient(int idClient) {
        this.idClient = idClient;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idClient;
        hash += (int) idArticle;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AchetePK)) {
            return false;
        }
        AchetePK other = (AchetePK) object;
        if (this.idClient != other.idClient) {
            return false;
        }
        if (this.idArticle != other.idArticle) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.AchetePK[ idClient=" + idClient + ", idArticle=" + idArticle + " ]";
    }
    
}
