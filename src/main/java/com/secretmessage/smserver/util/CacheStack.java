package com.secretmessage.smserver.util;

import java.util.ArrayList;

// TODO: change this implementation to be faster and more efficient
public class CacheStack<T> extends ArrayList<T> {

    public int n;

    public CacheStack(int n) {
        this.n = n;
    }

    public void call(int index) {
        T e = get(index);
        remove(index);
        add(e);
    }

    public void append(T element) {
        if (size()+1 > n) {
            remove(0);
            add(element);
        }
    }

}
