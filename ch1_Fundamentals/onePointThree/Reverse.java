package onePointThree;

import java.util.Stack;

/**
 * Created by jkzhao on 4/4/18.
 */

/**
 * foreach遍历栈、栈弹出元素
 */
public class Reverse {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(3);
        stack.push(4);
        stack.push(8);

        for (int i : stack)
            System.out.println(i);
        System.out.println("========");

        while (! stack.isEmpty())
            System.out.println(stack.pop());
    }
}
