package org.fishe.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mendoncafilh on 19/02/14.
 */
public class WebSource {
    private String title;
    private String feed;

    private List<Article> articles;

    public WebSource() {}

    public WebSource(String title, String feed) {
        this.title = title;
        this.feed = feed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFeed() {
        return feed;
    }

    public void setFeed(String feed) {
        this.feed = feed;
    }

    public void addArticle(Article article) {
        if(this.articles == null) {
            this.articles = new ArrayList<>();
        }
        this.articles.add(article);
    }

    public void removeArticle(Article article) {
        if(article != null && this.articles != null) {
            this.articles.remove(article);
        }
    }

    @Override
    public String toString() {
        return this.title;
    }
}