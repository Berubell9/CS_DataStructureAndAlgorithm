//Array
//package Lab6Queue;

import java.util.Arrays;

public class MyQueueA{
    int MAX_SIZE = 100;
    double queue[] = new double[MAX_SIZE];
    int head = 0;
    int tail = 0;
    public void enqueue(double d){
        queue[tail]=d;
        tail=(tail+1)%MAX_SIZE;
    }
    public double dequeue(){
        double d = queue[head];
        head = (head+1)%MAX_SIZE;
        return d;
    }
    public double front(){
        return queue[head];
    }
    public boolean isFull(){
        return ((tail+1)%MAX_SIZE)==head;
    }
    public boolean isEmpty(){
        return head == tail;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Queue: [");
        int current = head;
        boolean first = true;
        while (current != tail || first) {
            if (!first) {
                sb.append(", ");
            }
            sb.append(queue[current]);
            current = (current + 1) % MAX_SIZE;
            first = false;
        }
        sb.append("]");
        return sb.toString();
    }
}
