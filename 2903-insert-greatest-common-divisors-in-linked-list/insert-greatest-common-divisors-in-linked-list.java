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
    public int gcd(int a,int b){
        int ans = 1;
        if(a>=b){
            for(int i=1;i<=a;i++){
                if(a%i == 0 && b%i == 0){
                    ans =i;
                }
            }
        }else{
            for(int i=1;i<=b;i++){
                if(a%i == 0 && b%i == 0){
                    ans =i;
                }
            }
        }
        return ans;
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode temp = head;
        while(temp.next != null && temp != null){
            int a = temp.val;
            int b = temp.next.val;
            int gcd = gcd(a,b);
            ListNode gcdNode = new ListNode(gcd);
            gcdNode.next = temp.next;
            temp.next = gcdNode;
            temp = gcdNode.next;
        }
        return head;
    }
}