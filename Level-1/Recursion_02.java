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

    public static String[] nokiaKeys = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};

    public static ArrayList<String> getAllNokiaKeysCombinations(String str){
        if(str.length() == 0){
            ArrayList<String> base = new ArrayList<String>();
            base.add("");
            return base;
        }

        char ch = str.charAt(0);
        String code = nokiaKeys[ch - '0'];
        ArrayList<String> ans = new ArrayList<String>();
        ArrayList<String> recAns = getAllNokiaKeysCombinations(str.substring(1));
        for(int i = 0; i < code.length(); i++){
            for(String s:recAns){
                ans.add(code.charAt(i)+s);
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        String str = "abckl";

        // System.out.println(getAllSubstrings(str));
        System.out.println(getAllNokiaKeysCombinations("456"));
    }
}
