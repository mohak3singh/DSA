package DSA_03_2DArrays_Strings;

public class Basic_2d_array_string {

    public static void maxIn2DArray(int[][] arr){
        int maxEle = -(int)1e9;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                maxEle = Math.max(arr[i][j],maxEle);
            }
        }
        System.out.println(maxEle);
    }

    public static void minimum(int[][] arr) {
        int minValue = (int) 1e9;
        int n = arr.length, m = arr[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                minValue = Math.min(minValue, arr[i][j]);
            }
        }
        System.out.println(minValue);
    }

    public static boolean find(int[][] arr, int data) {
        boolean res = false;
        int n = arr.length, m = arr[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res = arr[i][j] == data;
                if (res)
                    return res;
            }
        }

        return res;
    }

    public static int firstIdx(int[] arr, int data) {
        int si = 0, ei = arr.length - 1;
        while(si <= ei){
            int mid = (si + ei)/2;
            if(arr[mid] == data){
                if(mid - 1 >= 0 && arr[mid - 1] == data){
                    ei = mid - 1;
                }else{
                    return mid;
                }
            }else if(data < arr[mid]){
                ei = mid - 1; 
            }else{
                si =  mid + 1;
            }
        }
        return -1;
    }

    public static int lastIdx(int[] arr, int data) {
        int si = 0, ei = arr.length - 1;
        while(si <= ei){
            int mid = (si + ei)/2;
            if(arr[mid] == data){
                if(mid + 1 < arr.length && arr[mid + 1] == data){
                    si = mid + 1;
                }else{
                    return mid;
                }
            }else if(data < arr[mid]){
                ei = mid - 1; 
            }else{
                si =  mid + 1;
            }
        }
        return -1;
    }

    public static void waveprint(int[][] arr){
        int n = arr.length, m = arr[0].length;
        for (int i = 0; i < n; i++) {
            if(i % 2 == 0){
                for (int j = 0; j < m; j++) {
                    System.out.print(arr[i][j] + " ");
                }
            }else{
                for (int j = m - 1; j >= 0; j--) {
                    System.out.print(arr[i][j] + " ");
                }
            }
        }
    }

    public static void waveprint2(int[][] arr){
        int n = arr.length, m = arr[0].length;
        for (int j = 0; j < m; j++) {
            if(j % 2 == 0){
                for (int i = 0; i < n; i++) {
                    System.out.print(arr[i][j] + " ");
                }
            }else{
                for (int i = n - 1; i >= 0; i--) {
                    System.out.print(arr[i][j] + " ");
                }
            }
        }
    }

    // Gap strategy IMP
    public static void diagonalPrint(int[][] arr){
        int n = arr.length, m = arr[0].length;
        for (int gap = 0; gap < m; gap++) {
            for (int i = 0, j = gap; i < n && j < m; i++, j++) {
                System.out.println(arr[i][j]);
            }
        }
    }

    public static void FulldiagonalPrint(int[][] arr) {
        int n = arr.length, m = arr[0].length;
        for (int gap = n - 1; gap >= 1; gap--) {
            for (int i = gap, j = 0; i < n && j < m; i++, j++) {
                System.out.println(arr[i][j]);
            }
        }

        for (int gap = 0; gap < m; gap++) {
            for (int i = 0, j = gap; i < n && j < m; i++, j++) {
                System.out.println(arr[i][j]);
            }
        }
    }

    public static void spiralPrint(int[][] arr) {
        int n = arr.length, m = arr[0].length;
        int rmin = 0, rmax = n - 1;
        int cmin = 0, cmax = m - 1;
        int tnel = n * m;

        while (tnel > 0) {
            for (int r = rmin; r <= rmax && tnel > 0; r++) {
                System.out.println(arr[r][cmin]);
                tnel--;
            }
            cmin++;

            for (int c = cmin; c <= cmax && tnel > 0; c++) {
                System.out.println(arr[rmax][c]);
                tnel--;
            }
            rmax--;

            for (int r = rmax; r >= rmin && tnel > 0; r--) {
                System.out.println(arr[r][cmax]);
                tnel--;
            }
            cmax--;

            for (int c = cmax; c >= cmin && tnel > 0; c--) {
                System.out.println(arr[rmin][c]);
                tnel--;
            }
            rmin++;
        }
    }

    public static void exitPoint(int[][] arr) {
        int n = arr.length, m = arr[0].length;
        int dir = 0;
        int i = 0, j = 0;
        while (true) {
            dir = (dir + arr[i][j]) % 4;
            if (dir == 0) { // North
                j++;
                if (j == m) {
                    System.out.println(i + "\n" + (j - 1));
                    break;
                }
            } else if (dir == 1) { // East
                i++;
                if (i == n) {
                    System.out.println((i - 1) + "\n" + (j));
                    break;
                }
            } else if (dir == 2) { // South
                j--;
                if (j == -1) {
                    System.out.println((i) + "\n" + (j + 1));
                    break;
                }
            } else { // West
                i--;
                if (i == -1) {
                    System.out.println((i + 1) + "\n" + (j));
                    break;
                }
            }
        }
    }

    public static void swap(int[][] arr, int i1, int j1, int i2, int j2) {
        int temp = arr[i1][j1];
        arr[i1][j1] = arr[i2][j2];
        arr[i2][j2] = temp;
    }

    public static void rotate90(int[][] arr) {
        int n = arr.length, m = arr[0].length;
        // Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i; j < m; j++) {
                swap(arr, i, j, j, i);
            }
        }

        // column shifting
        int si = 0, ei = m - 1;
        while (si < ei) {
            for (int i = 0; i < n; i++) {
                swap(arr, i, si, i, ei);
            }
            si++;
            ei--;
        }
    }

    public static int maxInCol(int[][] arr, int c) {
        int maxVal = -(int) 1e9;
        int r = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][c] > maxVal) {
                maxVal = arr[i][c];
                r = i;
            }
        }

        return r;
    }

    // min in  row and max in col
    public static void saddlePoint(int[][] arr) {
        int n = arr.length, m = arr[0].length;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            // find min in row
            int minVal = (int) 1e9;
            int c = -1;
            for (int j = 0; j < m; j++) {
                if (arr[i][j] < minVal) {
                    minVal = arr[i][j];
                    c = j;
                }
            }

            int r = maxInCol(arr, c);

            if (r == i) {
                System.out.println(arr[r][c]);
                flag = true;
            }
        }

        if (!flag)
            System.out.println("Invalid input");
    }

    public static boolean isPlaindrome(String str, int si, int ei) {
        while (si < ei) {
            if (str.charAt(si) != str.charAt(ei))
                return false;
            si++;
            ei--;
        }

        return true;
    }

    public static void printAllPalindromicSubString(String str) {
        int n = str.length();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPlaindrome(str, i, j)) {
                    String s = str.substring(i, j + 1);
                    System.out.println(s);
                }
            }
        }
    }

    public static void removeDuplicates(String str) {
        if (str.length() == 0)
            return;

        int n = str.length();
        String ans = str.charAt(0) + "";

        int i = 1;
        while (i < n) {
            while (i < n && ans.charAt(ans.length() - 1) == str.charAt(i))
                i++;
            if (i < n)
                ans += str.charAt(i);
            i++;
        }

        System.out.println(ans);
    }

    public static void removeDuplicatesInsertCount(String str) {
        if (str.length() == 0)
            return;

        int n = str.length();
        String ans = str.charAt(0) + "";

        int i = 1;
        int changes = 0, count = 0;

        while (i < n) {
            count = 1;
            while (i < n && ans.charAt(ans.length() - 1) == str.charAt(i)) {
                i++;
                count++;
            }

            changes++;
            if (count > 1)
                ans += count;
            if (i < n)
                ans += str.charAt(i);
            i++;
        }

        System.out.println(ans);
        System.out.println(changes);
    }

    public static int countOfHi(String str) {
        int n = str.length();
        int i = 0, count = 0;
        while (i < n - 1) {
            if (str.charAt(i) == 'h' && str.charAt(i + 1) == 'i') {
                count++;
                i += 2;
            } else
                i++;
        }
        return count;
    }

    public static int countHiWithoutHit(String str) {
        int n = str.length();
        int i = 0, count = 0;
        while (i < n - 1) {
            if (str.charAt(i) == 'h' && str.charAt(i + 1) == 'i') {
                if (i + 2 < n && str.charAt(i + 2) == 't') {
                    i += 3;
                } else {
                    count++;
                    i += 2;
                }
            } else
                i++;
        }

        return count;
    }

    // String immutable test
    public static void stringImmutableTest() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i <= (int) 1e6; i++) {
            str.append(i);
        }

        // System.out.println(str);
    }

    // String Builder Basic Functions.
    public static void stringBuilderBasicFunction() {
        StringBuilder sb = new StringBuilder();
        sb.append("a"); //
        sb.append("bcd"); // O(m), where m is length of string which i want to append.
        System.out.println(sb.toString()); // O(n)
        sb.setCharAt(2, 'e'); // O(1)
        System.out.println(sb.toString()); // O(n)
        sb.deleteCharAt(2); // O(n)
        System.out.println(sb.toString());
    }

    // Toggle Case
    public static String toggleCase(String str) {
        StringBuilder sb = new StringBuilder();
        int n = str.length();
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z')
                sb.append((char) (ch - 'a' + 'A'));
            else
                sb.append((char) (ch - 'A' + 'a'));
        }
        return sb.toString();
    }

    public static String asciiDifference(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));
        int n = str.length();
        for (int i = 1; i < n; i++) {
            sb.append(str.charAt(i) - str.charAt(i - 1));
            sb.append(str.charAt(i));
        }

        return sb.toString();
    }
    
    public static void main(String[] args) {
        int[][] arr = {{22,3,55},
                       {20,9,100},
                       {28,1,68}};

        // int[][] arr1 = {{0,0,1},
        //                 {0,1,0},
        //                 {0,1,1}};

        // maxIn2DArray(arr);
        // minimum(arr);
        // waveprint(arr);
        // waveprint2(arr);
        // diagonalPrint(arr);
        // spiralPrint(arr);
        // exitPoint(arr1);
        saddlePoint(arr);

        // removeDuplicates("aaabbcccddddaaaa");
    }
}
