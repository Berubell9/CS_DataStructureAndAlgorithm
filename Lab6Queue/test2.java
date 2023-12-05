class test2{
    public static void main(String args[]){
        int [] values={1, 3, 5, 7, 9, 11};
        MyStackA s=new MyStackA();
        MyQueueA q=new MyQueueA();
        for (int i=0; i < values.length; i++) {
            s.push(values[i]);
            q.enqueue(values[i]+1);
        }
        System.out.println(s);
        System.out.println(q);
        int n=0;
        while(!s.isEmpty()) {
            q.enqueue(s.pop()+q.dequeue());
        }
        System.out.println(s);
        System.out.println(q);
        s.push(0);
        while(!q.isEmpty()) {
            s.push(s.pop()+q.dequeue());
        }
        System.out.println(s);
        System.out.println(q);
    }
}