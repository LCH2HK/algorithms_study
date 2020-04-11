package 链表;

import java.util.Arrays;
import java.util.List;

/**
 * @author luch
 * @date 2020-4-7-19:43
 */
public class 链表逆序1 {

    static ListNode reverseList(ListNode head){
        ListNode new_head=null;
        while (head!=null){
            ListNode curNode=head;
            ListNode nextNode=head.next;
            curNode.next=new_head;
            new_head=curNode;
            head=nextNode;
        }
        return new_head;
    }



    public static void main(String[] args) {
        ListNode head = ListNode.makeListFromArray(Arrays.asList(1, 2, 3, 4, 5));
        ListNode.printList(head);
        ListNode reverseList = reverseList(head);
        ListNode.printList(reverseList);
    }
}
