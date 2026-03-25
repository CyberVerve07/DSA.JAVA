package stack;

import java.util.Stack;

/**
 * MinStack implementation that supports push, pop, top, and getMin 
 * all in O(1) time complexity.
 */
public class Problem7 {

    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;

    public Problem7() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    /**
     * Pushes the value onto the stack.
     */
    public void push(int val) {
        mainStack.push(val);
        
        // If minStack is empty or new value is less than or equal to current min
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    /**
     * Removes the element on the top of the stack.
     */
    public void pop() {
        if (mainStack.isEmpty()) return;

        int removedValue = mainStack.pop();
        
        // If the removed value was the current minimum
        if (removedValue == minStack.peek()) {
            minStack.pop();
        }
    }

    /**
     * Gets the top element of the stack.
     */
    public int top() {
        return mainStack.peek();
    }

    /**
     * Retrieves the minimum element in the stack.
     */
    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        Problem7 minStack = new Problem7();
        
        System.out.println("Pushing: 10, 20, 5, 15");
        minStack.push(10);
        minStack.push(20);
        minStack.push(5);
        minStack.push(15);

        System.out.println("Current Min: " + minStack.getMin()); // Expected: 5
        
        System.out.print("Popping: " + minStack.top());
        minStack.pop(); // Pops 15
        System.out.println(" | New Top: " + minStack.top());
        
        System.out.print("Popping: " + minStack.top());
        minStack.pop(); // Pops 5
        System.out.println(" | New Top: " + minStack.top());

        System.out.println("Current Min after popping 5: " + minStack.getMin()); // Expected: 10
    }
}
