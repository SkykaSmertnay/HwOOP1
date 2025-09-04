package org.skypro.skyshop.article;

import org.skypro.skyshop.article.BestResultNotFound.BestResultNotFound;
import org.skypro.skyshop.product.Product;
import java.lang.module.FindException;
import java.util.*;

public class SearchEngine implements Comparator<Searchable> {
    private Set<Searchable> searchable = new HashSet<>();



    public Set<Searchable> search(Searchable whatSearch) {
        Set<Searchable> searched = new TreeSet<>();
        int i = 0;

        for (Searchable searchable1 : searchable) {
            if (searchable.contains(whatSearch)) {
                searched.add(whatSearch);
            }
            i++;
        }

        /*for (Searchable searchable1 : searchable) {
            if (searchable.get(i).searchTerm().contains(whatSearch.searchTerm())) {
                searched.put(searchable.get(i).searchTerm() ,searchable.get(i));
            }
            i++;
        }
        */

        return searched;
    }


    public void add(Searchable whatToAdd) {
        searchable.add(whatToAdd);
    }

   /* public Searchable searchBestResult(String search) throws BestResultNotFound {
        int index = -1;
        int maxRepeatCounter = 0;
        int repeatCounter = 0;

        for (int i = 0; i < searchable.size(); i++) {
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

    } */

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

    @Override
    public int compare(Searchable o1, Searchable o2) {

        return Integer.compare(o1.getSearchedName().length(), o2.getSearchedName().length());
    }
}
