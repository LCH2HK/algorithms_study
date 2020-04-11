package 栈_队列;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author luch
 * @date 2020-4-11-16:43
 */
public class 用栈实现队列 {
}

class MyQueue{
    private Stack<Integer> dataStack;

    public MyQueue() {
        dataStack=new Stack<>();
    }

    public void offer(int x){
        Stack<Integer> tempStack = new Stack<>();
        while (!dataStack.isEmpty()){
            tempStack.push(dataStack.pop());
        }
        tempStack.push(x);
        while (!tempStack.isEmpty()){
            dataStack.push(tempStack.pop());
        }
    }

    public int poll(){
        return dataStack.pop();
    }

    public int peek(){
        return dataStack.peek();
    }

    public boolean isEmpty(){
        return dataStack.isEmpty();
    }
}
