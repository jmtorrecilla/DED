package edu.uoc.ds.adt;

import edu.uoc.ds.adt.sequential.Queue;
import edu.uoc.ds.traversal.Iterator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class PR1QueueTest {
    PR1Queue pr1q;

    private void fillQueue() {
        for (char c = '0'; c < '9'; c++) {
            pr1q.add(Character.valueOf(c));

        }
    }
    @Before
    public void setUp() {
        this.pr1q = new PR1Queue();

        assertNotNull(this.pr1q.getQueue());
        fillQueue();
    }

    @After
    public void release() {
        this.pr1q = null;
    }


    @org.junit.Test
    public void queueTest() {
        assertEquals(this.pr1q.CAPACITY-1, this.pr1q.getQueue().size());
        Assert.assertEquals(Character.valueOf('0'), pr1q.poll());
        Assert.assertEquals(Character.valueOf('1'), pr1q.poll());
        Assert.assertEquals(Character.valueOf('2'), pr1q.poll());
        Assert.assertEquals(Character.valueOf('3'), pr1q.poll());
        Assert.assertEquals(Character.valueOf('4'), pr1q.poll());
        Assert.assertEquals(Character.valueOf('5'), pr1q.poll());
        Assert.assertEquals(Character.valueOf('6'), pr1q.poll());
        Assert.assertEquals(Character.valueOf('7'), pr1q.poll());
        Assert.assertEquals(Character.valueOf('8'), pr1q.poll());
        assertEquals(0, this.pr1q.getQueue().size());
    }

    @Test
    public void queueTest2() {

        Queue<Character> queue = pr1q.getQueue();
        Iterator<Character> it = queue.values();
        assertTrue(it.hasNext());
        assertEquals(Character.valueOf('0'), it.next());

        assertTrue(it.hasNext());
        assertEquals(Character.valueOf('1'), it.next());

        assertTrue(it.hasNext());
        assertEquals(Character.valueOf('2'), it.next());

        assertTrue(it.hasNext());
        assertEquals(Character.valueOf('3'), it.next());

        assertTrue(it.hasNext());
        assertEquals(Character.valueOf('4'), it.next());

        assertTrue(it.hasNext());
        assertEquals(Character.valueOf('5'), it.next());

        assertTrue(it.hasNext());
        assertEquals(Character.valueOf('6'), it.next());

        assertTrue(it.hasNext());
        assertEquals(Character.valueOf('7'), it.next());

        assertTrue(it.hasNext());
        assertEquals(Character.valueOf('8'), it.next());

    }

}
