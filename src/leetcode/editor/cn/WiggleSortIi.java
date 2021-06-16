package leetcode.editor.cn;
//摆动排序 II
//给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。 
//
// 你可以假设所有输入数组都可以得到满足题目要求的结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,1,1,6,4]
//输出：[1,6,1,5,1,4]
//解释：[1,4,1,5,1,6] 同样是符合题目要求的结果，可以被判题程序接受。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,3,2,2,3,1]
//输出：[2,3,1,3,1,2]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 104 
// 0 <= nums[i] <= 5000 
// 题目数据保证，对于给定的输入 nums ，总能产生满足题目要求的结果 
// 
//
// 
//
// 进阶：你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？ 
// Related Topics 排序 
// 👍 257 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WiggleSortIi{
    public static void main(String[] args) {
        Solution solution = new WiggleSortIi().new Solution();
        int[] arr = {1,1,2,1,2,2,1};
        solution.wiggleSort(arr);
        System.out.println(arr);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();

        int n = nums.length/2;
        if (nums.length % 2 == 1) {
            n++;
        }
        int j =1;
        for (int i = n-1; i >=0; i--) {
            list.add(nums[i]);
            if (nums.length - j > n - 1) {
                list.add(nums[nums.length-j]);
            }
            j++;
        }
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}