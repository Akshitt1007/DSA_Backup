package k_Linked_List;

//725. Split Linked List in Parts
//https://leetcode.com/problems/split-linked-list-in-parts/description/

//class Solution {
//    public ListNode[] splitListToParts(ListNode head, int k) {
//        ListNode[] arr = new ListNode[k];
//
//        int length = 0;
//        ListNode temp = head;
//
//        while( temp != null ){
//            length++;
//            temp = temp.next;
//        }
//
//        int remainder = length/k - 1;
//        int count = length% k;
//
//        temp = head;
//
//        for( int i = 0; i < k; i++ ){
//            arr[i] = temp;
//
//            if( count != 0 ){
//                for( int j = 0; j < remainder + 1; j++ ){
//                    if( temp != null ){
//                        temp = temp.next;
//                    }
//                }
//                count = count-1;
//            }
//            else{
//                for( int j = 0; j < remainder; j++ ){
//                    if( temp != null ){
//                        temp = temp.next;
//                    }
//                }
//            }
//
//            if( temp != null ){
//                ListNode next = temp.next;
//                temp.next = null;
//                temp = next;
//            }
//        }
//
//        return arr;
//    }
//}
