package leetcode.editor.cn;
//恢复二叉搜索树
//给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。 
//
// 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,3,null,null,2]
//输出：[3,1,null,null,2]
//解释：3 不能是 1 左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
// 
//
// 示例 2： 
//
// 
//输入：root = [3,1,4,null,null,2]
//输出：[2,1,4,null,null,3]
//解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。 
//
// 
//
// 提示： 
//
// 
// 树上节点的数目在范围 [2, 1000] 内 
// -231 <= Node.val <= 231 - 1 
// 
// Related Topics 树 深度优先搜索 
// 👍 485 👎 0

import java.util.LinkedList;
import java.util.List;

public class RecoverBinarySearchTree{
    public static void main(String[] args) {
        Solution solution = new RecoverBinarySearchTree().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    private List<TreeNode> pre = new LinkedList<>();
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        forEach(root);
        TreeNode first = null;
        TreeNode last = null;
        for (int i = 0; i < pre.size()-1; i++) {
            if (pre.get(i).val > pre.get(i + 1).val) {
                last = pre.get(i+1);
                if (first == null) {
                    first = pre.get(i);
                }
            }
        }
        if (first != null && last != null) {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }
    }
    public void forEach(TreeNode root) {
        if (root == null) {
            return;
        }
        forEach(root.left);
        pre.add(root);
        forEach(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}