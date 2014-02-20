package org.fishe.business;

import com.sun.syndication.feed.synd.SyndContent;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import org.fishe.domain.Article;
import org.fishe.domain.WebSource;
import org.fishe.utils.URIUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Named;


/**
 * @author Hildeberto Mendonca - http://www.hildeberto.com
 */
@Named
public class WebSourceBean {

    private static final Logger LOGGER = Logger.getLogger(WebSourceBean.class.getName());

    public List<Article> loadUnpublishedArticles(WebSource webSource) {
        return loadArticles(webSource);
    }

    public List<Article> loadArticles(WebSource webSource) {
        List<Article> feedArticles = new ArrayList<>();

        try {
            URL url  = new URL(webSource.getFeed());
            XmlReader reader = new XmlReader(url);
            SyndFeed feed = new SyndFeedInput().build(reader);
            Article article;
            for (Iterator i = feed.getEntries().iterator(); i.hasNext();) {
                SyndEntry entry = (SyndEntry) i.next();

                article = new Article();
                article.setTitle(entry.getTitle());
                article.setPermanentLink(entry.getLink());
                if(entry.getAuthor() != null) {
                    article.setAuthor(entry.getAuthor());
                }
                else {
                    article.setAuthor("Anonymous");
                }
                if(entry.getUpdatedDate() != null) {
                    article.setPublication(entry.getUpdatedDate());
                }
                else {
                    article.setPublication(entry.getPublishedDate());
                }
                article.setWebSource(webSource);
                if(entry.getDescription() != null) {
                    article.setSummary(entry.getDescription().getValue());
                }
                SyndContent syndContent;
                StringBuilder content = new StringBuilder();
                for(int j = 0;j < entry.getContents().size();j++) {
                    syndContent = (SyndContent) entry.getContents().get(j);
                    content.append(syndContent.getValue());
                }
                article.setContent(content.toString());

                feedArticles.add(article);
            }
        } catch (IllegalArgumentException | FeedException | IOException iae) {
            LOGGER.log(Level.SEVERE, iae.getMessage(), iae);
        }

        return feedArticles;
    }

    /**
     * @param websiteUrl a website url where we can find a feed url.
     * @return a new webSource filled with feed url and title only. Null if a feed url is not found in the content of
     * the informed website url.
     * */
    public WebSource loadWebSource(String websiteUrl) {
        WebSource webSource = null;
        String feedUrl = findWebsiteFeedURL(websiteUrl);
        LOGGER.log(Level.INFO, "feedUrl: {0}", feedUrl);
        if(feedUrl != null) {
            try {
                URL url  = new URL(feedUrl);
                XmlReader reader = new XmlReader(url);
                SyndFeed feed = new SyndFeedInput().build(reader);
                webSource = new WebSource(feed.getTitle(), feedUrl);
            } catch (IllegalArgumentException | FeedException | IOException iae) {
                LOGGER.log(Level.SEVERE, iae.getMessage(), iae);
            }
        }
        return webSource;
    }

    /**
     * @param urlWebsite url used to find the web content where there is probably a feed to be consumed.
     * @return if a feed url is found in the web content, it is returned. Otherwise, the method returns null.
     * */
    public String findWebsiteFeedURL(String urlWebsite) {
        String feedUrl = null;
        String websiteContent = retrieveWebsiteContent(urlWebsite);
        LOGGER.log(Level.INFO, "urlWebsite: {0}", urlWebsite);
        if(websiteContent == null) {
            return null;
        }

        Pattern hrefPattern = Pattern.compile("href=\\W([^(\"|\')])+\\W");
        Matcher matcher = hrefPattern.matcher(websiteContent);

        while (matcher.find()) {
            feedUrl = matcher.group();
            if(feedUrl.contains("\"")) {
                feedUrl = feedUrl.substring(feedUrl.indexOf("\"") + 1, feedUrl.lastIndexOf("\""));
            }
            else if(feedUrl.contains("\'")) {
                feedUrl = feedUrl.substring(feedUrl.indexOf("\'") + 1, feedUrl.lastIndexOf("\'"));
            }
            else {
                continue;
            }
            if(isFeedURL(feedUrl)) {
                if(URIUtils.INSTANCE.isRelative(feedUrl)) {
                    urlWebsite = URIUtils.INSTANCE.setProtocol(urlWebsite);
                    feedUrl = URIUtils.INSTANCE.concatUrlFragment(urlWebsite, feedUrl);
                }
                break;
            }
        }
        return feedUrl;
    }

    /**
     * @param url candidate to be a feed url.
     * @return true if the informed url is actually a feed, false otherwise.
     * */
    private boolean isFeedURL(String url) {
        String lowerCaseUrl = url.toLowerCase();
        if(lowerCaseUrl.contains("feed") || lowerCaseUrl.contains("rss") || lowerCaseUrl.contains("atom")) {
            return true;
        }
        return false;
    }

    /**
     * @param url used to find the web content where there is probably a feed to be consumed.
     * @return the entire content, which or without url feed.
     * */
    private String retrieveWebsiteContent(String url) {
        StringBuilder content = null;
        String fullUrl = URIUtils.INSTANCE.setProtocol(url);

        if(fullUrl != null) {
            try {
                URL theUrl = new URL(fullUrl);
                BufferedReader br = new BufferedReader(new InputStreamReader(theUrl.openStream()));
                String line = "";
                content = new StringBuilder();
                while(null != (line = br.readLine())) {
                    content.append(line);
                }
            }
            catch (IOException ex) {
                LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return content != null ? content.toString() : null;
    }
}