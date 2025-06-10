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
        ListNode node=dummy;

        while(node!=null)
        {
            sum+=node.val;
            if(sumToNode.containsKey(sum))
            {
                ListNode prev=sumToNode.get(sum);
                ListNode temp=prev.next;
                int tempSum=sum;

                while(temp!=node)
                {
                    tempSum+=temp.val;
                    sumToNode.remove(tempSum);
                    temp=temp.next;
                }
                prev.next=node.next;
            }
            else
            {
                sumToNode.put(sum,node);
            }
            node=node.next;
        }
        return dummy.next;
    }
}