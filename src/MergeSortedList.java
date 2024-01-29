public class MergeSortedList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
        public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if(list1 == null){
                return list2;
            }
            if(list2 == null){
                return list1;
            }
            ListNode head;
            if(list1.val < list2.val){
                head = list1;
                list1 = list1.next;
            }else{
                head = list2;
                list2 = list2.next;
            }
            head.next = mergeTwoLists(list1, list2);
            return head;
        }

    public static void main(String[] args) {
       ListNode list1 = new ListNode(1);
       list1.next = new ListNode(2);
      // list1.next.next = new ListNode(4);
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
