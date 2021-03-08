package leetcode.editor.cn;
//单调数列
//如果数组是单调递增或单调递减的，那么它是单调的。 
//
// 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是
//单调递减的。 
//
// 当给定的数组 A 是单调数组时返回 true，否则返回 false。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：[1,2,2,3]
//输出：true
// 
//
// 示例 2： 
//
// 输入：[6,5,4,4]
//输出：true
// 
//
// 示例 3： 
//
// 输入：[1,3,2]
//输出：false
// 
//
// 示例 4： 
//
// 输入：[1,2,4,5]
//输出：true
// 
//
// 示例 5： 
//
// 输入：[1,1,1]
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 50000 
// -100000 <= A[i] <= 100000 
// 
// Related Topics 数组 
// 👍 74 👎 0

public class MonotonicArray{
    public static void main(String[] args) {
        Solution solution = new MonotonicArray().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isMonotonic(int[] A) {
        if (A.length < 2) {
            return true;
        }
        int d = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] - A[i - 1] > 0 ) {
                if (d >= 0) {
                    d = 1;
                    continue;
                }else {
                    return false;
                }
            }
            if (A[i] - A[i - 1] < 0 ) {
                if (d <= 0) {
                    d = -1;
                    continue;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}