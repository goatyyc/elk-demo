package com.example.demo.test;

/**
 * @description: 小顶堆
 * @author: yyc 
 * @time: 2022/3/18 22:21
 */
public class SmallHeapSort {

    public static void main(String[] args) {
        SmallHeapSort smallHeapSort = new SmallHeapSort();
        int[] tree = {1,5,2,7,3,4};
        // 堆排
        smallHeapSort.heapSort(tree,6);
        for (int i = 0; i < 6; i++) {
            System.out.print(tree[i]+" ");
        }
        System.out.println();
    }

    public void heapify(int[] tree,int n,int index){
        if(index>=n){
            return;
        }
        int c1 = index*2 + 1;
        int c2 = index*2 + 2;
        int min = index;
        if(n>c1 && tree[c1]<tree[min]){
            min = c1;
        }
        if(n>c2 && tree[c2]<tree[min]){
            min = c2;
        }
        if(min!=index){
            swap(tree,min,index);
            heapify(tree,n,min);
        }
    }

    private void swap(int[] tree, int x, int y) {
        int temp = tree[x];
        tree[x] = tree[y];
        tree[y] = temp;
    }

    public void heapSort(int[] tree,int n){
        // 构建堆
        build(tree,n);
        // 堆排序
        // 堆顶的跟最末尾节点交换，然后heapify到i
        for(int i=n-1;i>=0;i--){
            swap(tree,0,i);
            heapify(tree,i,0);
        }
    }

    public void build(int[] tree,int n){
        // 从底向上heapify
        int lastNode = n-1;
        int parent = (lastNode-1) / 2;
        for(int i=parent;i>=0;i--){
            heapify(tree,n,i);
        }
    }
    
}
