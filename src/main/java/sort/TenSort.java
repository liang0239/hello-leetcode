package sort;

public class TenSort {

    public static void main(String[] args){
        TenSort tenSort = new TenSort();
        int[] arr = {9,7,8,2,5,1,3,6,4};
        for (int tmp : tenSort.insertSort(arr)) {
            System.out.println(tmp);
        }
    }

//    1、冒泡排序（Bubble Sort）
//    把第一个元素与第二个元素比较，如果第一个比第二个大，则交换他们的位置。接着继续比较第二个与第三个元素，如果第二个比第三个大，则交换他们的位置....
//我们对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样一趟比较交换下来之后，排在最右的元素就会是最大的数。
//除去最右的元素，我们对剩余的元素做同样的工作，如此重复下去，直到排序完成。
//    性质：1、时间复杂度：O(n2) 2、空间复杂度：O(1) 3、稳定排序 4、原地排序
    public int[] bubbleSort(int[] arr){
        if (arr == null || arr.length < 2){
            return arr;
        }
        int len = arr.length;
        for (int i = 0; i < len; i++){
            boolean flag = true;
            for (int j = 0; j < len - i - 1; j++){
                if (arr[j + 1] < arr[j]){
                    flag = false;//有交换
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }

            }
            //一趟下来是否发生位置交换
            if(flag){
                break;
            }

        }
        return arr;
    }

//    2、选择排序
//    首先，找到数组中最小的那个元素，其次，将它和数组的第一个元素交换位置(如果第一个元素就是最小元素那么它就和自己交换)。
// 其次，在剩下的元素中找到最小的元素，将它与数组的第二个元素交换位置。如此往复，直到将整个数组排序。这种方法我们称之为选择排序。
//    性质：1、时间复杂度：O(n2) 2、空间复杂度：O(1) 3、非稳定排序 4、原地排序
    public int[] selectSort(int[] arr){
        if (arr == null || arr.length < 2){
            return arr;
        }
        int len = arr.length;
        for (int i = 0; i < len; i++){
            int min = i;
            for (int j = i + 1; j < len; j++){
                if (arr[min] > arr[j]){
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        return arr;
    }


//    3、插入排序
//    过程简单描述：
//1、从数组第2个元素开始抽取元素。
//2、把它与左边第一个元素比较，如果左边第一个元素比它大，则继续与左边第二个元素比较下去，直到遇到不比它大的元素，然后插到这个元素的右边。
//3、继续选取第3，4，....n个元素,重复步骤 2 ，选择适当的位置插入。
//    性质：1、时间复杂度：O(n2) 2、空间复杂度：O(1) 3、稳定排序 4、原地排序
    public int[] insertSort(int[] arr){
        if (null == arr || arr.length < 2){
            return arr;
        }
        int len = arr.length;
        for (int i = 1; i < len; i++){
            int temp = arr[i];
            int k = i - 1;
            while (k >= 0 && arr[k] > temp){
                k--;
            }
            //腾出位置插进去，要插的位置是k + 1
            for (int j = i; j > k+1; j--){
                arr[j] = arr[j - 1];
            }
            //插进去
            arr[k + 1] = temp;
        }

        return arr;
    }

//    4、希尔排序
//希尔排序可以说是插入排序的一种变种。无论是插入排序还是冒泡排序，如果数组的最大值刚好是在第一位，要将它挪到正确的位置就需要 n - 1 次移动。
// 也就是说，原数组的一个元素如果距离它正确的位置很远的话，则需要与相邻元素交换很多次才能到达正确的位置，这样是相对比较花时间了。
//希尔排序就是为了加快速度简单地改进了插入排序，交换不相邻的元素以对数组的局部进行排序。
//希尔排序的思想是采用插入排序的方法，先让数组中任意间隔为 h 的元素有序，刚开始 h 的大小可以是 h = n / 2,接着让 h = n / 4，让 h 一直缩小，
// 当 h = 1 时，也就是此时数组中任意间隔为1的元素有序，此时的数组就是有序的了。

//    需要注意的是，对各个分组进行插入的时候并不是先对一个组排序完了再来对另一个组排序，而是轮流对每个组进行排序。
//性质：1、时间复杂度：O(nlogn) 2、空间复杂度：O(1) 3、非稳定排序 4、原地排序
    public int[] shellSort(int[] arr){
        if (null == arr || arr.length < 2){
            return arr;
        }
        int len = arr.length;
//        对每组间隔为h的分组进行排序，刚开始h = len / 2;
        for (int h = len / 2; h > 0; h /=2){
//            对各个局部分组进行插入排序
            for (int i = h; i < len; i++){
//                将arr[i]插入到所在分组的正确位置上
                insertI(arr, h, i);
            }
        }


        return arr;
    }
//将arr[i]插入到所在分组的正确位置上，arr[i]所在的分组为...arr[i-2*h],arr[i-h],arr[i+h]...
    private void insertI(int[] arr, int h, int i) {
        int temp = arr[i];
        int k;
        for (k = i - h; k > 0 && temp < arr[k]; k -= h){
            arr[k + h] = arr[k];
        }
        arr[k + h] = temp;
    }


}
