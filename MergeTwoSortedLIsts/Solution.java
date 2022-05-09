package MergeTwoSortedLIsts;


//   public class ListNode {
//       int val;
//       ListNode next;
//       ListNode() {}
//       ListNode(int val) { this.val = val; }
//       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  }
 
class Solution {
    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null) return b;
        
        if (b == null) return a;
        
        ListNode cur;
        
        if (a.val <= b.val){
            cur = a;
            a = a.next;
        } else {
            cur = b;
            b = b.next;
        }
        cur.next = mergeTwoLists(a,b);
        return cur;
    }
        
    }
    
