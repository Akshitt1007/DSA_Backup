package k_Linked_List;

//19. Remove Nth Node From End of List
//https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
// */
//class Solution {
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//
//        ListNode temp = head;
//
//        int length = 0;
//        while( temp != null ){
//            length++;
//            temp = temp.next;
//        }
//
//        if ( length == 0 ){
//            return new ListNode();
//        }
//        if ( length == 1 ){
//            return head.next;
//        }
//        if (n == length) {
//            return head.next;
//        }
//
//        temp = head;
//        int i=0;
//
//        while (i < length - n - 1) {
//            temp = temp.next;
//            i++;
//        }
//
//        if ( temp.next.next != null ){
//            temp.next = temp.next.next;
//        }
//        else{
//            temp.next = null;
//        }
//
//        return head;
//    }
//}
