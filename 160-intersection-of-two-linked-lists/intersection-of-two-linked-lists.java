/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        ListNode temp2 = headB;

        int la = 0,lb = 0;

        while(temp1!= null ){
            temp1 = temp1.next;
            la++;
        }
        
        while(temp2!= null ){
            temp2 = temp2.next;
            lb++;
        }

        temp1 = headA;
        temp2 = headB;

        while(la != lb){
            if(la>lb){
                la--;
                temp1 = temp1.next;
            }else{
                lb--;
                temp2 = temp2.next;
            }
        }

        while(temp1!= null || temp2 != null){
            if(temp1 == temp2){
                return temp1;
            }
            else{
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
        }
        return null;
    }
}