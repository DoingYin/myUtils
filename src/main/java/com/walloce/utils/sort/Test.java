package com.walloce.utils.sort;

/**
 * @program: myUtils
 * @description:
 * @author: YinYichang
 * @create: 2018/07/18 14:14
 **/
public class Test {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 9, 4, 3};
        //Sorts.bubbleSort(arr);
        Sorts.heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
