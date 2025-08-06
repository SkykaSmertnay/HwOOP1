package org.skypro.skyshop.article;

public interface  Searchable {
     String searchTerm();
     String searchedContent();
     String getSearchedName();

    default String getStringRepresentation() {
        return "Имя объекта " + " Тип объекта";
    }
}
