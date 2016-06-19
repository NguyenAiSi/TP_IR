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
public class Categorie implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idCategorie;
    private String libcategorie;
    private List<Client> clientList;

    /**
     *
     */
    public Categorie() {
    }

    /**
     *
     * @param idCategorie
     */
    public Categorie(Integer idCategorie) {
        this.idCategorie = idCategorie;
    }

    /**
     *
     * @return
     */
    public Integer getIdCategorie() {
        return idCategorie;
    }

    /**
     *
     * @param idCategorie
     */
    public void setIdCategorie(Integer idCategorie) {
        this.idCategorie = idCategorie;
    }

    /**
     *
     * @return
     */
    public String getLibcategorie() {
        return libcategorie;
    }

    /**
     *
     * @param libcategorie
     */
    public void setLibcategorie(String libcategorie) {
        this.libcategorie = libcategorie;
    }

    /**
     *
     * @return
     */
    @XmlTransient
    public List<Client> getClientList() {
        return clientList;
    }

    /**
     *
     * @param clientList
     */
    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategorie != null ? idCategorie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categorie)) {
            return false;
        }
        Categorie other = (Categorie) object;
        if ((this.idCategorie == null && other.idCategorie != null) || (this.idCategorie != null && !this.idCategorie.equals(other.idCategorie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Categorie[ idCategorie=" + idCategorie + " ]";
    }

}
