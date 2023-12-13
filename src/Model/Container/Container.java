package Model.Container;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Container <T> { //typ variabel

    private int maxAmount;

    List<T> output = new ArrayList<>(maxAmount);
    public Deque<T> container = new ArrayDeque<>(maxAmount);

    public Container(int maxAmount) {
        this.maxAmount = maxAmount;
    }

    public void loadN(T n) {
        if (container.size() < maxAmount) {
            container.push(n);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public T unloadN(T n) {
        if (container.size() >= 1) {
            return container.pop();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int size() {
        return container.size();
    }

    public boolean contains() {
        container.isEmpty();
        return container.isEmpty();
    }



}






