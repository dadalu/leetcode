package leetcode.editor.cn;
//字符串轮转
//string-rotation-lcci	
//面试题 01.09
//字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。 
//
// 示例1: 
//
//  输入：s1 = "waterbottle", s2 = "erbottlewat"
// 输出：True
// 
//
// 示例2: 
//  输入：s1 = "aa", s2 = "aba"
// 输出：False
// 
//
// 
// 
//
// 提示： 
//
// 
// 字符串长度在[0, 100000]范围内。 
// 
//
// 说明: 
//
// 
// 你能只调用一次检查子串的方法吗？ 
// 
// Related Topics 字符串 字符串匹配 
// 👍 75 👎 0

//Java：字符串轮转
public class StringRotationLcci{
    public static void main(String[] args) {
        Solution solution = new StringRotationLcci().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isFlipedString(String s1, String s2) {
        if (s2.length() != s1.length()) {
            return false;
        }
        if (s1.equals("") && s2.equals("")) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(s1);
        sb.append(s1);
        int f = 0,c = 0;
        for (int i = 0; i < sb.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (i + j >= sb.length()) {
                    break;
                }
                if (sb.charAt(i + j) == s2.charAt(j)) {
                    if (j == s2.length() - 1) {
                        return true;
                    }
                } else {
                    break;
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}