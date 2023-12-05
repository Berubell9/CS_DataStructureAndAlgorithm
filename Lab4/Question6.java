public class Question6 {
    public static void findMid(MyLinkedList list) {
        MyLinkedList.Node tmp = list.head;
        int cnt = 0 ;
        while (tmp.next != null) {
            if (tmp.next != null) {
                tmp = tmp.next ;
                cnt++ ;
            }
        }
        tmp = list.head ;
        if(cnt%2!=0) {
            tmp = tmp.next;
        }

        for (int i = 0; i < cnt/2; i++) {
            if (tmp.next != null) {
                tmp = tmp.next;
            } 
        }
        System.out.println("mid = "+tmp.data) ;
        System.out.println(list.toString());
    }
}