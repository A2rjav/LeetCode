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
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next!= null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow = slow.next;

        ListNode prev = null;
        while(slow != null){
            ListNode next  = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        while(prev!= null ){
            if(temp.val != prev.val){
                return false;
            }
            prev = prev.next;
            temp = temp.next;
        }
        return true;

    }
}