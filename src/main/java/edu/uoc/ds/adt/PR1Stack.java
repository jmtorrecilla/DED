package edu.uoc.ds.adt;

import edu.uoc.ds.adt.sequential.Stack;
import edu.uoc.ds.adt.sequential.StackArrayImpl;
import edu.uoc.ds.adt.util.Point;

public class PR1Stack {

    public static final int DEFAULT_CAPACITY = 10;

    private final int capacity;
    private Stack<Point> stack;

    public PR1Stack() {
        this(DEFAULT_CAPACITY);
    }

    public PR1Stack(int capacity) {
        this.capacity = capacity;
        newStack();
    }

    public void newStack() {
        stack = new StackArrayImpl<>(capacity);
    }

    public Stack<Point> getStack() {
        return stack;
    }

    public void push(Point p) {
        stack.push(p);
    }

    public Point pop() {
        return stack.pop();
    }
}