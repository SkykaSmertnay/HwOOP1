package org.skypro.skyshop.comparator;
import org.skypro.skyshop.article.Searchable;


import java.util.Comparator;

public class ProducNameComparator implements Comparator<Searchable> {

    @Override
    public int compare(Searchable o1, Searchable o2) {
        int x = Integer.compare(o1.getSearchedName().length(), o2.getSearchedName().length());
        if (x != 0) {
            return x;
        }
        return o1.getSearchedName().compareTo(o2.getSearchedName());
    }

}

