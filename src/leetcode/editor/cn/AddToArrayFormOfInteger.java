package leetcode.editor.cn;
//数组形式的整数加法
//对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。 
//
// 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：A = [1,2,0,0], K = 34
//输出：[1,2,3,4]
//解释：1200 + 34 = 1234
// 
//
// 示例 2： 
//
// 输入：A = [2,7,4], K = 181
//输出：[4,5,5]
//解释：274 + 181 = 455
// 
//
// 示例 3： 
//
// 输入：A = [2,1,5], K = 806
//输出：[1,0,2,1]
//解释：215 + 806 = 1021
// 
//
// 示例 4： 
//
// 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
//输出：[1,0,0,0,0,0,0,0,0,0,0]
//解释：9999999999 + 1 = 10000000000
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 10000 
// 0 <= A[i] <= 9 
// 0 <= K <= 10000 
// 如果 A.length > 1，那么 A[0] != 0 
// 
// Related Topics 数组 
// 👍 72 👎 0

import java.util.*;

public class AddToArrayFormOfInteger{
    public static void main(String[] args) {
        Solution solution = new AddToArrayFormOfInteger().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        while (K > 0) {
            list.add(K%10);
            K=K/10;
        }
        int temp = 0;
        for (int i = A.length-1; i >=0; i--) {
            if (!list.isEmpty()) {
                temp = A[i] + list.remove(0) + temp;
            } else {
                temp = A[i] + temp;
            }
            A[i] = temp%10;
            temp/=10;
            list1.add(0,A[i]);
        }
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            temp = i+temp;
            list1.add(0,temp%10);
            iterator.remove();
            temp/=10;
        }
        if (temp != 0) {
            list1.add(0,temp);
        }
        return list1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}