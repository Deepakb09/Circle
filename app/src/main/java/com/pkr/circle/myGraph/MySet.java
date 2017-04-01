package com.pkr.circle.myGraph;

/**
 * Created by Deepak on 01-Apr-17.
 */

public class MySet {

    int arr[];
    int size;

    public MySet(int num)
    {
        size = num;
        arr = new int[num];
    }

    public void merge(int a, int b)
    {
        int g1, g2;
        g1 = getRoot(a);
        g2 = getRoot(b);
        arr[g2] = g1;
    }

    public int getRoot(int a)
    {
        if(arr[a]==-1) return a;
        return getRoot(arr[a]);
    }
}
