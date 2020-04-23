//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找

package leetcode.editor.cn;
public class  Sqrtx{
    public static void main(String[] args){
        Solution solution = new Sqrtx().new Solution();
        int ret = solution.mySqrt(2147395599);
        System.out.println(ret);
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //搞笑版
    /*public int mySqrt(int x) {
        return (int)Math.sqrt(x);
    }  */
    public int mySqrt(int x) {
        if(x<2){
            return x;
        }
        long num;
        int pivot;
        int right = x/2;
        int left = 2;
        while (left<=right){
            pivot = left+(right-left)/2;
            num = (long)pivot*pivot;
            if(num>x){
                right = pivot-1;
            }else if(num<x){
                left =pivot+1;
            }
            else{
                return pivot;
            }
        }
        return right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
