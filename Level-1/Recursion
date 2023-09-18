import java.util.Scanner;

class Recursion_01{

    public static int factorial(int n){
        return n == 0 ? 1 : factorial(n - 1) * n;
    }

    public static int power(int a, int b){
        if(b == 0){
            return 1;
        }
        int recAns = power(a, b/2);
        recAns = recAns * recAns;

        return b % 2 == 0 ? recAns : recAns*a;
    } 

    public static void printArray(int[] arr, int idx){
        if(idx == arr.length){
            return;
        }
        System.out.println(arr[idx]);
        printArray(arr,idx + 1);
    }

     public static int maxInArr(int[] arr, int idx){
        if(idx == arr.length){
            return -(int)1e9;
        }
        
        int recAns = maxInArr(arr,idx + 1);
        return Math.max(recAns, arr[idx]);
    }

    public static int minInArr(int[] arr, int idx){
        if(idx == arr.length){
            return (int)1e9;
        }
        
        int recAns = minInArr(arr,idx + 1);
        return Math.min(recAns, arr[idx]);
    }

    public static boolean findInArr(int[] arr, int idx, int data){
        if(idx == arr.length){
            return false;
        }
        if(data == arr[idx]){
            return true;
        }
        return findInArr(arr,idx + 1,data);
    }

    //another way to find in array
    public static boolean findInArr2(int[] arr, int idx, int data){
        if(idx == arr.length){
            return false;
        }
        boolean recAns = findInArr(arr,idx + 1,data);
        if(recAns){
            return true;
        }
        return data == arr[idx];
    }

    public static int getFirstIdx(int[] arr, int idx, int data){
        if(idx == arr.length){
            return -1;
        }
        if(data == arr[idx]){
            return idx;
        }
        return getFirstIdx(arr, idx + 1, data);
    }

    public static int getLastIdx(int[] arr, int idx, int data){
        if(idx == arr.length){
            return -1;
        }
        int recAns = getLastIdx(arr, idx + 1, data);
        if(recAns != -1){
            return recAns;
        }
        return arr[idx] == data? idx: -1; 
    }

    public static int[] getAllIdxOfData(int[] arr,int idx, int data, int count){
        if(idx == arr.length){
            return new int[count];
        }
        if(arr[idx] == data){
            count++;
        }
        int[] recAns = getAllIdxOfData(arr,idx + 1,data,count);
        if(arr[idx] == data){
            recAns[count - 1] = idx;
        }
        return recAns;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        //int n = scn.nextInt();

        // int recAns = factorial(n);
        // System.out.println(recAns);

        // int a = scn.nextInt();
        // int b = scn.nextInt();
        // System.out.println(power(a,b));

        int[] arr = {2,5,5,6,82,2,1,6,2,6,7};
        // printArray(arr, 0);
        //System.out.println( maxInArr(arr, 0));
        //System.out.println( minInArr(arr, 0));

        // System.out.println(findInArr(arr, 0, 19));
        // System.out.println(findInArr2(arr, 0, 1));

        // System.out.println(getFirstIdx(arr,0, 5));
        // System.out.println(getLastIdx(arr,0, 6));
        int[] ans = getAllIdxOfData(arr,0, 2, 0);
        for(int e:ans){
            System.out.println(e);
        }

        scn.close();
    }
}


