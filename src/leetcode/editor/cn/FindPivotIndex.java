package leetcode.editor.cn;
//寻找数组的中心索引
//给定一个整数类型的数组 nums，请编写一个能够返回数组 “中心索引” 的方法。 
//
// 我们是这样定义数组 中心索引 的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。 
//
// 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。 
//
// 
//
// 示例 1： 
//
// 输入：
//nums = [1, 7, 3, 6, 5, 6]
//输出：3
//解释：
//索引 3 (nums[3] = 6) 的左侧数之和 (1 + 7 + 3 = 11)，与右侧数之和 (5 + 6 = 11) 相等。
//同时, 3 也是第一个符合要求的中心索引。
// 
//
// 示例 2： 
//
// 输入：
//nums = [1, 2, 3]
//输出：-1
//解释：
//数组中不存在满足此条件的中心索引。 
//
// 
//
// 说明： 
//
// 
// nums 的长度范围为 [0, 10000]。 
// 任何一个 nums[i] 将会是一个范围在 [-1000, 1000]的整数。 
// 
// Related Topics 数组 
// 👍 226 👎 0

public class FindPivotIndex{
    public static void main(String[] args) {
        Solution solution = new FindPivotIndex().new Solution();
        int[] arr = {1, 7, 3, 6, 5, 6};
        System.out.println(solution.pivotIndex(arr));

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int pivotIndex(int[] nums) {

        int l =0;
        int r = nums.length-1;
        int lSum =0;
        int rSum =0;
        int index =-1;
        for (int i = 0; i < nums.length; i++) {
            rSum+=nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            rSum-=nums[i];
            if(lSum==rSum){
                index = index==-1?i:Math.min(index,i);
            }
            lSum+=nums[i];
        }
        return index;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}