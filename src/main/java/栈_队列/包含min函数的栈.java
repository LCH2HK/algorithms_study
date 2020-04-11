package 栈_队列;

import java.util.Stack;

/**
 * @author luch
 * @date 2020-4-11-16:56
 */
public class 包含min函数的栈 {
}
class MinStack{
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public MinStack() {
        dataStack=new Stack<>();
        minStack=new Stack<>();
    }

    public void push(int x){
        dataStack.push(x);
        if(minStack.isEmpty()){
            minStack.push(x);
        }else{
            if(x<minStack.peek()){
                minStack.push(x);
            }else{
                minStack.push(minStack.peek());
            }
        }
    }

    public void pop(){
        dataStack.pop();
        minStack.pop();
    }

    public int top(){
        return dataStack.peek();
    }

    public int getMin(){
        return minStack.peek();
    }
}
