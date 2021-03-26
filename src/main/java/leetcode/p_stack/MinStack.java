package leetcode.p_stack;

import java.util.LinkedList;
import java.util.Stack;

//请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(
//1)。 示例： MinStack minStack = new MinStack(); minStack.push(-2); minStack.push(0);
// minStack.push(-3); minStack.getMin();   --> 返回 -3. minStack.pop(); minStack.top
//();      --> 返回 0. minStack.getMin();   --> 返回 -2. Related Topics 栈
// 👍 41 👎 0
//面试题 03.02
public class MinStack {

    LinkedList<Integer> list = null;
    Stack<Integer> stack = null;

    public MinStack() {
        list = new LinkedList<>();
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (list.isEmpty()){
            list.addFirst(x);
        }else{
            if (list.peekFirst() > x){
                list.addFirst(x);
            }else {
                list.addFirst(list.peekFirst());
            }

        }
    }

    public void pop() {
        stack.pop();
        list.removeFirst();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return list.peekFirst();
    }
}
