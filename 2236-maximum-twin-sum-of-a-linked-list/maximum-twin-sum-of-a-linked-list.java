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
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode j = reverse(slow);
        ListNode i = head;

        int sum =Integer.MIN_VALUE;
        while(j!=null){
            sum = Math.max(sum,i.val + j.val);
            i = i.next;
            j = j.next;
        }
        return sum;
    }
    public ListNode reverse(ListNode head){
        ListNode curr = head;

        ListNode prev = null;
        ListNode next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}