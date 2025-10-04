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
        if(head == null || head.next == null || k==0 ) return head;
        ListNode temp = head;
        int size = 0;
        while(temp != null ){
            temp = temp.next;
            size++;
        }

        k = k % size;
        if(k==0 ) return head;
        int last = size - k-1;
        temp = head;
        while(last > 0){
            last--;
            temp = temp.next;
        }
        ListNode newHead = temp.next;
        // temp.next = null;
        ListNode tail = temp;

        temp = newHead;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = head;
        tail.next = null;
        return newHead;
    }
}