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
            ListNode slow=head;
        ListNode fast=head;
        
        

        while(fast!=null&&fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode curr=slow;
        ListNode prev=null;
        while(curr!=null)
        {
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        ListNode first=head;
        ListNode sec=prev;
        while(sec!=null)
        {
            if(first.val!=sec.val)
            {
                return false;
            }
            first=first.next;
            sec=sec.next;
        }
        return true;                   
    }
}