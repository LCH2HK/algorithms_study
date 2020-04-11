package 链表;

import java.util.*;

/**
 *
 * @author luch
 * @date 2020-4-11-15:32
 */
public class 排序链表的合并 {

    /**
     * 已知两个已排序链表头节点指针l1与l2，将这两个链表合并，合并后仍为有序的，返回合并后的头节点
     */
    public static ListNode mergeTwoList(ListNode l1,ListNode l2){
        ListNode temp_head = new ListNode(0);
        ListNode pre=temp_head;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                pre.next=l1;
                l1=l1.next;
            }else{
                pre.next=l2;
                l2=l2.next;
            }
            pre=pre.next;
        }
        if(l1!=null){
            pre.next=l1;
        }
        if(l2!=null){
            pre.next=l2;
        }
        return temp_head.next;
    }

    /**
     * 已知k个已排序链表头节点指针，将这k个链表合并，合并后仍为有序的，返回合并后的头节点
     */
    public static ListNode mergeKLists1(List<ListNode> lists){
        List<ListNode> node_list = new ArrayList<>();
        //遍历k个链表，将节点全部添加到node_list中
        for (int i = 0; i < lists.size(); i++) {
            ListNode head = lists.get(i);
            while (head!=null){
                node_list.add(head);
                head=head.next;
            }
        }
        if(node_list.size()==0){
            return null;
        }
        //根据节点值进行排序
        Collections.sort(node_list, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        for (int i = 1; i < node_list.size(); i++) {
            node_list.get(i-1).next=node_list.get(i);
        }
        node_list.get(node_list.size()-1).next=null;
        return node_list.get(0);
    }
    public static ListNode mergeKLists2(List<ListNode> lists){
        if(lists.size()==0){
            return null;
        }
        if(lists.size()==1){
            return lists.get(0);
        }
        if(lists.size()==2){
            return mergeTwoList(lists.get(0),lists.get(1));
        }
        int mid=lists.size()/2;
        ArrayList<ListNode> sub1_lists=new ArrayList<>();
        ArrayList<ListNode> sub2_lists=new ArrayList<>();
        for (int i = 0; i < mid; i++) {
            sub1_lists.add(lists.get(i));
        }
        for (int i = mid; i < lists.size(); i++) {
            sub2_lists.add(lists.get(i));
        }
        ListNode l1 = mergeKLists2(sub1_lists);
        ListNode l2 = mergeKLists2(sub2_lists);
        return mergeTwoList(l1,l2);
    }
}
