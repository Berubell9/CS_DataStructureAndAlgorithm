public class Question8 {
    public static void addNum(MyLinkedList list) {
        MyLinkedList.Node FinalNode = list.head;

        while (list.head != null) {
            if (FinalNode.next == null) {
                break;
            }
            FinalNode = FinalNode.next;
        }
        FinalNode.data += 1;
        while (FinalNode.previous != null) {
            if (FinalNode.previous == null) {
                break;
            }
            if (FinalNode.data > 9) {
                FinalNode.previous.data += 1;
                FinalNode.data = 0;
            }
            FinalNode = FinalNode.previous;
        }
        System.out.println(FinalNode.toString());
    }
}