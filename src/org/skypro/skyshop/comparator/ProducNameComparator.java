package org.skypro.skyshop.comparator;

import org.skypro.skyshop.article.Searchable;
import org.skypro.skyshop.product.Product;

import java.util.Comparator;

public class ProducNameComparator implements Comparator<Searchable> {

    @Override
    public int compare(Searchable o1, Searchable o2) {
        return Integer.compare(Integer.compare(o2.getSearchedName().length(), o1.getSearchedName().length()), 0);
    }
}
