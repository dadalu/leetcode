package leetcode.editor.cn;
//相对名次
//给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal",
// "Silver Medal", "Bronze Medal"）。 
//
// (注：分数越高的选手，排名越靠前。) 
//
// 示例 1: 
//
// 
//输入: [5, 4, 3, 2, 1]
//输出: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
//解释: 前三名运动员的成绩为前三高的，因此将会分别被授予 “金牌”，“银牌”和“铜牌” ("Gold Medal", "Silver Medal" and 
//"Bronze Medal").
//余下的两名运动员，我们只需要通过他们的成绩计算将其相对名次即可。 
//
// 提示: 
//
// 
// N 是一个正整数并且不会超过 10000。 
// 所有运动员的成绩都不相同。 
// 
// 👍 58 👎 0

public class RelativeRanks{
    public static void main(String[] args) {
        Solution solution = new RelativeRanks().new Solution();
        int[] arr = {5,6,4,3,9,2,1,7,8};
        System.out.println(solution.findRelativeRanks(arr));

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] findRelativeRanks(int[] nums) {
        String[] ret = new String[nums.length];
        int max = 0;
        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max,nums[i]);
        }
        int[] temp =new int[max+1];
        for (int i = 0; i < nums.length; i++) {
            temp[nums[i]] = i+1;
        }
        for (int i = temp.length-1; i >-1; i--) {
            if(temp[i]!=0){
                s++;
                if(s==1){
                    ret[temp[i]-1]="Gold Medal";
                }else if(s==2){
                    ret[temp[i]-1]="Silver Medal";
                }else if(s==3){
                    ret[temp[i]-1]="Bronze Medal";
                }else{
                    ret[temp[i]-1]=String.valueOf(s);
                }
            }
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}