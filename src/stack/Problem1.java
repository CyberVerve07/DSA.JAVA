package stack;

import java.util.EmptyStackException;

/**
 * Problem 1: Implementation of a Stack using an Array.
 * Refactored to be generic, dynamic in size, and follow standard Stack API conventions.
 */
public class Problem1<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private T[] stack;
    private int top;
    private int capacity;

    @SuppressWarnings("unchecked")
    public Problem1() {
        this.capacity = DEFAULT_CAPACITY;
        this.stack = (T[]) new Object[capacity];
        this.top = -1;
    }

    @SuppressWarnings("unchecked")
    public Problem1(int initialCapacity) {
        this.capacity = initialCapacity;
        this.stack = (T[]) new Object[capacity];
        this.top = -1;
    }

    /**
     * Pushes an element onto the top of the stack.
     * Automatically doubles the capacity if the stack is full.
     */
    public void push(T value) {
        if (top == capacity - 1) {
            resize();
        }
        stack[++top] = value;
    }

    /**
     * Removes and returns the element at the top of the stack.
     * @throws EmptyStackException if the stack is empty.
     */
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T value = stack[top];
        stack[top--] = null; // Avoid memory leak (dereference for GC)
        return value;
    }

    /**
     * Returns the element at the top of the stack without removing it.
     * @throws EmptyStackException if the stack is empty.
     */
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        capacity *= 2;
        T[] newStack = (T[]) new Object[capacity];
        System.arraycopy(stack, 0, newStack, 0, stack.length);
        stack = newStack;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.print("Stack (top to bottom): ");
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + (i == 0 ? "" : " -> "));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Problem1<Integer> s = new Problem1<>(5);

        System.out.println("--- Pushing elements ---");
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);
        s.push(60); // This will trigger resize
        s.display();

        System.out.println("Peek: " + s.peek());
        System.out.println("Popped: " + s.pop());
        
        System.out.println("--- After pop ---");
        s.display();
        System.out.println("Stack size: " + s.size());
    }
}

