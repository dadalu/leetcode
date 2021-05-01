package leetcode.editor.cn;
//字符串解码
//给定一个经过编码的字符串，返回它解码后的字符串。 
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 
//
// 示例 1： 
//
// 输入：s = "3[a]2[bc]"
//输出："aaabcbc"
// 
//
// 示例 2： 
//
// 输入：s = "3[a2[c]]"
//输出："accaccacc"
// 
//
// 示例 3： 
//
// 输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
// 
//
// 示例 4： 
//
// 输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
// 
// Related Topics 栈 深度优先搜索 
// 👍 744 👎 0

import java.util.ArrayList;
import java.util.List;

public class DecodeString{
    public static void main(String[] args) {
        Solution solution = new DecodeString().new Solution();
        solution.decodeString("3[a]2[bc]");
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String decodeString(String s) {
        String str = "";
        char[] chars = s.toCharArray();
        StringBuilder sb ;
        List<Character> list = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {
            if (i==chars.length||chars[i] == ']') {
                sb = new StringBuilder(str);
                char c = list.remove(list.size()-1);
                while (c != '[') {
                    sb.insert(0, c);
                    if (list.isEmpty()) {
                        break;
                    }
                    c = list.remove(list.size() - 1);
                }
                if (!list.isEmpty()) {
                    String temp = sb.toString();
                    char c1;
                    String num = "";
                    while (!list.isEmpty()) {
                        c1 = list.get(list.size() - 1);
                        if (c1 >= '0' && c1 <= '9') {
                            num = c1 + num;
                        } else {
                            break;
                        }
                        list.remove(list.size() - 1);
                    }
                    Integer ic = Integer.valueOf(num);
                    for (int j = 0; j < ic-1; j++) {
                        sb.append(temp);
                    }
                }
                for (int j = 0; j < sb.length(); j++) {
                    list.add(sb.charAt(j));
                }
            } else {
                list.add(chars[i]);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            str += list.get(i);
        }
        return str;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}