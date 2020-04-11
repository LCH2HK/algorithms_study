package 栈_队列;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author luch
 * @date 2020-4-11-16:20
 */
public class 使用队列实现栈 {
}
class MyStack{
    private Queue<Integer> dataQueue;

    public MyStack() {
        dataQueue=new LinkedList<>();
    }

    public void push(int x){
        Queue<Integer> tempQueue = new LinkedList<>();
        tempQueue.offer(x);
        while (!dataQueue.isEmpty()){
            tempQueue.offer(dataQueue.poll());
        }
        while (!tempQueue.isEmpty()){
            dataQueue.offer(tempQueue.poll());
        }
    }

    public int pop(){
        Integer top = dataQueue.poll();
        return top;
    }

    public int top(){
        return dataQueue.peek();
    }

    public boolean isEmpty(){
        return dataQueue.isEmpty();
    }
}