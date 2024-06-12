public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = null;
        System.out.println("Before Reversing");
        System.out.println("/*****************/");
        while (head != null){
            System.out.print(head.val +", ");
            head = head.next;
        }
        head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = null;
        ListNode result = reverseLinkedList(head);
        System.out.println();
        System.out.println();
        head = new ListNode(4);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = null;
        System.out.println("After Reversing");
        System.out.println("/*****************/");
        while(result != null){
            System.out.print(result.val +", ");
            result = result.next;
        }
        System.out.println();
        System.out.println("Recursive Reverse");
        System.out.println("/*=**=**=**=**=**=**=*/");
        ListNode node = reverseList(head);
        System.out.println("Result Of Recursive Reverse");
        System.out.println("/*****************/");
        while(node != null){
            System.out.print(node.val +", ");
            node = node.next;
        }
    }
    private static ListNode reverseLinkedList(ListNode head) {
        ListNode cur = head;
        head = null;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = head;
            head = cur;
            cur = temp;
        }
        return head;
    }
    public static ListNode reverseList(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

}
