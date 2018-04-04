package onePointThree;

import java.util.*;

/**
 * Created by jkzhao on 4/4/18.
 */

/**
 * 算数表达式求值
 */
public class Evaluate {

    public static void main(String[] args) {
        String expression = "( 1 + ( ( 2 + 3) * ( 4 * 5 ) ) )";
        expression = expression.replaceAll("\\s+",""); //去掉表达式中的空格

        Set<String> opsSet = new HashSet<>(Arrays.asList("+","*","/","sqrt"));

        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();

        String s = null;
        for (int i=0; i<expression.length(); i++) {
            //s = Character.toString(expression.charAt(i));
            s = String.valueOf(expression.charAt(i)); //String.valueOf( argument ) returns "null" String when Object is null.
                                                        // While, Object.toString() throws java.lang.NullPointerException
                        // when Object is null and also terminate the execution of program in case its not handled properly.
            if ("(".equals(s)) continue; //遇到"("，则忽略
            else if (opsSet.contains(s)) ops.push(s);
            else if (")".equals(s)) {
                //如果遇到")"，弹出运算符和操作数，计算结果并且将结果压入栈
                String op = ops.pop();
                Double v = vals.pop();
                if ("+".equals(op)) v = vals.pop() + v;
                else if ("-".equals(op)) v = vals.pop() - v;
                else if ("*".equals(op)) v = vals.pop() * v;
                else if ("/".equals(op)) v = vals.pop() / v;
                else if ("sqrt".equals(op)) v = Math.sqrt(v);
                vals.push(v);
            }//如果既不是运算符，也不是括号，则作为double值压入操作数栈
            else vals.push(Double.valueOf(s));
        }
        System.out.println(vals.pop());
    }
}
