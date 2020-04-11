package 堆;

import java.util.List;
import java.util.PriorityQueue;

/**
 * 已知一个未排序的数组，求这个数组中第K大的数字
 *
 * 维护一个K大小的最小堆，堆中元素个数小于K时，新元素直接进入堆
 * @author luch
 * @date 2020-4-11-19:42
 */
public class 数组中第K大的数 {

    public static int findKthLargest(int[] nums,int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();//最小堆
        for (int i = 0; i < nums.length; i++) {
            if(minHeap.size()<k){
                minHeap.add(nums[i]);
            }else{
                if(nums[i]>minHeap.peek()){
                    minHeap.poll();
                    minHeap.add(nums[i]);
                }
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(1);
        minHeap.add(99);
        minHeap.add(3);
        minHeap.add(4);
        minHeap.add(5);
        minHeap.add(6);
        System.out.println(minHeap.poll());
        System.out.println(minHeap.poll());
        System.out.println(minHeap.poll());
        System.out.println(minHeap.poll());
        System.out.println(minHeap.poll());
    }
}
