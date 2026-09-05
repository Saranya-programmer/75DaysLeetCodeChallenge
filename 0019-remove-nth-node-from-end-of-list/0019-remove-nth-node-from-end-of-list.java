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

/*


class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode bab = head;
        ListNode curr = head;
        int size = 0;
        if (head == null || head.next == null) {
            return null;
        }
        
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        if (n == size) {
            return head.next;
        }
        ListNode temp = head;
        int k = size - n;
        int cnt = 0;
        while (temp != null) {
            cnt = cnt + 1;
            if (cnt == k) {
                ListNode curry = temp;
                ListNode curr1 = temp.next;
                curry.next = curr1.next;
                break;
            }
            temp = temp.next;

        }
        return bab;
    }
}


*/


class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast=head;
        for(int i=0;i<n;i++)
        {
            fast=fast.next;
        }
        if(fast==null)
        {
            return head.next;
        }
        ListNode slow=head;
        while(fast.next!=null)
        {
            fast=fast.next;
            slow=slow.next;
            

        }
        ListNode delNode=slow.next;
        slow.next=slow.next.next;
        return head;
    }
}