//รับ Array เข้าไปทำ Stack
//package Lab6Queue;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStackA{
    int MAX_SIZE = 100;
    double stack[] = new double[MAX_SIZE];
    int top = 0;
    void push(double d){
        stack[top++] = d;
    }
    public double pop(){
        return stack[--top];
    }
    public double top(){
        if (isEmpty()) {
            throw new EmptyStackException(); // or handle this case appropriately
        }
        return stack[top-1];
    }
    public boolean isFull(){
        return top == MAX_SIZE;
    }
    public boolean isEmpty(){
        return top == 0;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Stack: [");
        for (int i = 0; i < top; i++) {
            sb.append(stack[i]);
            if (i != top - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
