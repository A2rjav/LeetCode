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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        ListNode temp = head;
        int l=1;
        while(temp.next != null ) {
            temp = temp.next;
            l++;
        }
        temp.next = head;
        k = k % l;
        int newHead = l - k;
        ListNode curr = head;
        for(int i=0;i<newHead-1;i++){
            curr= curr.next;
        }
        ListNode ans = curr.next;
        curr.next = null;
        return ans;
    }
}