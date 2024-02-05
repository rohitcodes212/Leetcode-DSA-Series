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
    public boolean isPalindrome(ListNode head){
        ListNode mid = findMid(head);
        ListNode reverse = reverseLL(mid);
        ListNode re_reverse = reverse;
        
        while(head != null && reverse != null){
            if(head.val != reverse.val){
                break;
            }
            head = head.next;
            reverse = reverse.next;
        }
        reverseLL(re_reverse);
        
        return head == null || reverse == null;
    }
    static ListNode findMid(ListNode head){
        ListNode s = head;
        ListNode f = head;
        
        while(f != null && f.next != null){
            f = f.next.next;
            s = s.next;
        }
        return s;
    }
    static ListNode reverseLL(ListNode head){
        if(head == null){
            return head;
        }
        ListNode prev = null;
        ListNode present = head;
        ListNode next = present.next;
        
        while(present != null){
            present.next = prev;
            prev = present;
            present = next;
            if(next != null){
                next = next.next;
            }
        }
        return prev;
    }
}