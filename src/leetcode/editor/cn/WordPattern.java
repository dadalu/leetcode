package leetcode.editor.cn;

//给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。 
//
// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。 
//
// 示例1: 
//
// 输入: pattern = "abba", str = "dog cat cat dog"
//输出: true 
//
// 示例 2: 
//
// 输入:pattern = "abba", str = "dog cat cat fish"
//输出: false 
//
// 示例 3: 
//
// 输入: pattern = "aaaa", str = "dog cat cat dog"
//输出: false 
//
// 示例 4: 
//
// 输入: pattern = "abba", str = "dog dog dog dog"
//输出: false 
//
// 说明: 
//你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。 
// Related Topics 哈希表 
// 👍 178 👎 0

import java.util.HashMap;
import java.util.Map;

public class WordPattern{
    public static void main(String[] args) {
        Solution solution = new WordPattern().new Solution();
        solution.wordPattern("abba","dog cat cat dog");
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordPattern(String pattern, String str) {
        char[] chars = pattern.toCharArray();
        String[] strings = str.split(" ");
        Map map = new HashMap();
        if(chars.length!=strings.length){
            return false;
        }
        for (int i = 0; i < chars.length; i++) {
            if(map.get(chars[i])==null){
                if(map.containsValue(strings[i])){
                    return false;
                }
                map.put(chars[i],strings[i]);
            }else if(!map.get(chars[i]).equals(strings[i])){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}