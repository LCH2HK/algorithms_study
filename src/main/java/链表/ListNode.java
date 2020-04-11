package 链表;

import java.util.Arrays;
import java.util.List;

/**
 * @author luch
 * @date 2020-4-7-19:44
 */
public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public static void printList(ListNode head){
        System.out.print("[ ");
        while (head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
        System.out.println("]");
    }

    public static ListNode makeListFromArray(List<Integer> arr){
        ListNode head=null;
        for (int elem:arr){
            ListNode node = new ListNode(elem);
            node.next=head;
            head=node;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = makeListFromArray(Arrays.asList(1, 2, 3, 4, 5));
        printList(head);
    }
}
