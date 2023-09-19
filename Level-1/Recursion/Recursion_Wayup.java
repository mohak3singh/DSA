package Recursion;
// import java.util.ArrayList;

import java.util.ArrayList;
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

    public void permute(int[] nums,int count,List<List<Integer>> res,List<Integer> ans) {
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
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        
        permute(nums,0,res,ans);
        
        return res;
    }

    public static void main(String[] args) {
        String ans = "";

        // System.out.println(subSequenceWayUp("abc",ans));
        // System.out.println(nokiaKeysWayUp("245", ans));
        // System.out.println(stairsPathWayUp(5,ans));
        // System.out.println(boardPathWayUp(9,ans));
        
        // int[] arrJumps = {1,2,3};
        // System.out.println(boardPathInArrayWayUp(10,ans, arrJumps));

        System.out.println(mazePath_HVD(0,0,2,2,ans));
        // System.out.println(mazePath_MultiHVD(0, 0, 2, 2, ""));
        // System.out.println(permutation("aba", ""));
        // permutationWithoutDuplicate("abab");
        // System.out.println(decodeWays("112403",""));
    }
}
