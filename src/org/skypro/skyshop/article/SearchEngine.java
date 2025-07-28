package org.skypro.skyshop.article;

import java.util.Arrays;

public class SearchEngine {
    Searchable[] searchable;
    private int count = 0;
    int size;


    public SearchEngine(int size) {
        this.size = size;
        this.searchable = new Searchable[size];

    }
    Searchable[] searched = new Searchable[5];

    public Searchable[] search(Searchable[] whatSearch) {
        int count1 = 0;
        for (int j = 0; j < searched.length; j++) {
            for (int i = 0; i < searched.length; i++) {
                if (searched[i].searchTerm().contains(whatSearch[j].searchTerm())) {
                    searchable[count1] = searched[i];
                    count1++;
                    if (count1 == size) {
                        System.out.println("Массив переполнен");
                        break;
                    }

                }
            }
        }
        return searchable;
    }

    public void add(Searchable whatToAdd) {
        if(count == size) {
            System.out.println("Массив переполнен");
            return;
        }
        searched[count] = whatToAdd;
        count++;

    }
}
