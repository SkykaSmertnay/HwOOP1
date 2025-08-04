package org.skypro.skyshop.article;

import java.util.Arrays;

public class SearchEngine {
   private Searchable[] searchable;
   private int size;



    public SearchEngine(int size) {
        this.searchable = new Searchable[size];
        this.size = 0;

    }

    public Searchable[] search(Searchable whatSearch) {
        Searchable[] searched = new Searchable[searchable.length];
        int count1 = 0;
            for (int i = 0; i < searchable.length; i++) {
                if (searchable[i].searchTerm().contains(whatSearch.searchTerm())) {
                    searched[count1] = searchable[i];
                    count1++;
                    if (count1 == size) {
                        System.out.println("Массив переполнен");
                        break;
                    }

                }
            }

        return searched;
    }


    public void add(Searchable whatToAdd) {



        if(size == searchable.length) {
            System.out.println("Массив переполнен");
            return;
        }
        searchable[size] = whatToAdd;
        size++;

    }
}
