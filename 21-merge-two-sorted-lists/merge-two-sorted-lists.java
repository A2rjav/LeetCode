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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp = list1;
        ListNode temp2  = list2;
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while(temp != null && temp2 !=null ){
            if(temp.val >= temp2.val){
                curr.next = temp2;
                temp2 = temp2.next;
            }else{
                curr.next = temp;
                temp = temp.next;
            }
            curr = curr.next;
        }
        while(temp != null){
            curr.next = temp;
            temp = temp.next;
            curr = curr.next;
        }
        while(temp2 != null){
            curr.next = temp2;
            temp2 = temp2.next;
            curr = curr.next;
        }
        return head.next;
    }
}