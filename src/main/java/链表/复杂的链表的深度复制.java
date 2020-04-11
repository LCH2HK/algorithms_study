package 链表;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 已知一个复杂的链表，节点中有一个指向本链表任意某个节点的随机指针（也可以为空），求这个链表的深度复制
 * 深度复制：构造生成一个完全新的链表，即使将原链表毁坏，新链表也可以独立使用
 * @author luch
 * @date 2020-4-11-13:35
 */
public class 复杂的链表的深度复制 {
    public static RandomListNode copyRandomList(RandomListNode head){
        //存储原链表上地址到节点位置的map
        Map<RandomListNode, Integer> node_map = new HashMap<>();
        //使用list存储新链表中的节点
        List<RandomListNode> node_list = new ArrayList<>();
        RandomListNode ptr=head;
        int i=0;
        while (ptr!=null){
            node_list.add(new RandomListNode(ptr.val));
            node_map.put(ptr,i);
            ptr=ptr.next;
            i++;
        }
        //再次遍历原始列表，连接新链表的next指针，random指针
        ptr=head;i=0;
        while (ptr!=null){
            node_list.get(i).next=node_list.get(i+1);
            if(ptr.random!=null){
                int id=node_map.get(ptr.random);//random指针指向的节点id
                node_list.get(i).random=node_list.get(id);
            }
            ptr=ptr.next;
            i++;
        }
        return node_list.get(0);
    }
}

class RandomListNode{
    int val;
    RandomListNode next,random;//这种链表有两个指针，一个指向下一个节点，一个指向随机节点

    public RandomListNode(int val) {
        this.val = val;
    }
}
