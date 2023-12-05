//รับ LinkList เข้าไปทำ Stack
//package Lab6Queue;
public class MyStackL {
    Node head;
    public void add(int d){
        Node p = new Node(d);
        p.next = head;
        head = p;
    }
    public class Node{
        double data;
        Node next;
        public Node(double d){
            data = d;
        }
    }
    Node top = null;
    void push(double d){
        Node p = new Node(d);
        p.next = top;
        top = p;
    }
    public double pop(){
        double d = top.data;
        top = top.next;
        return d;
    }
    public double top(){
        return top.data;
    }
    public boolean isFull(){
        return false;
    }
    public boolean isEmpty(){
        return top == null;
    }
    public String toString(){
        StringBuffer sb = new StringBuffer("head");
        Node p = top;
        while(p!=null){
            sb.append("-->[");
            sb.append(p.data);
            sb.append("]");
            p=p.next;
        }
        sb.append("->null");
        return new String(sb);
    }
}
