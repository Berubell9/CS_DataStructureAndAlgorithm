public class MyLinkedList {
    public class Node{
        int data;
        Node next;
        Node previous;
        public Node(int d){
            data = d;
        }
    }

    Node head = null;

    public void add (int d){
        Node p = new Node(d);
        p.previous = null;
        p.next = head;
        if(head != null){
            head.previous = p;
        }
        head = p;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer("head");
        Node p = head;
        while (p != null) {
            sb.append("-> [");
            sb.append(p.data);
            sb.append("]");
            p = p.next;
            
        }
        sb.append("-> null");
        return new String(sb);
    }

    public void add (int d , Node q){
        Node p = new Node(d);
        q.previous = p.next;
        p.next = q;
    }

    public void delete(int d){
        Node t = new Node(0);
        t.next = head;
        Node p = t;
        while ((p.next != null)&&(p.next.data != d)) {
            p = p.next;
        }
        if(p.next != null){
            p.next = p.next.next;
        }
        head = t.next;
    }

    public void delete(Node p){
        p.next = p.next.next;

    }

    public Node find(int d){
        Node p = head;
        while (p != head) {
            if(p.data == d){
                return p;
            }
            p = p.next;
        }
        return null;
    }

}
