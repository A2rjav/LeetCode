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
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode temp = head;
        int c=0;

        while(temp != null){
            temp = temp.next;
            c++;
        }
                        
        int half= c/2;
        ListNode curr = head;
        for(int i=0;i<half-1;i++){
            curr = curr.next;
        }

        curr.next = curr.next.next;
        return head;
    }
}