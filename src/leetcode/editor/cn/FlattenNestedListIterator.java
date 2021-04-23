package leetcode.editor.cn;
//扁平化嵌套列表迭代器
//给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。 
//
// 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。 
//
// 
//
// 示例 1: 
//
// 输入: [[1,1],2,[1,1]]
//输出: [1,1,2,1,1]
//解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。 
//
// 示例 2: 
//
// 输入: [1,[4,[6]]]
//输出: [1,4,6]
//解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
// 
// Related Topics 栈 设计 
// 👍 324 👎 0

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlattenNestedListIterator{


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
/*public interface NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();
    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();
    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}*/
public class NestedIterator implements Iterator<Integer> {
    List<NestedInteger> nestedList;
    List<NestedInteger> stack = new ArrayList<>();
    List<Integer> result = new ArrayList<>();
    int index = 0;
    public NestedIterator(List<NestedInteger> nestedList) {
        int curIndex = 0;
        this.nestedList = nestedList;
        while (curIndex < nestedList.size()) {
            stack.add(nestedList.get(curIndex));
            curIndex++;

            NestedInteger nestedInteger = null;
                while (!stack.isEmpty()) {
                    nestedInteger = stack.remove(0);
                    if (!nestedInteger.isInteger()) {
                        List<NestedInteger> list = nestedInteger.getList();
                        for (NestedInteger ni : list
                        ) {
                            stack.add(ni);
                        }
                    }else {
                        result.add(nestedInteger.getInteger());
                    }
                }

        }

    }

    @Override
    public Integer next() {
        return result.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < result.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
//leetcode submit region end(Prohibit modification and deletion)

}