package org.skypro.skyshop.article;

import org.skypro.skyshop.article.BestResultNotFound.BestResultNotFound;

import java.lang.module.FindException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class SearchEngine {
    private List<Searchable> searchable = new LinkedList<>();
    private int size = 0;


    public List search(Searchable whatSearch) {
        //Searchable[] searched = new Searchable[size];
        List<Searchable> searched = new LinkedList<>();
        int count1 = 0;
        for (int i = 0; i < size; i++) {
            if (searchable.get(i).searchTerm().contains(whatSearch.searchTerm())) {
                searched.add(searchable.get(i));
                count1++;

            }
        }

        return searched;
    }


    public void add(Searchable whatToAdd) {
        searchable.add(whatToAdd);
        size++;
    }

    public Searchable searchBestResult(String search) throws BestResultNotFound {
        int index = -1;
        int maxRepeatCounter = 0;
        int repeatCounter = 0;

        for (int i = 0; i < size; i++) {
            maxRepeatCounter = maxRepeat(searchable.get(i).searchTerm(), search);
            if (repeatCounter < maxRepeatCounter) {
                index = i;
                repeatCounter = maxRepeatCounter;

            }
        }

        if (index != -1) {
            return searchable.get(index);
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
