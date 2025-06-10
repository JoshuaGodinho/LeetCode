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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;

        HashMap<Integer,ListNode> sumToNode=new HashMap<>();
        int sum=0;

        for(ListNode node=dummy;node!=null;node=node.next)
        {
            sum=sum+node.val;
            sumToNode.put(sum,node);
        }
        sum=0;
        for(ListNode node=dummy;node!=null;node=node.next)
        {
            sum+=node.val;
            node.next=sumToNode.get(sum).next;
        }
        return dummy.next;
    }
}