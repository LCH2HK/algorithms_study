package 栈_队列;

import java.util.Queue;
import java.util.Stack;

/**
 * 已知从1到n的数字序列，按顺序入栈，
 * 每个数字入栈后即可出栈，也可在栈中停留，等待后面的数字入栈出栈后，该数字再出栈，
 * 求该数字序列的出栈顺序是否合法
 * @author luch
 * @date 2020-4-11-18:24
 */
public class 合法的出栈顺序 {

    /**
     * @param order 待检查的出栈顺序
     * @return
     */
    public static boolean isValidOrder(Queue<Integer> order){
        Stack<Integer> stack = new Stack<>();
        int n = order.size();
        for (int i = 1; i <= n; i++) {
            stack.push(i);
            while (!stack.isEmpty() && stack.peek()==order.peek()){
                stack.pop();
                order.poll();
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }

}
