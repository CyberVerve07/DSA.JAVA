package stack;

public class Problem1 {

    int top = -1;
    int size = 5;
    int[] stack = new int[size];

    void push(int value) {
        if (top == size - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        stack[++top] = value;
    }

    void pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return;
        }
        System.out.println("Popped: " + stack[top--]);
    }

    void display() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

    public static void main(String[] args) {
        Problem1 s = new Problem1();

        s.push(10);
        s.push(20);
        s.push(30);

        s.pop();
        s.display();
    }
}
