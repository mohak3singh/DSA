import java.util.ArrayList;

public class Recursion_02 {

    public static ArrayList<String> getAllSubstrings(String str){
        if(str.length() == 0){
            ArrayList<String> base = new ArrayList<String>();
            base.add("");
            return base;
        }

        char ch = str.charAt(0);
        ArrayList<String> ans = new ArrayList<String>();
        ArrayList<String> recAns = getAllSubstrings(str.substring(1));
        for(String s:recAns){
            ans.add(s);
            ans.add(ch+s);
        }
        return ans;
    }
    
    public static void main(String[] args) {
        String str = "abc";
        System.out.println(getAllSubstrings(str));
    }
}
