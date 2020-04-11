package 栈_队列;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Stack;

/**
 * 设计一个计算器，输入一个字符串存储的数字表达式，
 * 可以计算包括 (、)、+、- 四种符号的数学表达式，
 * 输入的数字表达式字符串保证是合法的，输入的数学表达会中可能存在空格字符
 *
 * 使用状态机
 * @author luch
 * @date 2020-4-11-18:38
 */
public class 简单的计算器 {

    public static int calculate(String expr){
        final int BEGIN_STATE=0;
        final int NUMBER_STATE=1;
        final int OPERATION_STATE=2;
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();
        int number=0;
        int STATE=BEGIN_STATE;
        int compute_flag=0;//是否可以进行计算的标志，0标识不能进行计算
        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);
            if(ch==' '){
                continue;
            }
            switch (STATE){
                case BEGIN_STATE:
                    if(ch>='0' && ch<='9'){
                        STATE=NUMBER_STATE;
                    }else {
                        STATE=OPERATION_STATE;
                    }
                    i--;
                    break;
                case NUMBER_STATE:
                    if(ch>='0' && ch<='9'){
                        number=number*10+ch-'0';
                    }else{
                        numStack.push(number);
                        if(compute_flag==1){
                            compute(numStack,opStack);
                        }
                        number=0;
                        i--;
                        STATE=OPERATION_STATE;
                    }
                    break;
                case OPERATION_STATE:
                    if(ch=='+' || ch=='-'){
                        opStack.push(ch);
                        compute_flag=1;
                    }else if(ch=='('){
                        STATE=NUMBER_STATE;
                        compute_flag=0;
                    }else if(ch>='0' && ch<='9'){
                        STATE=NUMBER_STATE;
                        i--;
                    }else if(ch==')'){
                        compute(numStack,opStack);
                    }
                    break;
            }
        }
        if(number!=0){
            numStack.push(number);
            compute(numStack,opStack);
        }
        if(number==0 && numStack.isEmpty()){
            return 0;
        }
        return numStack.peek();
    }

    private static void compute(Stack<Integer> numStack,Stack<Character> opStack){
        if(numStack.size()<2){
            return;
        }
        int num2=numStack.pop();
        int num1=numStack.pop();

        char op=opStack.pop();
        if(op=='+'){
            numStack.push(num1+num2);
        }else if(op=='-'){
            numStack.push(num1-num2);
        }
    }
}
