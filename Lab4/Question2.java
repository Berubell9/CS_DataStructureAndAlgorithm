public class Question2 {
    public static void deleteMN(int m, int n, MyLinkedList list) {
        MyLinkedList.Node tmp = list.head;
        
        while (tmp.next != null) {
            for (int i = 0; i < (m - 1); i++) {
                if (tmp.next != null) {
                    tmp = tmp.next;
                } else {
                    break;
                }
            }
            for (int i = 0; i < n; i++) {
                if (tmp.next != null) {
                    tmp.next = tmp.next.next;
                } else {
                    break;
                }
            }
            if (tmp.next != null) {
                tmp = tmp.next;
            }
        }
        System.out.println(list.toString());
    }
}