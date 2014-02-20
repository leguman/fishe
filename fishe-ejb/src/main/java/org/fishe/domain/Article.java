package org.fishe.domain;

import java.util.Date;

/**
 * Created by mendoncafilh on 19/02/14.
 */
public class Article {
    private String title;
    private String author;
    private WebSource webSource;
    private String content;
    private String summary;
    private String permanentLink;
    private Date publication;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public WebSource getWebSource() {
        return webSource;
    }

    public void setWebSource(WebSource webSource) {
        this.webSource = webSource;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getUrl() {
        return "knowledge/article";
    }

    /**
     * @return Returns the content if it exists or the summary if the content
     * doesn't exist.
     */
    public String getText() {
        if(this.content == null || this.content.isEmpty()) {
            return this.summary;
        }
        else {
            return this.content;
        }
    }

    public String getPermanentLink() {
        return permanentLink;
    }

    public void setPermanentLink(String permanentLink) {
        this.permanentLink = permanentLink;
    }

    public Date getPublication() {
        return publication;
    }

    public void setPublication(Date publication) {
        this.publication = publication;
    }

    @Override
    public String toString() {
        return this.title;
    }
}