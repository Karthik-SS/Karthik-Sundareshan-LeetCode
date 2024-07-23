public class RemoveNthNodeFromEndOfList {
    public static ListNode removeNthNode(ListNode head, int n){
        int length = 0;
        ListNode cur = head;
        //ListNode node = head;
        while(cur != null){
            length++;
            cur = cur.next;
        }
        cur = head;
        int nodeBeforeTheCandidate = length - n;

        for(int i = 1; i < nodeBeforeTheCandidate; i++){
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int n = 2;
        ListNode result = removeNthNode(head, n);
        while (head != null){
            System.out.print(head.val +", ");
            head = head.next;
        }
    }
}
