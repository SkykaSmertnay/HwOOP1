package org.skypro.skyshop.article;

import org.skypro.skyshop.article.BestResultNotFound.BestResultNotFound;

import java.lang.module.FindException;
import java.util.Arrays;
import java.util.Objects;

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
    public Searchable searchBestResult (String search) throws BestResultNotFound {
        int index = -1;
        int maxRepeatCounter = 0;

        for (int i = 0; i < searchable.length; i++) {
            if (maxRepeat(searchable[i].searchTerm(), search) > maxRepeatCounter ){
                index = i;
                maxRepeatCounter = maxRepeat(searchable[i].searchTerm(), search);
            }
        }

            if (index != -1) {
                return searchable[index];
            } else {
                throw new BestResultNotFound(search);
            }

    }

    private int maxRepeat(String str, String substring) {
        int count = 0;
        int index = 0;
        int substringIndex = str.indexOf(substring, index);
        while (substringIndex != -1) {
            count++;
            index = substringIndex + substring.length();
            substringIndex = str.indexOf(substring, index);
        }
        return count;
    }
}
