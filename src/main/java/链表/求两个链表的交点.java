package 链表;

import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.List;

/**
 * 已知链表A的头节点指针headA，链表B的头节点指针headB，两个链表相交，求两个链表交点对应的节点
 * @author luch
 * @date 2020-4-11-9:55
 */
public class 求两个链表的交点 {

    public static ListNode getIntersectionNode1(ListNode headA,ListNode headB){
        HashSet<ListNode> node_set = new HashSet<>();
        while(headA!=null){
            node_set.add(headA);
            headA = headA.next;
        }
        while (headB!=null){
            if(node_set.contains(headB)){
                return headB;
            }
            headB=headB.next;
        }
        return null;
    }

    public static ListNode getIntersectionNode2(ListNode headA,ListNode headB){
        int list_A_length = get_list_length(headA);
        int list_B_length = get_list_length(headB);
        if(list_A_length>list_B_length){
            headA=forward_long_list(list_A_length,list_B_length,headA);
        }else{
            headB = forward_long_list(list_B_length, list_A_length, headB);
        }
        while (headA!=null && headB!=null){
            if(headA==headB){
                return headA;
            }
            headA=headA.next;
            headB=headB.next;
        }
        return null;
    }
    private static int get_list_length(ListNode head){
        int len=0;
        while (head!=null){
            len++;
            head=head.next;
        }
        return len;
    }
    private static ListNode forward_long_list(int long_len,int short_len,ListNode head){
        int delta=long_len-short_len;
        while (head!=null&&delta!=0){
            head=head.next;
            delta--;
        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
