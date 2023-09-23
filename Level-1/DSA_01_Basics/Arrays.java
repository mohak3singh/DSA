package DSA_01_Basics;

public class Arrays {

    public static void maxInArray(int[] arr){
        int maxEle = -(int)1e9;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > maxEle){
                maxEle = arr[i];
            }
        }
        System.out.println(maxEle);
    }

    public static void minInArray(int[] arr){
        int minEle = (int)1e9;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < minEle){
                minEle = arr[i];
            }
        }
        System.out.println(minEle);
    }

    public static void findInArray(int[] arr, int data){
        int index = -1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == data){
                index = i;
            }
        }
        System.out.println(index);
    }

    public static void spanOfArray(int[] arr){
         int maxEle = -(int)1e9;
         int minEle = (int)1e9;
        for(int i = 0; i < arr.length; i++){
            maxEle = Math.max(maxEle,arr[i]);
            minEle = Math.min(minEle, arr[i]);
        }
        System.out.println(maxEle - minEle);
    }

    public static int[] reverseOfArray(int[] arr,int i, int j){

        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return arr;
    }

    public static int[] inverseOfAnArray(int[] arr){
        int[] ans = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            int idx = arr[i];
            ans[idx] = i;
        }
        return ans;
    }

    public static int[] rotateOfArray(int[] arr, int r) {
        int n = arr.length;
        r %= n;
        if (r < 0)
            r += n;

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int idx = (i + r) % n;
            ans[idx] = arr[i];
        }
        return ans;
    }

    public static int[] rotateOfArray2(int[] arr, int r) {
        int n = arr.length;
        r %= n;
        if (r < 0)
            r += n;

        reverseOfArray(arr, 0, n - 1);
        reverseOfArray(arr, 0, r - 1);
        reverseOfArray(arr, r, n - 1);

        return arr;
    }

    public static void sumOfTwoArray(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int p = Math.max(n, m) + 1;
        int[] ans = new int[p];

        int i = n - 1, j = m - 1, k = p - 1, carry = 0;
        while (k >= 0) {
            int sum = carry + (i >= 0 ? arr1[i] : 0) + (j >= 0 ? arr2[j] : 0);
            ans[k] = sum % 10;
            carry = sum / 10;

            i--;
            j--;
            k--;
        }

        for (int idx = 0; idx < p; idx++) {
            if (idx == 0 && ans[idx] == 0)
                continue;
            System.out.print(ans[idx]);
        }

    }

    public static void subtractOfTwoArray(int[] arr1, int[] arr2) {

        int n = arr1.length;
        int m = arr2.length;
        int[] ans = new int[m];

        int i = n - 1, j = m - 1, k = m - 1;
        int borrow = 0;
        while (k >= 0) {
            int diff = borrow + arr2[j] - (i >= 0 ? arr1[i] : 0);
            if (diff < 0) {
                diff += 10;
                borrow = -1;
            } else {
                borrow = 0;
            }

            ans[k] = diff;

            i--;
            j--;
            k--;
        }

        boolean nonZeroFound = false;
        for (int ele : ans) {
            if (ele != 0) {
                nonZeroFound = true;
            }

            if (nonZeroFound)
                System.out.println(ele);
        }

    }

    public static void printInRange(int[] arr, int si, int ei) {
        while (si <= ei) {
            System.out.print(arr[si] + " ");
            si++;
        }
    }

    public static void printAllSubArrays(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                printInRange(arr, i, j);
            }
        }
    }

    public static int binarySearch(int[] arr, int data) {
        int si = 0, ei = arr.length - 1;
        while (si <= ei) {
            int mid = (si + ei) / 2;
            if (arr[mid] == data)
                return mid;
            else if (arr[mid] < data)
                si = mid + 1;
            else
                ei = mid - 1;
        }

        return -1;
    }

    public static int firstIndex(int[] arr, int data) {
        int si = 0, ei = arr.length - 1;
        while (si <= ei) {
            int mid = (si + ei) / 2;
            if (arr[mid] == data) {
                if (mid - 1 >= 0 && arr[mid - 1] == data)
                    ei = mid - 1;
                else
                    return mid;
            } else if (data < arr[mid])
                ei = mid - 1;
            else
                si = mid + 1;
        }

        return -1;
    }

    public static int lastIndex(int[] arr, int data) {
        int n = arr.length;
        int si = 0, ei = n - 1;
        while (si <= ei) {
            int mid = (si + ei) / 2;
            if (arr[mid] == data) {
                if (mid + 1 < n && arr[mid + 1] == data)
                    si = mid + 1;
                else
                    return mid;
            } else if (data < arr[mid])
                ei = mid - 1;
            else
                si = mid + 1;
        }

        return -1;
    }

    public static void FirstAndLastIdx(int[] arr, int data) {
        int fi = firstIndex(arr, data);
        if (fi == -1) {
            System.out.println("Data Not Found!");
            return;
        }

        int li = lastIndex(arr, data);

        System.out.println(fi);
        System.out.println(li);
    }

    public static void main(String[] args) {
        int[] arr = {3,4,0,1,2};

        // maxInArray(arr);
        // minInArray(arr);
        // findInArray(arr, 34);
        // spanOfArray(arr);

        // int i = 0;
        // int j = arr.length-1;
        // int[] ans = reverseOfArray(arr, i, j);
        // for(int e  :ans){
        //     System.out.print(e+" ");
        // }

        // int[] ans = inverseOfAnArray(arr);
        // for(int e:ans){
        //     System.out.print(e+" ");
        // }

        // int[] ans = rotateOfArray(arr,3);
        // for(int e:ans){
        //     System.out.print(e+" ");
        // }

        // int[] ans = rotateOfArray2(arr,3);
        //  for(int e:ans){
        //     System.out.print(e+" ");
        // }

        printAllSubArrays(arr);
    }
}
