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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null) return head;

        ListNode temp = head;
        ListNode prevLast = null;

        while (temp != null) {
            ListNode kTh = getKth(temp, k);
            if (kTh == null) {
                if (prevLast != null) {
                    prevLast.next = temp;
                }
                break;
            }

            ListNode nextNode = kTh.next;
            kTh.next = null;
            ListNode newHead = reverseLL(temp); // Use the return value of reverseLL

            if (temp == head) {
                head = newHead;
            } else {
                prevLast.next = newHead;
            }
            prevLast = temp;
            temp = nextNode;
        }
        return head;
    }

    // Reverse a linked list and return the new head
    public ListNode reverseLL(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;
        while (temp != null) {
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    // Get the k-th node from the current position
    public ListNode getKth(ListNode temp, int k) {
        k -= 1;
        while (temp != null && k > 0) {
            k--;
            temp = temp.next;
        }
        return temp;
    }
}
