public class MergeSortedListIterative {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode tail = head;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                tail.next = list1;
                list1 = list1.next;
            }else{
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        tail.next = list1 == null ? list2 : list1;
        //tail = tail.next;
        return head.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        //list1.next.next = new ListNode(4);
        //list1.next.next.next = null;

        ListNode list2 = new ListNode(3);
        list2.next = new ListNode(4);
        //list2.next.next = new ListNode(4);
        //list2.next.next.next = null;

        ListNode result = mergeTwoLists(list1, list2);

        while(result != null){
            System.out.print(result.val +", ");
            result = result.next;
        }

    }
}