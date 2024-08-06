package edu.waketech.csc251.collection;

import java.util.ArrayList;
import java.util.List;

import edu.waketech.csc251.tools.Screener;

public class DataSetGeneric<T extends Measurable> {
    private List<T> items;

    public DataSetGeneric() {
        items = new ArrayList<>();
    }

    public void add(T item) {
        items.add(item);
    }

    public int size() {
        return items.size();
    }

    public List<T> getList() {
        return new ArrayList<>(items);
    }

    public List<T> getList(Screener<T> screener) {
        List<T> result = new ArrayList<>();
        for (T item : items) {
            if (screener.test(item)) {
                result.add(item);
            }
        }
        return result;
    }
}
