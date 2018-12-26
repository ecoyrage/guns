package cn.stylefeng.guns.modular.zhao.TopK;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        //数组可能存在的问题：1、数组全部在内存中；2、数据元素是否结构化较好并不知；3、即全部数据排序浪费性能；4、数据重复性不可知（是否需要进行去重操作）
        int[] arrs= new int[]{1,5,6,4,8,9,12,56,6};
        //测试双基排序
        long start = System.currentTimeMillis();
        int[] result = findMaxK(arrs,5);
        System.out.println("双基排序耗时："+(System.currentTimeMillis() - start));
        for (int value: result) {
            System.out.print(value+"、");
        }
        System.out.println();
        //测试最小堆
        long startHeap = System.currentTimeMillis();
        int[] top5 = topK(arrs, 5);
        System.out.println("最小堆耗时："+(System.currentTimeMillis() - startHeap));
        Arrays.sort(top5);
        for(int i=0;i<5;i++)
        {
            System.out.print(top5[i]+"、");
        }
    }
    //利用Java自身的双基快速排序
    public static int[] findMaxK(int[] nums , int k){
        Arrays.sort(nums);
        int[] result = new int[k];
        int length = nums.length;
        for (int i = 0; i < k ; i++) {
            result[i] = nums[length - k + i];
        }
        return result;
    }
    //利用最小堆实现
    private static int[] topK(int[] data,int k)
    {
        // 先取K个元素放入一个数组topk中
        int[] topk = new int[k];
        for(int i = 0;i< k;i++)
        {
            topk[i] = data[i];
        }
        // 转换成最小堆
        MinHeap heap = new MinHeap(topk);
        // 从k开始，遍历data
        for(int i= k;i<data.length;i++)
        {
            int root = heap.getRoot();
            // 当数据大于堆中最小的数（根节点）时，替换堆中的根节点，再转换成堆
            if(data[i] > root)
            {
                heap.setRoot(data[i]);
            }
        }
        return topk;
    }
}
class MinHeap
{
    // 堆的存储结构 - 数组
    private int[] data;
    // 将一个数组传入构造方法，并转换成一个小根堆
    public MinHeap(int[] data)
    {
        this.data = data;
        buildHeap();
    }
    // 将数组转换成最小堆
    private void buildHeap()
    {
        for (int i = (data.length) / 2 - 1; i >= 0; i--)
        {
            // 对有孩子结点的元素heapify
            heapify(i);
        }
    }
    private void heapify(int i)
    {
        // 获取左右结点的数组下标
        int l = left(i);
        int r = right(i);
        // 这是一个临时变量，表示 跟结点、左结点、右结点中最小的值的结点的下标
        int smallest = i;
        // 存在左结点，且左结点的值小于根结点的值
        if (l < data.length && data[l] < data[i])
            smallest = l;
        // 存在右结点，且右结点的值小于以上比较的较小值
        if (r < data.length && data[r] < data[smallest])
            smallest = r;
        // 左右结点的值都大于根节点，直接return，不做任何操作
        if (i == smallest)
            return;
        // 交换根节点和左右结点中最小的那个值，把根节点的值替换下去
        swap(i, smallest);
        // 由于替换后左右子树会被影响，所以要对受影响的子树再进行heapify
        heapify(smallest);
    }
    // 获取右结点的数组下标
    private int right(int i)
    {
        return (i + 1) << 1;
    }
    // 获取左结点的数组下标
    private int left(int i)
    {
        return ((i + 1) << 1) - 1;
    }
    // 交换元素位置
    private void swap(int i, int j)
    {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
    // 获取堆中的最小的元素，根元素
    public int getRoot()
    {
        return data[0];
    }
    // 替换根元素，并重新heapify
    public void setRoot(int root)
    {
        data[0] = root;
        heapify(0);
    }
}
