package k_Linked_List;

//82. Remove Duplicates from Sorted List II
//https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/

public class x1_Remove_Duplicate_II {
    public static void main(String[] args) {

    }
//
//    public ListNode deleteDuplicates(ListNode head) {
//
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        ListNode dummy = new ListNode(-1);
//        dummy.next = head;
//        ListNode prev = dummy;
//        ListNode temp = head;
//
//
//        while( temp != null && temp.next != null ){
//
//            if ( temp.val == temp.next.val ){
//
//                while( temp.next != null && temp.val == temp.next.val ){
//                    temp = temp.next;
//                }
//
//                prev.next = temp.next;
//            }
//            else{
//                prev = prev.next ;
//            }
//
//            temp = temp.next;
//        }
//
//        return dummy.next;
//
//    }
}
