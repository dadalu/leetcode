package leetcode.editor.cn;
//删除链表中的节点	题目标题	示例:两数之和
//delete-node-in-a-linked-list	题目标记	示例:two-sum
//237	题目编号
//请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。 
//
// 现有一个链表 -- head = [4,5,1,9]，它可以表示为: 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: head = [4,5,1,9], node = 5
//输出: [4,1,9]
//解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
// 
//
// 示例 2: 
//
// 输入: head = [4,5,1,9], node = 1
//输出: [4,5,9]
//解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
// 
//
// 
//
// 说明: 
//
// 
// 链表至少包含两个节点。 
// 链表中所有节点的值都是唯一的。 
// 给定的节点为非末尾节点并且一定是链表中的一个有效节点。 
// 不要从你的函数中返回任何结果。 
// 
// Related Topics 链表 
// 👍 720 👎 0

//Java：删除链表中的节点
public class P237DeleteNodeInALinkedList {
    public static void main(String[] args) {
        Solution solution = new P237DeleteNodeInALinkedList().new Solution();
        // TO TEST
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);
        solution.deleteNode(head.next.next);
        System.out.println(head);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    class Solution {
    public void deleteNode(ListNode node) {
        if(node.next==null)node=null;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
