public class PalindromeReverseLinkedList {
    public static boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfReverse = reverseList(firstHalfEnd.next);

        ListNode p1 = head;
        ListNode p2 = secondHalfReverse;
        boolean result = true;
        while(p2 != null){
            if(p1.val != p2.val){
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        //firstHalfEnd.next = reverseList(secondHalfReverse);
        return result;
    }

    public static ListNode reverseList(ListNode head){
        ListNode cur = head;
        ListNode prev = null;
        while(cur != null){
            ListNode nextNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextNode;
        }
        return prev;
    }
//6->1->0->1->6
//6->1->0->0->1->6
    public static ListNode endOfFirstHalf(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static void main(String[] args) {
/*        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);*/

        ListNode head = new ListNode(6);
        head.next = new ListNode(1);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(0);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(6);

       /*ListNode head = new ListNode(6);
        head.next = new ListNode(1);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(6);*/

        boolean answer = isPalindrome(head);
        System.out.println("Is The Linked List A Palindrome ? = " +answer);
    }
}
