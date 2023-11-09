package DSA_05_Time_and_Space;

import java.util.ArrayList;
import java.util.Random;

public class TimeAndSpace {

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] sort_01(int[] arr){
        int prev = -1, itr = 0;
        while(itr < arr.length){
            if(arr[itr] == 0){
                swap(arr, ++prev, itr);
            }
            itr++;
        }
        return arr;
    }

     public static int[] sort_012(int[] arr){
        int p1 = -1, itr = 0, p2 = arr.length-1;
        while(itr <= p2){
            if(arr[itr] == 0){
                swap(arr, ++p1, itr++);
            }else if(arr[itr] == 2){
                swap(arr, itr, p2--);
            }else{
                itr++;
            }
        }
        return arr;
    }

    public static int[] mergeTwoSortedArrays(int[] arr1, int[] arr2) {
        int i = 0, j = 0, k = 0;
        int n = arr1.length, m = arr2.length;
        int[] ans = new int[n + m];

        while (i < n && j < m) {
            if (arr1[i] < arr2[j])
                ans[k++] = arr1[i++];
            else
                ans[k++] = arr2[j++];
        }

        while (i < n)
            ans[k++] = arr1[i++];
        while (j < m)
            ans[k++] = arr2[j++];

        return ans;
    }

    public static int[] mergeTwoSortedArrays2(int[] arr1, int[] arr2) {
        int i = 0, j = 0, k = 0;
        int n = arr1.length, m = arr2.length;
        int len = n + m;
        int[] ans = new int[len];

        long val1 = 0, val2 = 0;
        while (k < len) {
            val1 = i < n ? arr1[i] : (long) 1e18;
            val2 = j < m ? arr2[j] : (long) 1e18;
            if (val1 < val2) {
                ans[k++] = (int) val1;
                i++;
            } else {
                ans[k++] = (int) val2;
                j++;
            }
        }

        return ans;
    }

    public static int[] mergeTwoSortedArrays3(int[] arr1, int[] arr2) {
        int i = 0, j = 0, k = 0;
        int n = arr1.length, m = arr2.length;
        int len = n + m;
        int[] ans = new int[n + m];

        while (k < len) {
            if (i == n)
                ans[k++] = arr2[j++];
            else if (j == m)
                ans[k++] = arr1[i++];
            else if (arr1[i] < arr2[j])
                ans[k++] = arr1[i++];
            else
                ans[k++] = arr2[j++];
        }

        return ans;
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int li = n - 1; li > 0; li--) {
            for (int i = 1; i <= li; i++)
                if (arr[i - 1] > arr[i])
                    swap(arr, i, i - 1);
        }
    }

    public static void bubbleSort_Opti(int[] arr) {
        int n = arr.length;

        for (int li = n - 1; li > 0; li--) {
            boolean isSwapDone = false;
            for (int i = 1; i <= li; i++) {
                if (arr[i - 1] > arr[i]) {
                    swap(arr, i, i - 1);
                    isSwapDone = true;
                }
            }

            if (!isSwapDone)
                break;
        }
    }

    public static int[] selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[i])
                    swap(arr, i, j);
            } 
        }
        return arr;
    }

    public static void selectionSort_portal(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[i])
                    minIdx = j;
            }
            swap(arr, i, minIdx);
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j - 1] > arr[j])
                    swap(arr, j - 1, j);
                else
                    break;
            }
        }
    }

    public static int PartitionAnArray(int[] arr, int data) {
        int n = arr.length, p = -1, itr = 0;
        while (itr < n) {
            if (arr[itr] <= data)
                swap(arr, itr, ++p);
            itr++;
        }

        return p;
    }

    public static int PartitionAnArray2(int[] arr, int data) {
        int n = arr.length, p = n - 1, itr = 0;
        while (itr <= p) {
            if (arr[itr] <= data)
                itr++;
            else
                swap(arr, p--, itr);
        }

        return p;
    }

    public static void PartitionOverPivot(int[] arr, int pivotIdx) {
        int n = arr.length;
        swap(arr, pivotIdx, n - 1);

        int itr = 0, p = -1, li = n - 1;
        while (itr < li) {
            if (arr[itr] <= arr[li])
                swap(arr, itr, ++p);

            itr++;
        }

        swap(arr, ++p, li);
    }

    // Quick sort
    public static Random rand = new Random();

    public static int partitionOverPivot(int[] arr, int si, int ei, int pIdx) {
        swap(arr, pIdx, ei);

        int p = si - 1, itr = si;
        while (itr <= ei) {
            if (arr[itr] <= arr[ei])
                swap(arr, itr, ++p);
            itr++;
        }

        return p;
    }

    public static void quickSort(int[] arr, int si, int ei) {
        if (si >= ei)
            return;

        int pIdx = ei; // rand.nextInt(ei - si + 1) + si
        int p = partitionOverPivot(arr, si, ei, pIdx);

        // int prev = si, idx = si;
        // while (idx <= ei && arr[prev] <= arr[idx]) {
        // prev = idx;
        // idx++;
        // }

        // if (idx == ei + 1)
        // return;

        quickSort(arr, si, p - 1);
        quickSort(arr, p + 1, ei);
    }

    // Find 3rd largest element
    public static int segregate(int[] arr, int pivot, int si, int ei) {
        swap(arr, pivot, ei);

        int p = si - 1, itr = si;

        while (itr <= ei) {
            if (arr[itr] <= arr[ei])
                swap(arr, ++p, itr);
            itr++;
        }

        return p;
    }

    public static void quickselect(int[] arr, int si, int ei, int idx) {
        if (si > ei)
            return;

        int pivot = ei;
        int pIdx = segregate(arr, pivot, si, ei);
        if (pIdx == idx)
            return;
        else if (idx > pIdx)
            quickselect(arr, pIdx + 1, ei, idx);
        else
            quickselect(arr, si, pIdx - 1, idx);
    }

    public static int quickselect(int[] arr, int k) {
        int n = arr.length, idx = n - k;
        quickselect(arr, 0, n - 1, idx);

        return arr[idx];
    }

    // Merge sort 
    public static int[] mergesort(int[] arr, int si, int ei) {
        if (si == ei) {
            return new int[] { arr[si] };
        }

        int mid = (si + ei) / 2;
        int[] left = mergesort(arr, si, mid);
        int[] right = mergesort(arr, mid + 1, ei);

        return mergeTwoSortedArrays(left, right);
    }


    // two sum or target sum
    public static void targetSumPair(int[] arr, int target) {
        int n = arr.length;
        quickSort(arr, 0, n - 1);  // Arrays.sort(arr);

        int si = 0, ei = n - 1;
        while (si < ei) {
            int sum = arr[si] + arr[ei];
            if (sum == target)
                System.out.println(arr[si++] + ", " + arr[ei--]);
            else if (sum < target)
                si++;
            else
                ei--;
        }
    }


    //threeSum
    // public static int segregate(int[] arr, int pivot, int si, int ei) {
    //     swap(arr, pivot, ei);
    //     int p = si - 1, itr = si;
    //     while (itr <= ei) {
    //         if (arr[itr] <= arr[ei])
    //             swap(arr, ++p, itr);
    //         itr++;
    //     }
    //     return p;
    // }

    // public static void quickSort(int[] arr, int si, int ei) {
    //     if (si > ei)
    //         return;

    //     int pivot = ei;
    //     int pIdx = segregate(arr, pivot, si, ei);
    //     quickSort(arr, si, pIdx - 1);
    //     quickSort(arr, pIdx + 1, ei);
    // }

    // int[] arr = {2,3,4,5,6};
    public static ArrayList<int[]> twoSum(int[] arr, int tar, int si, int ei) {
        ArrayList<int[]> ans = new ArrayList<>();
        while (si < ei) {
            int sum = arr[si] + arr[ei];
            if (sum == tar)
                ans.add(new int[] { arr[si++], arr[ei--] });
            else if (sum > tar)
                ei--;
            else
                si++;
        }

        return ans;
    }

     public static ArrayList<int[]> threeSum(int[] arr, int tar, int si, int ei) {
        ArrayList<int[]> ans = new ArrayList<>();
        for (int i = si; i <= ei; i++) {
            ArrayList<int[]> smallAns = twoSum(arr, tar - arr[i], i + 1, ei);

            for (int[] a : smallAns) {
                ans.add(new int[] { arr[i], a[0], a[1] });
            }
        }

        return ans;
    }

    public static void threeSum(int[] arr, int tar) {
        int n = arr.length;
        quickSort(arr, 0, n - 1);
        ArrayList<int[]> ans = threeSum(arr, tar, 0, n - 1);
        for (int[] a : ans) {
            System.out.println(a[0] + ", " + a[1] + ", " + a[2]);
        }
    }

    // count sort
public static void countSort_01(int[] arr) {
        int maxNum = -(int) 1e9;
        for (int ele : arr)
            maxNum = Math.max(maxNum, ele);

        int range = maxNum - 0 + 1;
        int[] freq = new int[range];
        for (int ele : arr)
            freq[ele]++;

        int idx = 0;
        for (int i = 0; i < range; i++) {
            while (freq[i]-- > 0) {
                arr[idx++] = i;
            }
        }
    }

    public static void countSort_02(int[] arr) {
        int maxNum = -(int) 1e9;
        int minNum = (int) 1e9;

        for (int ele : arr) {
            maxNum = Math.max(maxNum, ele);
            minNum = Math.min(minNum, ele);
        }

        int range = maxNum - minNum + 1;
        int[] freq = new int[range];
        for (int ele : arr)
            freq[ele - minNum]++;

        int idx = 0;
        for (int i = minNum; i <= maxNum; i++) {
            while (freq[i - minNum]-- > 0) {
                arr[idx++] = i;
            }
        }
    }

    public static void main(String[] args) {
        // int[] arr = {1,0,0,0,1,1,0,1,1,0,0};
        // int[] ans = sort_01(arr);
        // for(int a : ans){
        //     System.out.print(a);
        // }

        // int[] arr = {1,2,2,0,0,2,2,0,1,1,0,1,2,1,0,0,2};
        // int[] ans = sort_012(arr);
        // for(int a : ans){
        //     System.out.print(a);
        // }

        // int[] arr1 = {1,3,6,9,19,67,80};
        // int[] arr2 = {4,7,9,78,100};
        // int[] ans = mergeTwoSortedArrays(arr1, arr2);
        // for(int a : ans){
        //     System.out.print(a + " ");
        // }

        // int[] arr = {9,4,10,3,1,6,5};
        // int[] ans = selectionSort(arr);
        // for(int a : ans){
        //     System.out.print(a + " ");
        // }
        // PartitionAnArray(arr, 4);    

        int[] arr = { -12, 2, 7, 4, 34, 23, 0, 1, -1, -50, 16, 23, 7, 4, 2, 3 };
        quickSort(arr, 0, arr.length - 1);
        for (int ele : arr)
            System.out.print(ele + " ");

        //  int[] arr = { -12, 2, 7, 4, 34, 23, 0, 1, -1, -50, 16, 23, 7, 4, 2, 3 };
        // int k = 5;
        // System.out.println(quickselect(arr, k));

        // int[] arr = { -12, 2, 7, 4, 34, 23, 0, 1, -1, -50, 16, 23, 7, 4, 2, 3 };
        // arr = mergesort(arr, 0, arr.length - 1);
        // for (int ele : arr)
        //     System.out.print(ele + " ");
    }
}
