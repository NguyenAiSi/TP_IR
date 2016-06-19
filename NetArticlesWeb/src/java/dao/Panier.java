/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Epulapp
 */
public class Panier {

    private double somme;
    private List<Article> articles;

    /**
     *
     */
    public Panier() {
        articles = new ArrayList<>();
        somme = 0;
    }

    /**
     *
     * @return
     */
    public double getSomme() {
        return somme;
    }

    /**
     *
     * @param somme
     */
    public void setSomme(double somme) {
        this.somme = somme;
    }

    /**
     *
     * @param a
     */
    public void ajouterArticle(Article a) {
        this.articles.add(a);
    }

    /**
     *
     * @param prix
     */
    public void enlever(double prix) {
        this.somme -= prix;
    }

    /**
     *
     * @return
     */
    public List<Article> getArticles() {
        return articles;
    }

    /**
     *
     * @param articles
     */
    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
