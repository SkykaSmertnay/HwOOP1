package org.skypro.skyshop.article;

import java.util.Objects;

public final class Article implements Searchable{
    private String name;
    private String text;

    public Article(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }




    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(name, article.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return name + "\n" + text ;
    }

    @Override
    public String searchTerm() {
        return toString();
    }

    @Override
    public String searchedContent() {
        return "ARTICLE";
    }

    @Override
    public String getSearchedName() {
        return name;
    }

    @Override
    public String getStringRepresentation() {
        return toString() + "ARTICLE";
    }



}

