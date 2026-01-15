package queue;

 class QueueUsingArray {

    int front = 0, rear = -1, size = 5;
    int[] queue = new int[size];

    void enqueue(int value) {
        if (rear == size - 1) {
            System.out.println("Queue Overflow");
            return;
        }
        queue[++rear] = value;
    }

    void dequeue() {
        if (front > rear) {
            System.out.println("Queue Underflow");
            return;
        }
        System.out.println("Dequeued: " + queue[front++]);
    }

    void display() {
        for (int i = front; i <= rear; i++) {
            System.out.println(queue[i]);
        }
    }

    public static void main(String[] args) {
        QueueUsingArray q = new QueueUsingArray();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.dequeue();
        q.display();
    }
}
