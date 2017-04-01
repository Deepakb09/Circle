package com.pkr.circle.scheduler;

import com.pkr.circle.myGraph.MyGraph;
import com.pkr.circle.myGraph.MyTime;

/**
 * Created by Deepak on 01-Apr-17.
 */

public class MyScheduler
{
    public static int[] mySchedule(MyGraph g, MyTime curTime, MyTime remTime) throws MyScheduleFailException
    {
        MyTime t0 = new MyTime(0,0,0);
        if(MyTime.isEqual(remTime,t0)<=0 || g==null || g.v==null) return null;

        int[] visit = new int[g.num];
        int[] prev = new int[g.num];
        visit[0]=1;
        boolean flag = R(g, curTime, remTime, visit, prev, 0, 0);
        if(flag) return prev;
        throw new MyScheduleFailException();
    }

    private static boolean R(MyGraph g, MyTime curTime, MyTime remTime, int[] visit, int[] prev, int source, int dest)
    {
        int i = 0;
        boolean flag = true, flag2 = true;
        for(i=0; i<g.num; i++)
            if(visit[i]==0 && i!= dest)
                flag2 = false;
        if(flag2)
        {
            if(MyTime.isEqual(new MyTime(0,0,0), g.e[source][dest])<0)
            {
                visit[dest] = 1;
                prev[dest] = source;
                return true;
            }
            else return false;
        }
        else
        {
            for(i=0; i<g.num; i++)
            {
                if(i!= dest && visit[i]==0 && MyTime.isEqual(new MyTime(0,0,0), g.e[source][i])<0)
                {
                    visit[i] = 1;
                    prev[i] = source;
                    MyTime newRemTime = MyTime.diff(remTime, g.e[source][i]) ;
                    MyTime newCurTime = MyTime.add(curTime, g.e[source][i]);
                    if(MyTime.inRange(newCurTime, g.v[i].time_interval_start, g.v[i].time_interval_end) && MyTime.isEqual(newRemTime, g.v[i].time)>=0)
                    {
                        newRemTime = MyTime.diff(newRemTime, g.v[i].time);
                        newCurTime = MyTime.add(newCurTime, g.v[i].time);
                        flag = R(g, newCurTime, newRemTime, visit, prev, i, dest);
                        if (flag)
                        {
                            return true;
                        }
                    }
                    visit[i] = 0;
                    prev[i] = -1;
                }
            }
        }
        return false;
    }
}
