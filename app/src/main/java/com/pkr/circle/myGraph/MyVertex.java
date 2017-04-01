package com.pkr.circle.myGraph;

/**
 * Created by Deepak on 01-Apr-17.
 */

public class MyVertex {
    public int location_id;
    public MyTime time_interval_start;
    public MyTime time_interval_end;
    public MyTime time;

    public MyVertex(int l, MyTime tis, MyTime tie, MyTime t)
    {
        this.location_id = l;
        this.time_interval_start = tis;
        this.time_interval_end = tie;
        this.time = t;
    }
}
