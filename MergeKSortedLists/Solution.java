package MergeKSortedLists;

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

// Different Solutions:
// - Simple: Iterate through each Array index and merge each list one by one O(NK)
// - Simple: Array of pointers (head) at each index, compare all heads, increase pointers when finding the minimum - return the head O(NK)
// - Simple: Join all the LinkedLists into one big LinkedLists, then sort the entire List O(N)
// - Divide & Conquer: Divide lists into pairs, two indexes, merge them in bottom up manner, keep dividing in a tree until you have one single Node, then merge upwards (recursion tree). O(NLog2K) Almost like Binary Tree
// - Heap: Push 1st element of all K lists into Min Heap (Build heap), Pop smallest different add it to list, update pointer and Push new Node if NOT NULL. O(NLog2K)

import java.util.*;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) return null;
        
        Queue<ListNode> minHeap = new PriorityQueue<>(n, (a,b) -> a.val - b.val);
        for (ListNode list: lists){
            if(list != null){
                minHeap.offer(list);
                System.out.println("minHeap.offer(list): " + list);
            } 
        }
        
        if(!minHeap.isEmpty()){
            // Take head since it's sorted
            ListNode head = minHeap.poll();
            ListNode tail = head;
            
            // Add next pointer from initial head, to keep all pointers
            if(tail.next != null) minHeap.offer(tail.next);
            while(!minHeap.isEmpty()){
                // Take head from minHeap make it next value for Tail
                tail.next = minHeap.poll();
                
                // Add head to tail, make next tail the current and Add next value to minHeap
                tail = tail.next;
                if(tail.next != null) {
                    minHeap.offer(tail.next);
                }
            }
            
            return head;
        }
        
        return null;
    }
}
