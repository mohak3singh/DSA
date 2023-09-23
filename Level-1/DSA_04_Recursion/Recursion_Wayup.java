package DSA_04_Recursion;

import java.util.ArrayList;
// import java.util.Arrays;
import java.util.List;

public class Recursion_Wayup {
    
    public static int subSequenceWayUp(String str, String ans){
        if(str.length() == 0){
            System.out.println(ans);
            return 1;
        }
        char ch = str.charAt(0);
        String roq = str.substring(1);
        int count = 0;
        count += subSequenceWayUp(roq, ans);
        count += subSequenceWayUp(roq, ans + ch);
        return count;
    }

    public static String[] nokiaKeys = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};

    public static int nokiaKeysWayUp(String str, String ans){
        if(str.length() == 0){
            System.out.println(ans);
            return 1;
        }
        char ch = str.charAt(0);
        String word = nokiaKeys[ch - '0'];
        int count = 0;
        for(int i = 0 ; i< word.length(); i++){
            count += nokiaKeysWayUp(str.substring(1), ans + word.charAt(i));
        }
        return count;
    }

    public static int stairsPathWayUp(int n, String ans){
        if(n == 0){
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        for(int i = 1; i <= 3 && n - i >= 0; i++){
            count += stairsPathWayUp(n - i, ans + i);
        }
        return count;
    }
    
    public static int boardPathWayUp(int n, String ans){
        if(n == 0){
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        for(int i = 1; i <= 6 && n - i >= 0; i++){
            count += boardPathWayUp(n - i, ans + i);
        }
        return count;
    }

    public static int boardPathInArrayWayUp(int n, String ans, int[] arrJumps){
        if(n == 0){
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        for(int jump : arrJumps){
            if(n - jump >= 0){
                count += boardPathInArrayWayUp(n - jump, ans + jump, arrJumps);
            }
        }
        return count;
    }

    public static int mazePath_HVD(int sr, int sc, int er, int ec, String ans) {
        if (sr == er && sc == ec) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        if (sc + 1 <= ec && sr + 0 <= er)
            count += mazePath_HVD(sr + 0, sc + 1, er, ec, ans + "H");
        if (sc + 1 <= ec && sr + 1 <= er)
            count += mazePath_HVD(sr + 1, sc + 1, er, ec, ans + "D");
        if (sr + 1 <= er)
            count += mazePath_HVD(sr + 1, sc + 0, er, ec, ans + "V");

        return count;
    }

    public static int mazePath_MultiHVD(int sr, int sc, int er, int ec, String ans) {
        if (sr == er && sc == ec) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for (int jump = 1; sc + jump <= ec; jump++)
            count += mazePath_MultiHVD(sr, sc + jump, er, ec, ans + "H" + jump);
        for (int jump = 1; sc + jump <= ec && sr + jump <= er; jump++)
            count += mazePath_MultiHVD(sr + jump, sc + jump, er, ec, ans + "D" + jump);
        for (int jump = 1; sr + jump <= er; jump++)
            count += mazePath_MultiHVD(sr + jump, sc, er, ec, ans + "V" + jump);

        return count;
    }

    public static int permutation(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            String ros = str.substring(0, i) + str.substring(i + 1);
            count += permutation(ros, ans + str.charAt(i));
        }

        return count;
    }

    public static int permutationWithoutDuplicate(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        char prev = '$';
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != prev) {
                String ros = str.substring(0, i) + str.substring(i + 1);
                count += permutationWithoutDuplicate(ros, ans + str.charAt(i));
            }
            prev = str.charAt(i);
        }

        return count;

    }

    public static void permutationWithoutDuplicate(String str) {
        StringBuilder sb = new StringBuilder();
        int[] freq = new int[26];
        for (int i = 0; i < str.length(); i++)
            freq[str.charAt(i) - 'a']++;

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < freq[i]; j++) {
                sb.append((char) (i + 'a'));
            }
        }

        // System.out.println(sb);
        System.out.println(permutationWithoutDuplicate(sb.toString(), ""));
    }

    public static int decodeWays(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        char ch = str.charAt(0);
        if (ch == '0')
            return 0;

        count += decodeWays(str.substring(1), ans + (char) ('a' + ch - '1'));
        if (str.length() > 1) {
            int num = (ch - '0') * 10 + (str.charAt(1) - '0');
            if (num <= 26)
                count += decodeWays(str.substring(2), ans + (char) ('a' + num - 1));
        }

        return count;
    }

    public static void permute(int[] nums,int count,List<List<Integer>> res,List<Integer> ans) {
        if(count == nums.length){
            List<Integer> base = new ArrayList<>();
            for(int ele : ans) base.add(ele);
            res.add(base);
            return; 
        }
        
        for(int i=0;i<nums.length;i++){
            
            if(nums[i]>= -10 && nums[i] <= 10){
                int val = nums[i];
                
                nums[i] = -11;
                ans.add(val);
                
                permute(nums,count + 1,res,ans);
                
                ans.remove(ans.size() - 1);
                nums[i] = val;
            }
        }
        
    }
    
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        
        permute(nums,0,res,ans);
        
        return res;
    }

    public static void permuteWithoutDuplicateSol(int[] nums,int count,List<List<Integer>> res,List<Integer> ans) {
        if(count == nums.length){
            List<Integer> base = new ArrayList<>();
            for(int ele : ans) base.add(ele);
            res.add(base);
            return; 
        }
        
        int prev = -100;
        for(int i=0;i<nums.length;i++){
            
            if(nums[i]>= -10 && nums[i] <= 10 && nums[i] != prev){
                int val = nums[i];
                
                nums[i] = -11;
                ans.add(val);
                
                permuteWithoutDuplicateSol(nums,count + 1,res,ans);
                
                ans.remove(ans.size() - 1);
                nums[i] = val;
            }
            prev = nums[i];
        }
    }
    
    public static List<List<Integer>> permuteWithoutDuplicate(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        
        permuteWithoutDuplicateSol(nums,0,res,ans);
        
        return res;
    }

    public static int mazePath_HDV_using_Dir(int sr, int sc, int er, int ec, String ans, int[][] dir, String[] dirS){
        if(sr == er && sc == ec){
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for(int d = 0; d < dirS.length; d++){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            
            if(r >= 0 && c >= 0 && r <= er && c <= ec){
                count += mazePath_HDV_using_Dir(r, c, er, ec, ans + dirS[d], dir, dirS);
            }
        }
        return count;
    }

    // 1 -> blocked cell , 0 -> empty cell
    public static int floodFill(int sr, int sc, int[][] board, String ans, int[][] dir, String[] dirS){
        if(sr == board.length - 1 && sc == board[0].length - 1){
            System.out.println(ans);
            return 1;
        }

        board[sr][sc] = 1;
        int count = 0;
        for(int d = 0; d < dirS.length; d++){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            
            if(r >= 0 && c >= 0 && r < board.length && c < board[0].length && board[r][c] == 0){
                count += floodFill(r, c, board, ans + dirS[d], dir, dirS);
            }
        }
        board[sr][sc] = 0;
        return count;
    }

    // 1 -> blocked cell , 0 -> empty cell
    public static int floodFillfor8Dir(int sr, int sc, int[][] board, String ans, int[][] dir, String[] dirS){
        if(sr == board.length - 1 && sc == board[0].length - 1){
            System.out.println(ans);
            return 1;
        }

        board[sr][sc] = 1;
        int count = 0;
        for(int d = 0; d < dirS.length; d++){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            
            if(r >= 0 && c >= 0 && r < board.length && c < board[0].length && board[r][c] == 0){
                count += floodFillfor8Dir(r, c, board, ans + dirS[d], dir, dirS);
            }
        }
        board[sr][sc] = 0;
        return count;
    }

    // 0 -> empty cell, 1 -> blocked cell
    public static int floodFill_Jump(int sr, int sc, int[][] board, String ans, int[][] dir, String[] dirS,
            int Radius) {
        int n = board.length, m = board[0].length;
        if (sr == n - 1 && sc == m - 1) {
            System.out.println(ans);
            return 1;
        }

        board[sr][sc] = 1;

        int count = 0;

        for (int d = 0; d < dir.length; d++) {
            for (int rad = 1; rad <= Radius; rad++) {
                int r = sr + rad * dir[d][0];
                int c = sc + rad * dir[d][1];

                if (r >= 0 && c >= 0 && r < board.length && c < board[0].length) {
                    if (board[r][c] == 0)
                        count += floodFill_Jump(r, c, board, ans + rad + dirS[d], dir, dirS, Radius);
                } else
                    break;
            }
        }

        board[sr][sc] = 0;
        return count;
    }

    // https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1#
    public static int ratInAMaze(int sr, int sc, int[][] arr, String ans, int[][] dir, String[] dirS, ArrayList<String> res) {

        int n = arr.length, m = arr[0].length;
        if (sr == n - 1 && sc == m - 1) {
            res.add(ans);
            return 1;
        }

        arr[sr][sc] = 0; // block
        int count = 0;
        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if (r >= 0 && c >= 0 && r < n && c < m && arr[r][c] == 1) {
                count += ratInAMaze(r, c, arr, ans + dirS[d], dir, dirS, res);
            }
        }

        arr[sr][sc] = 1; // free
        return count;
    }

    // To get only one path
    public static boolean floodFill_2(int sr, int sc, int[][] board, String ans, int[][] dir, String[] dirS) {
        int n = board.length, m = board[0].length;
        if (sr == n - 1 && sc == m - 1) {
            System.out.println(ans);
            return true;
        }

        board[sr][sc] = 1;

        boolean res = false;
        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if (r >= 0 && c >= 0 && r < board.length && c < board[0].length) {
                if (board[r][c] == 0)
                    res = res || floodFill_2(r, c, board, ans + dirS[d], dir, dirS);
            }
        }

        board[sr][sc] = 0;
        return res;
    }

     // https://www.geeksforgeeks.org/count-number-ways-reach-destination-maze/
     double mod = 1e9 + 7;
     public double floodFill(int sr, int sc, int[][] arr, int[][] dir) {
 
         int n = arr.length, m = arr[0].length;
         if (sr == n - 1 && sc == m - 1) {
             return 1;
         }
 
         arr[sr][sc] = 1; // block
         double count = 0;
         for (int d = 0; d < dir.length; d++) {
             int r = sr + dir[d][0];
             int c = sc + dir[d][1];
 
             if (r >= 0 && c >= 0 && r < n && c < m && arr[r][c] == 0) {
                 count = (count % mod + floodFill(r, c, arr, dir) % mod) % mod;
             }
         }
 
         arr[sr][sc] = 0; // free
         return count;
     }
 
     public double FindWays(int n, int m, int[][] blocked_cells) {
         int[][] arr = new int[n][m];
         for (int[] cell : blocked_cells) {
             int i = cell[0] - 1;
             int j = cell[1] - 1;
 
             arr[i][j] = 1;
         }
 
         if (arr[n - 1][m - 1] == 1 || arr[0][0] == 1)
             return 0;
 
         int[][] dir = { { 0, 1 }, { 1, 0 } };
         double count = floodFill(0, 0, arr, dir);
         return count;
     }

    public static int floodFill_longestLen(int sr, int sc, int[][] board, int[][] dir) {
        int n = board.length, m = board[0].length;
        if (sr == n - 1 && sc == m - 1) {
            return 0;
        }

        board[sr][sc] = 1;   
        int longestLen = -1;
        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if (r >= 0 && c >= 0 && r < board.length && c < board[0].length) {
                if (board[r][c] == 0) {
                    int recAns = floodFill_longestLen(r, c, board, dir);
                    if (recAns != -1 && recAns + 1 > longestLen) {
                        longestLen = recAns + 1;
                    }
                }
            }
        }
        board[sr][sc] = 0;
        return longestLen;
    }

    public static int floodFill_shortestLen(int sr, int sc, int[][] board, int[][] dir) {
        int n = board.length, m = board[0].length;
        if (sr == n - 1 && sc == m - 1) {
            return 0;
        }

        board[sr][sc] = 1;

        int shortestLen = (int) 1e9;
        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if (r >= 0 && c >= 0 && r < board.length && c < board[0].length) {
                if (board[r][c] == 0) {
                    int recAns = floodFill_shortestLen(r, c, board, dir);
                    if (recAns != (int) 1e9 && recAns + 1 < shortestLen) {
                        shortestLen = recAns + 1;
                    }
                }
            }
        }

        board[sr][sc] = 0;
        return shortestLen;
    }

    // Knight Tour
    public static boolean knightTour(int sr, int sc, int[][] board, int move, int[] dirX, int[] dirY) {
        board[sr][sc] = move; // block

        if (move == 63) {
            return true;
        }

        boolean res = false;
        for (int d = 0; d < 8; d++) {
            int r = sr + dirX[d];
            int c = sc + dirY[d];

            if (r >= 0 && c >= 0 && r < board.length && c < board[0].length && board[r][c] == -1) {
                res = res || knightTour(r, c, board, move + 1, dirX, dirY);
                if (res)
                    return res;

            }
        }

        board[sr][sc] = -1; // free
        return res;
    }

    public static void knightTour() {
        int n = 8;
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = -1;

        int[] dirX = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int[] dirY = { 1, 2, 2, 1, -1, -2, -2, -1 };
        knightTour(0, 0, board, 0, dirX, dirY);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }

    }

    public static void main(String[] args) {
        // String ans = "";

        // System.out.println(subSequenceWayUp("abc",ans));
        // System.out.println(nokiaKeysWayUp("245", ans));
        // System.out.println(stairsPathWayUp(5,ans));
        // System.out.println(boardPathWayUp(9,ans));
        
        // int[] arrJumps = {1,2,3};
        // System.out.println(boardPathInArrayWayUp(10,ans, arrJumps));

        // System.out.println(mazePath_HVD(0,0,2,2,ans));
        // System.out.println(mazePath_MultiHVD(0, 0, 2, 2, ""));
        // System.out.println(permutation("aba", ""));
        // permutationWithoutDuplicate("abab");
        // System.out.println(decodeWays("11243",""));

        // int[] nums = {3,3,0,3};
        // System.out.println(permute(nums));
        // Arrays.sort(nums);
        // System.out.println(permuteWithoutDuplicate(nums));
        
        // String[] dirS = {"H","D","V"};
        // int[][] dir = {{0,1},{1,1},{1,0}};
        // System.out.println(mazePath_HDV_using_Dir(0,0,2,2,ans, dir, dirS));

        // String[] dirS = {"t","r","d","l"};
        // int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
        // int[][] board = new int[3][3];
        // System.out.println(floodFill(0, 0, board, "", dir, dirS));

        //flood fill 8 directions
        // String[] dirS8 = {"t","r","d","l","n","w","s","e"};
        // int[][] dir8 = {{-1,0},{0,1},{1,0},{0,-1},{-1,-1},{-1,1},{1,1},{1,-1}};
        // int[][] board = new int[3][3];
        // System.out.println(floodFillfor8Dir(0, 0, board, "", dir8, dirS8));

        // String[] dirS8 = {"t","r","d","l","n","w","s","e"};
        // int[][] dir8 = {{-1,0},{0,1},{1,0},{0,-1},{-1,-1},{-1,1},{1,1},{1,-1}};
        // int[][] board = new int[3][3];
        // System.out.println(floodFill_Jump(0, 0, board, "", dir8, dirS8, 5));

        // int[][] board = new int[3][3];
        // int[][] dir4 = {{-1,0},{0,1},{1,0},{0,-1}};
        // System.out.println(floodFill_longestLen(0, 0, board, dir4));

        knightTour();
    }
}
