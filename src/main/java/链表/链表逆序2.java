package 链表;

import java.util.Arrays;
import java.util.Date;

/**
 * 已知链表头节点指针head，将链表从位置m到n逆序
 */
public class 链表逆序2 {

    /**
     * @param head
     * @param m 节点位置，从1开始
     * @param n
     * @return
     */
    public static ListNode reverserBetween(ListNode head,int m,int n){
        int change_len=n-m+1;//计算需要逆置的节点个数
        ListNode pre_head=null;//初始化开始逆置的节点的前驱
        ListNode result=head;//最终转换后的链表头节点，非特殊情况即为head
        while(head!=null && --m!=0){//将head向前移动m-1个位置
            pre_head=head;
            head=head.next;
        }
        ListNode modify_list_tail=head;//将modify_list_tail指向当前的head节点，即逆置后的链表尾
        ListNode new_head=null;
        while (head!=null && change_len!=0){ //逆置change_len个节点
            ListNode next = head.next;
            head.next=new_head;
            new_head=head;
            head=next;
            change_len--;
        }
        modify_list_tail.next=head;
        if(pre_head!=null){//如果pre_head不空，说明不是从第一个节点开始逆置的
            pre_head.next=new_head;
        }else{
            result=new_head;
        }
        return result;

    }
    public static void main(String[] args) {
        ListNode head = ListNode.makeListFromArray(Arrays.asList(1, 2, 3, 4, 5));
        ListNode.printList(head);
        ListNode reverseList = reverserBetween(head,2,4);
        ListNode.printList(reverseList);
    }
}
