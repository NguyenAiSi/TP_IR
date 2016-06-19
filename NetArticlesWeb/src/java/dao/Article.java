/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Epulapp
 */
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idArticle;
    private String titre;
    private String resume;
    private BigDecimal prix;
    private Date dateArticle;
    private String fichier;
    private List<Redige> redigeList;
    private List<Achete> acheteList;
    private Domaine domaine;

    /**
     *
     */
    public Article() {
    }

    /**
     *
     * @param idArticle
     */
    public Article(Integer idArticle) {
        this.idArticle = idArticle;
    }

    /**
     *
     * @param idArticle
     * @param fichier
     */
    public Article(Integer idArticle, String fichier) {
        this.idArticle = idArticle;
        this.fichier = fichier;
    }

    /**
     *
     * @return
     */
    public Integer getIdArticle() {
        return idArticle;
    }

    /**
     *
     * @param idArticle
     */
    public void setIdArticle(Integer idArticle) {
        this.idArticle = idArticle;
    }

    /**
     *
     * @return
     */
    public String getTitre() {
        return titre;
    }

    /**
     *
     * @param titre
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     *
     * @return
     */
    public String getResume() {
        return resume;
    }

    /**
     *
     * @param resume
     */
    public void setResume(String resume) {
        this.resume = resume;
    }

    /**
     *
     * @return
     */
    public BigDecimal getPrix() {
        return prix;
    }

    /**
     *
     * @param prix
     */
    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    /**
     *
     * @return
     */
    public Date getDateArticle() {
        return dateArticle;
    }

    /**
     *
     * @param dateArticle
     */
    public void setDateArticle(Date dateArticle) {
        this.dateArticle = dateArticle;
    }

    /**
     *
     * @return
     */
    public String getFichier() {
        return fichier;
    }

    /**
     *
     * @param fichier
     */
    public void setFichier(String fichier) {
        this.fichier = fichier;
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
    public Domaine getDomaine() {
        return domaine;
    }

    /**
     *
     * @param domaine
     */
    public void setDomaine(Domaine domaine) {
        this.domaine = domaine;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArticle != null ? idArticle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.idArticle == null && other.idArticle != null) || (this.idArticle != null && !this.idArticle.equals(other.idArticle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Article[ idArticle=" + idArticle + " ]";
    }

}
