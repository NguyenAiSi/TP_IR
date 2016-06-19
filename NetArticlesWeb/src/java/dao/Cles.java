/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;

/**
 *
 * @author Epulapp
 */
public class Cles implements Serializable {

    private static final long serialVersionUID = 1L;
    private String idCle;
    private Integer valCle;
    private String libCle;

    /**
     *
     */
    public Cles() {
    }

    /**
     *
     * @param idCle
     */
    public Cles(String idCle) {
        this.idCle = idCle;
    }

    /**
     *
     * @return
     */
    public String getIdCle() {
        return idCle;
    }

    /**
     *
     * @param idCle
     */
    public void setIdCle(String idCle) {
        this.idCle = idCle;
    }

    /**
     *
     * @return
     */
    public Integer getValCle() {
        return valCle;
    }

    /**
     *
     * @param valCle
     */
    public void setValCle(Integer valCle) {
        this.valCle = valCle;
    }

    /**
     *
     * @return
     */
    public String getLibCle() {
        return libCle;
    }

    /**
     *
     * @param libCle
     */
    public void setLibCle(String libCle) {
        this.libCle = libCle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCle != null ? idCle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cles)) {
            return false;
        }
        Cles other = (Cles) object;
        if ((this.idCle == null && other.idCle != null) || (this.idCle != null && !this.idCle.equals(other.idCle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Cles[ idCle=" + idCle + " ]";
    }

}
