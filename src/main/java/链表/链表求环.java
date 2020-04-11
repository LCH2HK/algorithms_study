package 链表;

import java.util.HashSet;

/**
 * 已知链表中可能存在环，若有环返回环起始节点，否则返回null
 * @author luch
 * @date 2020-4-11-11:38
 */
public class 链表求环 {

    /**
     * 使用集合
     */
    public static ListNode detectCycle1(ListNode head){
        HashSet<ListNode> node_set = new HashSet<>();
        while (head!=null){
            if(node_set.contains(head)){
                return head;
            }
            node_set.add(head);
            head=head.next;
        }
        return null;
    }

    /**
     * 使用快慢指针
     */
    public static ListNode detectCycle2(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
        ListNode meet=null;
        while (fast!=null){
            //slow与fast先各走一步
            fast=fast.next;
            slow=slow.next;
            if(fast==null){
                return null;
            }
            fast=fast.next;
            if(fast==slow){
                meet=fast;
                break;
            }
        }
        if(meet==null){
            return null;
        }
        while (head!=null && meet!=null){
            if(head==meet){
                return head;
            }
            head=head.next;
            meet=meet.next;
        }
        return null;
    }

}
