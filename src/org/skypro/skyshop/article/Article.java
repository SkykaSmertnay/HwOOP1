package org.skypro.skyshop.article;

public final class Article implements Searchable  {
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
    public String toString() {
        return name + "\n" + text ;
    }

    @Override
    public String searchTerm() {
        return toString() + "ARTICLE";
    }

    @Override
    public String searchedContent() {
        return text;
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

