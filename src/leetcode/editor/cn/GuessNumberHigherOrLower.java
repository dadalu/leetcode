package leetcode.editor.cn;
//猜数字大小	
//guess-number-higher-or-lower	
//374
//猜数字游戏的规则如下： 
//
// 
// 每轮游戏，系统都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。 
// 如果你猜错了，系统会告诉你，你猜测的数字比系统选出的数字是大了还是小了。 
// 
//
// 你可以通过调用一个预先定义好的接口 guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1 或 0）： 
//
// -1 : 你猜测的数字比系统选出的数字大
// 1 : 你猜测的数字比系统选出的数字小
// 0 : 恭喜！你猜对了！
// 
//
// 
//
// 示例 : 
//
// 输入: n = 10, pick = 6
//输出: 6 
// Related Topics 二分查找 
// 👍 77 👎 0

//Java：猜数字大小
public class GuessNumberHigherOrLower{
    public static void main(String[] args) {
        Solution solution = new GuessNumberHigherOrLower().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {

        int l = 1;
        int r = n;
        while(l<=r){
            int mid = l+(r-l)/2;
            int res = guess(mid);
            if(res==0){
                return mid;
            }else if(res<1){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
