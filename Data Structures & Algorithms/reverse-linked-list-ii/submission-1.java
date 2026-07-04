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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode lp=head;
        ListNode rp=head;
        ListNode l=head;
        ListNode r=head;
        for(int i=1;i<left;i++){
            l=l.next;
        }
        for(int i=1;i<right;i++){
            r=r.next;
        }
        if(left>=2){
            for(int i=2;i<left;i++){
                lp=lp.next;
            }
        }
        rp=r.next;
        if(left!=1){
            lp.next=null;
        }
        r.next=null;
        ListNode prev=null;
        ListNode curr=l;
        ListNode next=l;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        if(left!=1){
            lp.next=prev;
            l.next=rp;
        }
        if(left==1){
            head=prev;
            l.next=rp;
        }
        return head;

        
       
    }
}