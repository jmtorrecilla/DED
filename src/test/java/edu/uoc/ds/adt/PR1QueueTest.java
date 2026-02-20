package edu.uoc.ds.adt;

import edu.uoc.ds.adt.sequential.Queue;
import edu.uoc.ds.adt.util.Point;
import edu.uoc.ds.traversal.Iterator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class PR1QueueTest {
    PR1Queue pr1q;

    private void fillQueue(Point[] points) {

        for (Point point: points) {
            pr1q.add(point);
        }
    }
    @Before
    public void setUp() {
        double a = 0;
        double b = 5;
        double thetaMax = 10 * Math.PI;
        double step = 0.05;

        Point[] points = SpiralGenerator.generate(a, b, thetaMax, step);
        this.pr1q = new PR1Queue(points.length);

        assertNotNull(this.pr1q.getQueue());
        fillQueue(points);
    }

    @After
    public void release() {
        this.pr1q = null;
    }


    @org.junit.Test
    public void queueTest() {
        assertEquals(629, this.pr1q.getQueue().size());

        Point point = pr1q.poll();

        assertEquals(0, point.x(),0);
        assertEquals(0, point.y(),0);

        point = pr1q.poll();
        assertEquals(0.24, point.x(),0.05);
        assertEquals(0.012, point.y(),0.05);

        point = pr1q.poll();
        assertEquals(0.5, point.x(),0.05);
        assertEquals(0.05, point.y(),0.05);

        point = pr1q.poll();
        assertEquals(0.75, point.x(),0.05);
        assertEquals(0.11, point.y(),0.05);

        point = pr1q.poll();
        assertEquals(0.98, point.x(),0.05);
        assertEquals(0.20, point.y(),0.05);

        point = pr1q.poll();
        assertEquals(1.21, point.x(),0.05);
        assertEquals(0.30, point.y(),0.05);


        assertEquals(623, this.pr1q.getQueue().size());
    }

    @Test
    public void queueTest2() {

        Queue<Point> queue = pr1q.getQueue();
        Iterator<Point> it = queue.values();
        assertTrue(it.hasNext());
        Point point = it.next();

        assertEquals(0, point.x(),0);
        assertEquals(0, point.y(),0);

        point = it.next();
        assertEquals(0.24, point.x(),0.05);
        assertEquals(0.012, point.y(),0.05);

        point = it.next();
        assertEquals(0.5, point.x(),0.05);
        assertEquals(0.05, point.y(),0.05);

        point = it.next();
        assertEquals(0.75, point.x(),0.05);
        assertEquals(0.11, point.y(),0.05);

        point = it.next();
        assertEquals(0.98, point.x(),0.05);
        assertEquals(0.20, point.y(),0.05);

        point = it.next();
        assertEquals(1.21, point.x(),0.05);
        assertEquals(0.30, point.y(),0.05);

        Assert.assertTrue(it.hasNext());

    }

}
