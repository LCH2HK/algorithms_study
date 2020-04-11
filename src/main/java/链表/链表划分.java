package 链表;

import sun.reflect.generics.tree.ReturnType;

import java.util.List;

/**
 * 已知链表头指针head与数值x，将所有小于x的节点放在大于或等于x的节点前，且保持这些节点原来的相对位置
 * @author luch
 * @date 2020-4-11-12:00
 */
public class 链表划分 {
    public static ListNode partition(ListNode head,int x){
        ListNode less_head=new ListNode(0);//指向小于x的临时链的头节点
        ListNode more_head=new ListNode(0);//指向大于x的临时链的头节点
        ListNode less_ptr=less_head;
        ListNode more_ptr=more_head;
        while(head!=null){
            if(head.val<x){//如果节点值小于x，则将该节点插入less_ptr后
                less_ptr.next=head;
                less_ptr=less_ptr.next;
            }else{//否则将该节点插到more_ptr后
                more_ptr.next=head;
                more_ptr=more_ptr.next;
            }
            head=head.next;
        }
        less_ptr.next=more_head.next;
        more_ptr.next=null;
        return less_head.next;
    }
}
