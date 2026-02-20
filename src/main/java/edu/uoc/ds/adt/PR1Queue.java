package edu.uoc.ds.adt;

import edu.uoc.ds.adt.sequential.Queue;
import edu.uoc.ds.adt.sequential.QueueArrayImpl;
import edu.uoc.ds.adt.util.Point;

public class PR1Queue {

    public static final int DEFAULT_CAPACITY = 10;

    private final int capacity;
    private Queue<Point> queue;

    public PR1Queue() {
        this(DEFAULT_CAPACITY);
    }

    public PR1Queue(int capacity) {
        this.capacity = capacity;
        newQueue();
    }

    public void newQueue() {
        queue = new QueueArrayImpl<>(capacity);
    }

    public Queue<Point> getQueue() {
        return queue;
    }

    public void add(Point p) {
        queue.add(p);
    }

    public Point poll() {
        return queue.poll();
    }
}