package com.example.demo.test;

/**
 * @description: 堆排序
 * @author: yyc
 * @time: 2022/3/18 10:45
 */
public class HeapSort {
    
    public void heapify(int[] tree,int n,int i){
        if(i>=n){
            return;
        }
        int c1 = i*2 + 1;
        int c2 = i*2 + 2;
        int max = i;
        if(c1<n && tree[c1]>tree[max]){
            max = c1;
        }
        if(c2<n && tree[c2]>tree[max]){
            max = c2;
        }
        if(max!=i){
            swap(tree,max,i);
            heapify(tree,n,max);
        }
    }

    private void swap(int[] tree, int max, int i) {
        int temp = tree[max];
        tree[max] = tree[i];
        tree[i] = temp;
    }

    public static void main(String[] args) {
        int[] tree = {2,5,3,1,10,4};
        int n = 6;
        HeapSort heapSort = new HeapSort();
        heapSort.buildHeap(tree,n);

        // 遍历输出二叉树
        for (int i = 0; i < n; i++) {
            System.out.print(tree[i]+" ");
        }
        System.out.println();
        
        // 有了一个堆之后，怎么做堆排序
        // 最大节点在堆顶，堆排序：先把顶点跟最后一个节点lastNode做交换, 然后砍断最后一个节点
        // 然后对跟节点做一次heapify
    }
    
    public void buildHeap(int[] tree,int n){
        // 从最后一个非叶子节点做heapify，就可以把整个堆构建出来 
        // 即从最后一个节点的父节点出发  lastNode = n-1
        // lastNode的父节点 = (lastNode - 1) / 2
        int lastNode = n-1;
        int parent = (lastNode-1)/2;
        for (int i = parent; i >= 0; i--) {
            heapify(tree,n,i);
        }
    }
    
    

}
