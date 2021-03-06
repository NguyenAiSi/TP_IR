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
public class DroitsPK implements Serializable {

    private int idAuteur;
    private Date dateTrimestre;

    /**
     *
     */
    public DroitsPK() {
    }

    /**
     *
     * @param idAuteur
     * @param dateTrimestre
     */
    public DroitsPK(int idAuteur, Date dateTrimestre) {
        this.idAuteur = idAuteur;
        this.dateTrimestre = dateTrimestre;
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

    /**
     *
     * @return
     */
    public Date getDateTrimestre() {
        return dateTrimestre;
    }

    /**
     *
     * @param dateTrimestre
     */
    public void setDateTrimestre(Date dateTrimestre) {
        this.dateTrimestre = dateTrimestre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAuteur;
        hash += (dateTrimestre != null ? dateTrimestre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DroitsPK)) {
            return false;
        }
        DroitsPK other = (DroitsPK) object;
        if (this.idAuteur != other.idAuteur) {
            return false;
        }
        if ((this.dateTrimestre == null && other.dateTrimestre != null) || (this.dateTrimestre != null && !this.dateTrimestre.equals(other.dateTrimestre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.DroitsPK[ idAuteur=" + idAuteur + ", dateTrimestre=" + dateTrimestre + " ]";
    }

}
