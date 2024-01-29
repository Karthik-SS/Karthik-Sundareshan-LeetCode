public class DeleteDupsLinkedList {

    private static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null) {
            ListNode runner = current;
            while (runner.next != null) {
                if (current.val == runner.next.val) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
        return head;
    }

    public static ListNode deleteDups(ListNode head){
        ListNode current = head;
        ListNode runner  = current;
        //4->4->2->3->3->4
        while (runner.next != null){
           if(current.val == runner.next.val){
               runner.next = runner.next.next;
           }else{
               current = current.next;
               runner = runner.next;
           }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(4);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(2);
        list1.next.next.next = new ListNode(3);
        list1.next.next.next.next = new ListNode(3);
        list1.next.next.next.next.next = new ListNode(4);

        ListNode result = deleteDuplicates(list1);
       // ListNode result2 = deleteDups(list1);

        while (result != null) {
            System.out.print(result.val + ", ");
            result = result.next;
        }
        System.out.println();
        System.out.println("+++++++++++++++++++++++");
        /*while (result2 != null) {
            System.out.print(result2.val + ", ");
            result2 = result2.next;
        }*/
    }

}
