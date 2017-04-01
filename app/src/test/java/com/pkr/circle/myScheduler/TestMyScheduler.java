package com.pkr.circle.myScheduler;

import com.pkr.circle.myGraph.MyGraph;
import com.pkr.circle.myGraph.MyTime;
import com.pkr.circle.myGraph.MyVertex;
import com.pkr.circle.scheduler.MyScheduler;

import org.junit.Test;

/**
 * Created by Deepak on 01-Apr-17.
 */

public class TestMyScheduler {
    @Test
    public void testMyScheduler2() throws Exception
    {
        MyGraph g = new MyGraph();
        g.num = 2;
        g.v = new MyVertex[2];
        g.v[0] = new MyVertex(0, null, null, null);
        g.v[1] = new MyVertex(1, new MyTime(7,0,0), new MyTime(12,0,0), new MyTime(1,30,0));
        g.e = new MyTime[2][2];
        g.e[0][1] = new MyTime(2,0,0);
        g.e[1][0] = new MyTime(2,0,0);
        int []ans = MyScheduler.mySchedule(g, new MyTime(7,0,0), new MyTime(10,0,0));
        System.out.printf("%d %d\n", ans[0], ans[1]);
    }

    @Test
    public void testMyScheduler3() throws Exception
    {
        MyGraph g = new MyGraph();
        g.num = 3;
        g.v = new MyVertex[3];
        g.v[0] = new MyVertex(0, null, null, null);
        g.v[2] = new MyVertex(2, new MyTime(7,0,0), new MyTime(12,0,0), new MyTime(1,30,0));
        g.v[1] = new MyVertex(1, new MyTime(11,0,0), new MyTime(22,0,0), new MyTime(1,30,0));
        g.e = new MyTime[3][3];
        g.e[0][1] = new MyTime(2,0,0);
        g.e[1][0] = new MyTime(2,0,0);
        g.e[1][2] = new MyTime(2,0,0);
        g.e[2][1] = new MyTime(2,0,0);
        g.e[0][2] = new MyTime(2,0,0);
        g.e[2][0] = new MyTime(2,0,0);
        int []ans = MyScheduler.mySchedule(g, new MyTime(7,0,0), new MyTime(10,0,0));
        System.out.printf("%d %d %d\n", ans[0], ans[1], ans[2]);
    }
}
