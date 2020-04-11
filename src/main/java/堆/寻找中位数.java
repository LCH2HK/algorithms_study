package 堆;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 设计一个数据结构，该数据结构动态维护一组数据，且支持如下操作：
 * 1、添加元素：void addNum(int num)，将整型num添加至数据结构中;
 * 2、返回数据的中位数：double findMedian()，返回其维护的数据的中位数
 * @author luch
 * @date 2020-4-11-20:08
 */
public class 寻找中位数 {

    public static void main(String[] args) {
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        maxHeap.add(1);
        maxHeap.add(2);
        maxHeap.add(3);
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.poll());
    }
}

/**
 * 动态维护一个最大堆与一个最小堆，最大堆与最小堆各存储一半数据，
 * 维持最大堆的堆顶比最小堆的堆顶小
 */
class MedianFinder{
    private PriorityQueue<Integer> minHeap=new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap=new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });

    public void addNum(int num){
        if(maxHeap.isEmpty()){
            maxHeap.add(num);
            return;
        }
        if(maxHeap.size()==minHeap.size()){
            if(num<maxHeap.peek()){
                maxHeap.add(num);
            }else{
                minHeap.add(num);
            }
        }else if(maxHeap.size()>minHeap.size()){
            if(num<maxHeap.peek()){
                minHeap.add(maxHeap.poll());
                maxHeap.add(num);
            }else{
                minHeap.add(num);
            }
        }else if(maxHeap.size()<minHeap.size()){
            if(num<maxHeap.peek()){
                maxHeap.add(num);
            }else{
                maxHeap.add(minHeap.poll());
                minHeap.add(num);
            }
        }
    }

    double findMedian(){
        if(maxHeap.size()==minHeap.size()){
            return (maxHeap.peek()+minHeap.peek())/2;
        }else if(maxHeap.size()>minHeap.size()){
            return maxHeap.peek();
        }else {
            return minHeap.peek();
        }
    }

}

