package com.pkr.circle.myGraph;

/**
 * Created by Deepak on 01-Apr-17.
 */

public class MyTime {
    int hour;
    int min;
    int sec;

    public MyTime(int h, int m, int s)
    {
        this.hour = h;
        this.min = m;
        this.sec = s;
    }
    public static int isEqual( MyTime t1, MyTime t2)
    {
        if(t1.hour==t2.hour && t1.min==t2.min && t1.sec==t2.sec) return 0;
        if(t1.hour<t2.hour || (t1.hour==t2.hour && (t1.min<t2.min || (t1.min==t2.min && t1.sec<t2.sec)))) return -1;
        return 1;
    }

    public static boolean inRange(MyTime t, MyTime t1, MyTime t2)
    {
        if(isEqual(t,t1)>=0 && isEqual(t,t2)<=0)
            return true;
        return false;
    }

    public static MyTime diff(MyTime t1, MyTime t2)
    {
        MyTime t = new MyTime(t1.hour, t1.min, t1.sec);
        if(t1.sec<t2.sec)
        {
            if(t1.min<t2.min)
            {
                t.hour -= 1;
                t.min +=59;
                t.sec +=60;
            }
            else
            {
                t.min -= 1;
                t.sec += 60;
            }
        }
        else
        {
            if(t1.min<t2.min)
            {
                t.hour -= 1;
                t.min += 60;
            }
        }
        t.sec -= t2.sec;
        t.min -= t2.min;
        t.hour -=t2.hour;
        return t;
    }

    public static MyTime add(MyTime t1, MyTime t2)
    {
        MyTime t = new MyTime(t1.hour, t1.min, t1.sec);
        t.sec += t2.sec;
        if(t.sec >= 60)
        {
            t.sec -= 60;
            t.min += 1;
        }
        t.min += t2.min;
        if(t.min >= 60)
        {
            t.min -= 60;
            t.hour += 1;
        }
        t.hour += t2.hour;
        return t;
    }
}
