package org.fishe.utils;

/**
 * Created by mendoncafilh on 19/02/14.
 */
public enum URIUtils {
    INSTANCE;

    private static final String HTTP = "http://";
    private static final String HTTPS = "https://";

    public String setProtocol(String url) {
        if(url != null && !(url.contains(HTTP) || url.contains(HTTPS))) {
            url = HTTP + url;
        }
        return url;
    }

    public String removeProtocol(String url) {
        if(url.contains(HTTP)) {
            url = url.replace(HTTP, "");
        }
        else if(url.contains(HTTPS)) {
            url = url.replace(HTTPS, "");
        }
        return url;
    }

    public String concatUrlFragment(String url, String fragment) {
        if(url.endsWith("/") && fragment.startsWith("/")) {
            url = url + fragment.substring(1);
        }
        else if((url.endsWith("/") && !fragment.startsWith("/")) ||
                (!url.endsWith("/") && fragment.startsWith("/"))) {
            url = url + fragment;
        }
        else {
            url = url + "/" + fragment;
        }
        return url;
    }

    public boolean isRelative(String url) {
        if(url.contains("http")) {
            return false;
        }
        return true;
    }
}
