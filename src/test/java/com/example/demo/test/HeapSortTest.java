package com.example.demo.test;

/**
 * @description: 手写堆排序[数组]
 * @author: yyc
 * @time: 2022/3/18 17:17
 */
public class HeapSortTest {

    // 测试
    public static void main(String[] args) {
        HeapSortTest heapSortTest = new HeapSortTest();
        int[] tree = new int[]{2,5,3,1,10,4};
        int n = 6;
        heapSortTest.rebuild(tree,n);
        // 遍历输出二叉树
        for (int i = 0; i < n; i++) {
            System.out.print(tree[i]+" ");
        }
        System.out.println();
        // 遍历输出堆排序后的数组
        heapSortTest.heapSort(tree,n);
        for (int i = 0; i < n; i++) {
            System.out.print(tree[i]+" ");
        }
        System.out.println();

    }
    
    // 核心方法 heapify(int[] tree,int n,int index) 【大根堆】
    // 对当前堆的index下标进行 调整，让它自底向上调整
    // 子节点 : i*2+1 和 i*2+2
    public void heapify(int[] tree,int n,int index){
        if(n<=index) return;
        int c1 = index*2 + 1;
        int c2 = index*2 + 2;
        int max = index;
        if(c1<n && tree[c1]>tree[max]){
            max = c1;
        }
        if(c2<n &&tree[c2]>tree[max]){
            max = c2;
        }
        // 找到一个当前堆的较大值
        // 交换
        if(max!=index){
            swap(tree,max,index);
            heapify(tree,n,max);
        }
    }

    private void swap(int[] tree, int max, int index) {
        int temp = tree[max];
        tree[max] = tree[index];
        tree[index] = temp;
    }

    /**
     * 重建一颗二叉树，需要从它的lastNode。
     * 即最后一颗非叶子节点找它的parent，
     * parent = ( lastNode-1 ) / 2
     * 从后往前，依次调用heapify
     * @param tree
     */
    public void rebuild(int[] tree,int n){
        int lastNode = n-1;
        int parent = (lastNode-1)/2;
        for (int i = parent; i >= 0; i--) {
            heapify(tree,n,i);
        }
    }

    public void heapSort(int[] tree,int n){
        // 从最尾部节点开始，交换头尾，依次交换至节点0
        for(int i=n-1;i>=0;i--){
            // 交换
            swap(tree,i,0);
            // heapify根节点
            heapify(tree,i,0);
        }
    }
}
