package com.walloce.utils.sort;

import java.util.Arrays;

/**
 * @program: myUtils
 * @description: 排序算法
 * @author: YinYichang
 * @create: 2018/07/18 14:01
 **/
public class Sorts {

    /**
     * @Description: 冒泡排序算法
     * 思想：重复走访过要排序的序列，一次比较两个元素，如果他们的顺序错误就将他们进行交换，一次冒上来的是最小的，其次是第二小。
     * 时间复杂度：O(n^2)
     * 空间复杂度:O(1)
     * 稳定性：稳定
     * @Param: [arr]
     * @return: java.util.ArrayList<java.lang.Integer>
     * @Author: YinYichang
     * @Date: 2018/7/18
     */
    public static int[] bubbleSort(int[] arr) {
        int temp;
        int length = arr.length;
        // 第一层循环:表明比较的次数, 比如 length 个元素,比较次数为 length-1 次（肯定不需和自己比）
        for (int i = 0; i < length - 1; i++) {
            // 把最小的数交换着"冒泡"的相对的最上边,一次冒上来的是最小的,其次是第二小的.
            for (int j = length - 1; j > i; j--) {
                //此处为<时其返回是从小到大排序，>时其返回从大到小
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * @Description: 快速排序
     * 思想：通过一趟排序将待排记录分割成两个部分，其中一部分记录关键字均比另一部分记录的关键字小，则可以分别对这两部分关键字继续排序，以达到整个序列有序的目的。
     * 时间复杂度：O(nlogn),最坏的情况下为O(n^2)
     * 空间复杂度：O(1)
     * 稳定性:不稳定
     * @Param: [arr]
     * @return: int[]
     * @Author: YinYichang
     * @Date: 2018/7/18
     */
    public static int[] quickSort(int[] arr, int low, int heigh) {
        if (low < heigh) {
            int division = partition(arr, low, heigh);
            quickSort(arr, low, division - 1);
            quickSort(arr, division + 1, heigh);
        }
        return arr;
    }

    // 分水岭,基位,左边的都比这个位置小,右边的都大
    private static int partition(int[] arr, int low, int heigh) {
        //用子表的第一个记录做枢轴(分水岭)记录
        int base = arr[low];
        while (low < heigh) {
            //更改下面两个while循环中的<=和>=，即可获取到从大到小排列
            //从表的两端交替向中间扫描，从小到大排列
            while (low < heigh && arr[heigh] >= base) {
                heigh--;
            }
            // 如果高位小于base,base 赋值给 当前 heigh 位,base 挪到(互换)到了这里,heigh位右边的都比base大
            swap(arr, heigh, low);

            while (low < heigh && arr[low] <= base) {
                low++;
            }
            // 如果低位大有base,
            swap(arr, heigh, low);
        }
        //现在low=heigh
        return low;
    }

    //交换大小
    private static void swap(int[] arr, int heigh, int low) {
        int temp = arr[heigh];
        arr[heigh] = arr[low];
        arr[low] = temp;
    }

    /**
     * @Description: 直接选择排序
     * 思想：每一趟排序将会选择出最小的(或者最大的)值，顺序放在已排好序的数列的后面
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     * @Param: [arr]
     * @return: int[]
     * @Author: YinYichang
     * @Date: 2018/7/18
     */
    public static int[] selectionSort(int[] arr) {
        int length = arr.length;
        int temp;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * @Description: 堆排序
     * 思想：堆排序利用这种堆这种数据结构所设计的一种排序算法，可以利用数组的特点快速定位指定索引的元素
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     * @Param: [arr]
     * @return: int[]
     * @Author: Mr.Walloce
     * @Date: 2018/7/18
     */
    public static int[] heapSort(int[] arr) {
        int i;
        // 将arr构成一个大顶堆
        // 从 0 到 arr.length/2 ,这些都是有孩子的节点
        // 没孩子的节点构造大顶堆就无意义了
        for (i = arr.length / 2; i >= 0; i--) {
            heapAdjust(arr, i, arr.length - 1);
        }
        for (i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            // 将arr[0...i-1] 重新构造成一个大顶堆
            heapAdjust(arr, 0, i - 1);
        }
        return arr;
    }

    private static void heapAdjust(int[] arr, int s, int m) {
        int temp, j;
        // 指向临时(相对与root节点)的根节点
        temp = arr[s];
        for (j = 2 * s; j <= m; j *= 2) {
            if (j < m && arr[j] < arr[j + 1]) {
                j++;
            }
            if (temp >= arr[j]) {
                break;
            }
            arr[s] = arr[j];
            s = j;
        }
        arr[s] = temp;
    }

    private static void heapAdjust1(int[] arr, int s, int m) {
        int temp, j;
        // 指向临时(相对与root节点)的根节点
        temp = arr[s];
        for (j = 2 * s; j <= m; j *= 2) {
            // 如果右节点比左节点大,当前节点移到右节点
            if (j < m && arr[j] < arr[j + 1]) {
                // 指向右节点
                j++;
            }
            // 当前的父节点大于现在指向的节点
            // 不需要做任何处理
            if (temp >= arr[j]) {
                break;
            }

            // 当前的父节点小于其下的子节点
            // 换位置,把这个子节点替换到父节点
            // 当前这个位置,如果是叶子节点,则它应该是最小的(相对于它的祖先们)
            // 这个方法目的就是交换parent与children的值,构造大根堆

            // 执行到这里表明当前节点的父节点(临时根节点小于当前的节点),
            // 把当前节点移到上面,换位置
            // arr[s]被覆盖无所谓,因为temp记了这个值(原来的根节点(相对的parent))
            arr[s] = arr[j];

            // 现在把当前的这个元素,看做是临时的parent节点
            // 为了找到此时这个元素的孩子节点,看看是否有比当前这个值还大的
            // 最后s指向 当前遍历到的这个元素
            s = j;
        }
        arr[s] = temp;
    }

    /**
     * @Description: 插入排序
     * 思想：将一个记录插入到一个已排好序的有序表中，从而得到一个新的、记录增1的有序表。默认将第一个元素看为有序表，然后依次插入后边的元素
     * 注意：这里插入元素的时候默认的策略是从后向前看，找第一个比自己小的；而不是从前向后看，找第一个比自己大的
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * 稳定性：稳定
     * @Param: [arr]
     * @return: int[]
     * @Author: Mr.Walloce
     * @Date: 2018/7/18
     */
    public static int[] insertSort(int[] arr) {
        //从小到大排列
        for (int i = 1; i < arr.length; i++) {
            //待插入元素
            int temp = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                //待插入元素小于已有的，就将已有往后挪，直到元素大于插入元素或已经到序列最首端了
                if (temp < arr[j]) {
                    arr[j + 1] = arr[j];
                }
            }
            arr[j + 1] = temp;
        }
        return arr;
    }

    /**
     * @Description: 折半插入排序
     * 思想：折半插入排序是基于直接插入排序进行改写的，其可以减少"移动"和"比较"的次数
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * 稳定性：稳定
     * @Param: [arr]
     * @return: int[]
     * @Author: Mr.Walloce
     * @Date: 2018/7/18
     */
    public static int[] bInsertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //待插入元素
            int temp = arr[i];
            int j;
            int low = 0, high = i - 1;
            //在arr[low..high]中折半查找有序插入的位置
            while (low <= high) {
                //折半
                int m = (low + high) / 2;
                if (temp < arr[m]) {
                    //插入点在低半区
                    high = m - 1;
                } else {
                    //插入点在高半区
                    low = m + 1;
                }
            }
            //记录后移
            for (j = i - 1; j >= high + 1; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = temp;
        }
        return arr;
    }

    /**
     * @Description: 希尔排序
     * 思想：希尔排序也是插入排序的一种，是直接针对插入排序进行改进的，该方法又称为"缩小增量排序"。
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     * @Param: [arr]
     * @return: int[]
     * @Author: Mr.Walloce
     * @Date: 2018/7/18
     */
    public static int[] shellInsert(int[] arr) {
        int step = arr.length / 2; //取增量
        //保证最后一个增量为1
        while (step >= 1) {
            for (int i = step; i < arr.length; i++) {
                int temp = arr[i];
                int j = 0;
                //根插入排序的区别在这里
                for (j = i - step; j >= 0; j -= step) {
                    if (temp < arr[j]) {
                        arr[j + step] = arr[j];
                    }
                }
                arr[j + step] = temp;
            }
            step /= 2;
        }
        return arr;
    }

    /**
     * @Description: 归并排序
     * 思想：归并排序是将两个或两个以上的有序表组合成一个有序表，该算法是采用分治法实现
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(n)
     * 稳定性：稳定
     * @Param: [arr, left, right]
     * @return: int[]
     * @Author: Mr.Walloce
     * @Date: 2018/7/18
     */
    public static int[] mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // 取分割位置
            int middle = (left + right) / 2;
            // 递归划分数组左序列
            mergeSort(arr, left, middle);
            // 递归划分数组右序列
            mergeSort(arr, middle + 1, right);
            //将左数组和右数组进行归并
            merge(arr, left, middle, right);
        }
        return arr;
    }

    private static void merge(int[] arr, int left, int middle, int right) {
        int[] tempArray = new int[arr.length];
        int leftEnd = middle;
        int rightStart = middle + 1;
        // 临时数组的下标
        int tempIndex = left;
        int tmp = left;

        // 先循环两个区间段都没有结束的情况
        while ((left <= leftEnd) && (rightStart <= right)) {
            // 左边的比右边的小,先插入左边的
            if (arr[left] < arr[rightStart]) {
                tempArray[tempIndex++] = arr[left++];
            } else {
                tempArray[tempIndex++] = arr[rightStart++];
            }
        }

        // 判断左序列是否结束
        while (left <= leftEnd) {
            tempArray[tempIndex++] = arr[left++];
        }

        // 判断右序列是否结束
        while (rightStart <= right) {
            tempArray[tempIndex++] = arr[rightStart++];
        }

        // 将临时数组中的内容拷贝回原数组中  
        // （原left-right范围的内容被复制回原数组）
        while (tmp <= right) {
            arr[tmp] = tempArray[tmp++];
        }
    }

    /**
     * @Description: 基数排序
     * 思想：基数是按照低位先排序，然后收集；再按高位排序，然后再收集，依次类推，直到最高位。
     * 注:表示关键词分类到radix(基数)个盒子，在关键词为数字时，基数为10，当关键词为字母时，基数为26
     * 时间复杂度：O(n+d)
     * 空间复杂度：O(n)
     * 稳定性：稳定
     * @Param: [arr, radix, d]
     * @return: int[]
     * @Author: Mr.Walloce
     * @Date: 2018/7/18
     */
    public static int[] radixSort(int[] arr, int radix, int d) {
        //用于暂存元素
        int[] temp = new int[arr.length];
        //用于计数排序
        int[] count = new int[radix];
        int divide = 1;

        for (int i = 0; i < d; i++) {
            System.arraycopy(arr, 0, temp, 0, arr.length);

            // 重置count数组，开始统计下一个关键字  
            Arrays.fill(count, 0);

            // 计算每个待排序数据的子关键字  
            for (int j = 0; j < arr.length; j++) {
                int tempKey = (temp[j] / divide) % radix;
                count[tempKey]++;
            }

            for (int j = 1; j < radix; j++) {
                count[j] = count[j] + count[j - 1];
            }

            // 按子关键字对指定的数据进行排序  
            for (int j = arr.length - 1; j >= 0; j--) {
                int tempKey = (temp[j] / divide) % radix;
                count[tempKey]--;
                arr[count[tempKey]] = temp[j];
            }

            divide = divide * radix;
        }
        return arr;
    }
}
