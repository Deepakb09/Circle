package com.pkr.circle.myGraph;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Deepak on 01-Apr-17.
 */

public class TestMyTime {
    @Test
    public void testIsEquals() throws Exception {
        MyTime t1 = new MyTime(0,1,0);
        MyTime t2 = new MyTime(0,0,1);
        MyTime t3 = new MyTime(0,0,59);
        assertEquals(MyTime.isEqual(t1, t2), 1);
        assertEquals(MyTime.isEqual(MyTime.diff(t1,t2),t3), 0);
        assertEquals(MyTime.isEqual(MyTime.add(t1, t3), t2), 1);
        t1 = new MyTime(0,0,59);
        t2 = new MyTime(0,0,1);
        t3 = new MyTime(0,1,0);
        assertEquals(MyTime.isEqual(t1, t2), 1);
        assertEquals(MyTime.isEqual(MyTime.diff(t2,t1),t3), -1);
        assertEquals(MyTime.isEqual(MyTime.add(t1, t2), t3), 0);
    }
}
