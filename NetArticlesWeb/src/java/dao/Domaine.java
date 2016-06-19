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
public class Domaine implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idDomaine;
    private String libdomaine;
    private List<Article> articleList;

    /**
     *
     */
    public Domaine() {
    }

    /**
     *
     * @param idDomaine
     */
    public Domaine(Integer idDomaine) {
        this.idDomaine = idDomaine;
    }

    /**
     *
     * @return
     */
    public Integer getIdDomaine() {
        return idDomaine;
    }

    /**
     *
     * @param idDomaine
     */
    public void setIdDomaine(Integer idDomaine) {
        this.idDomaine = idDomaine;
    }

    /**
     *
     * @return
     */
    public String getLibdomaine() {
        return libdomaine;
    }

    /**
     *
     * @param libdomaine
     */
    public void setLibdomaine(String libdomaine) {
        this.libdomaine = libdomaine;
    }

    /**
     *
     * @return
     */
    @XmlTransient
    public List<Article> getArticleList() {
        return articleList;
    }

    /**
     *
     * @param articleList
     */
    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDomaine != null ? idDomaine.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Domaine)) {
            return false;
        }
        Domaine other = (Domaine) object;
        if ((this.idDomaine == null && other.idDomaine != null) || (this.idDomaine != null && !this.idDomaine.equals(other.idDomaine))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Domaine[ idDomaine=" + idDomaine + " ]";
    }

}
