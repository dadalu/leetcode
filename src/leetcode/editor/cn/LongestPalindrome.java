package leetcode.editor.cn;

//给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。 
//
// 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。 
//
// 注意: 
//假设字符串的长度不会超过 1010。 
//
// 示例 1: 
//
// 
//输入:
//"abccccdd"
//
//输出:
//7
//
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
// 
// Related Topics 哈希表 
// 👍 221 👎 0

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome{
    public static void main(String[] args) {
        Solution solution = new LongestPalindrome().new Solution();
        System.out.println(solution.longestPalindrome("abababab"));
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestPalindrome(String s) {
        int n =0;
        char[] chars = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (char c:chars) {
            Integer num = map.get(c);
            if(num!=null){
                if(num>1){
                    map.put(c,--num);
                }else if(num==1){
                    map.remove(c);
                }
                n+=2;
            }else{
                map.put(c,1);
            }
        }
        if(map.size()>0){
            return n+1;
        }
        return n;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}