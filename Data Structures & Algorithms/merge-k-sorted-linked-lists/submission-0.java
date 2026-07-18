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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> heap = new PriorityQueue<>((n1,n2) -> n1.val - n2.val);
        for(ListNode node : lists) {
            if(node !=null) {
                heap.offer(node);
            }
        }
        ListNode head = new ListNode(0);
        ListNode curr = head;

        while(!heap.isEmpty()) {
           ListNode node = heap.poll();
           curr.next = node;
           curr = curr.next;
           node = node.next;
           if(node != null) {
            heap.offer(node);
           }
        }

        return head.next;
    }
}
