package org.skypro.skyshop.article.BestResultNotFound;

public class BestResultNotFound extends Exception {
   private String search;

    public BestResultNotFound(String search) {
        this.search = search;
    }

    @Override
    public String toString() {
        return "для поискового запроса " +"\"" + search + "\"" + " не нашлось подходящей статьи";
    }
}
