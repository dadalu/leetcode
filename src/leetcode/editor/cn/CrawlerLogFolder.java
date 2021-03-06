package leetcode.editor.cn;
//文件夹操作日志搜集器
//每当用户执行变更文件夹操作时，LeetCode 文件系统都会保存一条日志记录。 
//
// 下面给出对变更操作的说明： 
//
// 
// "../" ：移动到当前文件夹的父文件夹。如果已经在主文件夹下，则 继续停留在当前文件夹 。 
// "./" ：继续停留在当前文件夹。 
// "x/" ：移动到名为 x 的子文件夹中。题目数据 保证总是存在文件夹 x 。 
// 
//
// 给你一个字符串列表 logs ，其中 logs[i] 是用户在 ith 步执行的操作。 
//
// 文件系统启动时位于主文件夹，然后执行 logs 中的操作。 
//
// 执行完所有变更文件夹操作后，请你找出 返回主文件夹所需的最小步数 。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：logs = ["d1/","d2/","../","d21/","./"]
//输出：2
//解释：执行 "../" 操作变更文件夹 2 次，即可回到主文件夹
// 
//
// 示例 2： 
//
// 
//
// 输入：logs = ["d1/","d2/","./","d3/","../","d31/"]
//输出：3
// 
//
// 示例 3： 
//
// 输入：logs = ["d1/","../","../","../"]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= logs.length <= 103 
// 2 <= logs[i].length <= 10 
// logs[i] 包含小写英文字母，数字，'.' 和 '/' 
// logs[i] 符合语句中描述的格式 
// 文件夹名称由小写英文字母和数字组成 
// 
// Related Topics 栈 
// 👍 14 👎 0

import java.util.ArrayList;
import java.util.List;

public class CrawlerLogFolder{
    public static void main(String[] args) {
        Solution solution = new CrawlerLogFolder().new Solution();
        String[] arr = {"d7/","zs7/","fa0/","../","../","iz4/","./","b4/","ou6/","p1/","e2/","fz5/","tr0/","y8/","../","kn0/","sz7/","../","j5/","../","../","f9/","../","aq2/","./","./","e6/","w9/","../","../","x5/","./","../","ko9/","./","./","./","ef7/","../","bc7/","./","./","o5/","q5/","./","./","./","t8/","../","./","./","../","../","../","z6/","tp7/","./","./","r6/","a6/","d3/","p4/","rf1/","j6/","../","o9/","r4/","sr3/","../","../","./","../","./","vw7/","z9/","xi8/","ji1/","mc9/","v2/","f9/","h1/","./","ad7/","c8/","ft4/","./","./","hm1/","sy9/","a3/","./","y9/","ou5/","./","../","te5/","./","c0/","pp3/","./","q4/","./","./","../","./","../","gj1/","wn8/","../","./","ua4/","x5/","./","l7/","../","./","bw4/","./","jv2/","../","dp2/","../","qp8/","../","../","e4/","q3/","../","../","o5/","./","ns4/","../","ss6/","../","./","d5/","c9/","u4/","l7/","gu1/","./","xa5/","l3/","kj4/","rv4/","../","./","../","e2/","rf7/","e9/","../","mj2/","ky0/","s6/","n1/","p8/","./","./","mp6/","ni4/","sr6/","k8/","p0/","../","./","../","../","qk2/","e7/","./","m3/","n8/","../","sd5/","../","../","./","b3/","../","pi8/","gf6/","n9/","hv4/","../","./","o9/","t3/","../","te2/","../","kz8/","./","q7/","wg4/","../","../","is5/","w3/","m0/","../","../","./","./","./","./","w3/","./","../","oy0/","./","o3/","t8/","./","../","uu0/","./","../","ec0/","yb6/","y7/","./","./","pf5/","cv5/","xf4/","u7/","../","./","../","ge3/","ae1/","d4/","i1/","../","./","./","f3/","og2/","j0/","./","../","ut5/","r8/","../","q2/","p4/","rz5/","h2/","./","i8/","./","f6/","./","ms4/","./","./","./","../","./","../","sv8/","k7/","../","../","jd1/","../","./","./","../","./","t5/","../","../","y5/","a5/","../","n2/","../","qz1/","t6/","k2/","d3/","../","./","kb4/","z1/","wl1/","m8/","./","hb9/","o2/","./","../","e2/","d1/","a9/","dh3/","./","../","l4/","sf1/","z1/","../","h3/","../","yn2/","./","wm7/","../","../","./","./","../","gs2/","mr8/","../","../","../","q6/","../","oy5/","kp0/","../","xt1/","de2/","dq7/","../","od8/","in0/","n0/","../","jj5/","../","../","../","../","../","c3/","i5/","./","k2/","../","c9/","hf2/","m7/","../","./","./","gb4/","yz9/","p9/","./","q3/","./","./","ex8/","./","../","bn9/","xp5/","l0/","g6/","./","./","../","t5/","./","n7/","w3/","b9/","./","../","nj0/","../","x3/","../","o9/","m8/","../","lq4/","./","./","../","vo0/","k7/","cx6/","../","b4/","vi0/","../","hs6/","../","./","qz8/","../","s1/","../","gw9/","../","y1/","go6/","qm8/","yw8/","mc0/","bw4/","../","../","../","sx6/","oy9/","qo5/","./","./","q2/","fz7/","qu5/","./","sl7/","./","h2/","./","i7/","../","../","so3/","./","c6/","l9/","./","../","./","r8/","i6/","xr2/","../","../","m8/","ha1/","fq1/","er9/","nt3/","sl6/","../","./","../","./","y4/","f4/","./","kw3/","ve5/","pv0/","../","j9/","d7/","./","k8/","../","./","y9/","je1/","../","../","../","./","z7/","../","../","p2/","./","ke6/","m4/","./","f9/","k5/","l2/","./","w0/","m9/","ep9/","z1/","y7/","../","../","r8/","../","../","xm3/","g2/","../","../","../","../","r5/","../","gn0/","./","yj2/","../","k3/","h6/","i0/","yf8/","zt9/","./","../","../","t8/","q0/","ku2/","./","y6/","./","../","../","y3/","./","j0/","../","../","yc9/","ps2/","e5/","../","f0/","../","./","./","g3/","f1/","../","z1/","j1/","d1/","ml7/","../","h2/","../","p7/","ik8/","../","../","n5/","fm0/","o4/","../","v9/","ta9/","sl5/","./","zk6/","../","../","./","x2/","../","pp6/","../","../","../","f8/","ts3/","../","m0/","../","./","../","ey8/","a8/","a1/","eg0/","./","a4/","../","dd7/","../","./","x3/","./","h1/","b2/","ac0/","../","oe3/","./","../","bv8/","../","../","./","../","../","./","wq2/","z9/","./","../","s3/","r9/","../","./","p5/","../","gu0/","u4/","zz1/","../","o2/","j5/","xe6/","p5/","cq1/","./","m7/","../","yk3/","../","../","../","../","v8/","o7/","../","../","mq9/","cz7/","t3/","../","dn4/","c0/","../","../","../","hi8/","zs0/","../","c4/","m7/","../","e4/","an3/","a2/","./","../","gi8/","uo7/","p6/","../","hb8/","y8/","c6/","./","../","./","nl0/","wi0/","./","e9/","../","../","t0/","b5/","./","../","t2/","q5/","c4/","../","q5/","../","../","l2/","se5/","vy8/","j3/","sz6/","../","yu5/","l2/","./","../","../","bl5/","./","../","./","nt8/","../","./","../","./","../","../","n5/","rw4/","e8/","../","./"};
        System.out.println(solution.minOperations(arr));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minOperations(String[] logs) {
        int count = 0;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < logs.length; i++) {
            if (logs[i].equals("../")) {
                if (count > 0) {
                    count--;
                    list.remove(list.size() - 1);
                }
            }else if(logs[i].equals("./")){
                continue;
            }else {
                if (list.isEmpty()) {
                    list.add(logs[i]);
                    count++;
                } else {
                        list.add(logs[i]);
                        count++;

                }
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}