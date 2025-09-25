package org.skypro.skyshop.article;

import org.skypro.skyshop.article.BestResultNotFound.BestResultNotFound;
import org.skypro.skyshop.comparator.ProducNameComparator;
import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine   {
    private Set<Searchable> searchable = new HashSet<>();



    public Set<Searchable> search(Searchable whatSearch) {
        return searchable.stream()
                .filter(item -> item.searchTerm().contains(whatSearch.searchTerm()))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new ProducNameComparator())));
    }
    public void add(Searchable whatToAdd) {
        searchable.add(whatToAdd);
    }

   public Searchable searchBestResult(String search) throws BestResultNotFound {
        Searchable index = null;
        int maxRepeatCounter = 0;
        int repeatCounter = 0;

        for (Searchable item : searchable) {

            maxRepeatCounter = maxRepeat(item.searchTerm(), search);
            if (repeatCounter < maxRepeatCounter) {
                index = item;
                repeatCounter = maxRepeatCounter;

            }
        }
        if (index != null) {
            return index;
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
