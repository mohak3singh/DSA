package DSA_04_Recursion;
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

    public static ArrayList<String> decodeTheGivenNumber(String str){
        if(str.length() == 0){
            ArrayList<String> base = new ArrayList<String>();
            base.add("");
            return base;
        }

        char ch1 = str.charAt(0);
        ArrayList<String> recAns1 = decodeTheGivenNumber(str.substring(1));
        ArrayList<String> ans = new ArrayList<String>();
        for(String s:recAns1){
            ans.add((char)('a'+ ch1 - '1') + s);
        }

        if(str.length() > 1){
            int num2 = (ch1 - '0') * 10 + (str.charAt(1) - '0');
            if(num2 <= 26){
                ArrayList<String> recAns2 = decodeTheGivenNumber(str.substring(2));
                for(String s : recAns2){
                    ans.add((char)('a'+ num2 - 1)+s);
                }
            } 
        }
        return ans;
    }

    public static ArrayList<String> decodeTheGivenNokiaKeyNumber(String str){
        if(str.length() == 0){
            ArrayList<String> base = new ArrayList<String>();
            base.add("");
            return base;
        }

        char ch1 = str.charAt(0);
        String code = nokiaKeys[ch1 - '0'];
        ArrayList<String> recAns1 = decodeTheGivenNokiaKeyNumber(str.substring(1));
        ArrayList<String> ans = new ArrayList<String>();
        for(int i = 0; i < code.length(); i++){
            for(String s:recAns1){
                ans.add((char)code.charAt(i) + s);
            }
        }   

        if(str.length() > 1){
            int num = (ch1 - '0') * 10 + (str.charAt(1) - '0');
            if(num == 10 || num == 11){
                ArrayList<String> recAns2 = decodeTheGivenNokiaKeyNumber(str.substring(2));
                for(int i = 0; i < code.length(); i++){
                    for(String s:recAns2){
                        ans.add((char)code.charAt(i) + s);
                    }
                }   
            } 
        }
        return ans;
    }

    public static ArrayList<String> countAllStairsPath(int n){
        if(n == 0){
            ArrayList<String> base = new ArrayList<String>();
            base.add("");
            return base;
        }

        ArrayList<String> ans = new ArrayList<>();
        for(int jump = 1; jump <= 3 && n - jump >= 0; jump++){
            ArrayList<String> recAns = countAllStairsPath(n - jump);
            for(String e : recAns){
                ans.add(e + jump);
            }
        }
        return ans;
    }

    public static ArrayList<String> countAllBoardPath(int n){
        if(n == 0){
            ArrayList<String> base = new ArrayList<String>();
            base.add("");
            return base;
        }

        ArrayList<String> ans = new ArrayList<>();
        for(int jump = 1; jump <= 6 && n - jump >= 0; jump++){
            ArrayList<String> recAns = countAllBoardPath(n - jump);
            for(String e : recAns){
                ans.add(e + jump);
            }
        }
        return ans;
    }

    public static ArrayList<String> countAllBoardPathOnArray(int n, int[] arrBoardPath){
        if(n == 0){
            ArrayList<String> base = new ArrayList<String>();
            base.add("");
            return base;
        }

        ArrayList<String> ans = new ArrayList<>();
        for(int i = 0; i < arrBoardPath.length && n - arrBoardPath[i] >= 0; i++){
            ArrayList<String> recAns = countAllBoardPathOnArray(n - arrBoardPath[i], arrBoardPath);
            for(String e : recAns){
                ans.add(e + arrBoardPath[i]);
            }
        }
        return ans;
    }

    public static ArrayList<String> mazePathHV(int sr, int sc, int er, int ec){
        if(sr == er && sc == ec){
            ArrayList<String> base = new ArrayList<String>();
            base.add("");
            return base;
        }

        ArrayList<String> ans = new ArrayList<>();
        if(sr <= er){
            ArrayList<String> recAnsH = mazePathHV(sr, sc + 1, er, ec);
            for(String i : recAnsH){
                ans.add(i + "H");
            }
        }

        if(sc <= ec){
            ArrayList<String> recAnsV = mazePathHV(sr + 1, sc, er, ec);
            for(String i : recAnsV){
                ans.add(i + "V");
            }
        }
        return ans;
    }

    public static ArrayList<String> mazePathHDV(int sr, int sc, int er, int ec){
        if(sr == er && sc == ec){
            ArrayList<String> base = new ArrayList<String>();
            base.add("");
            return base;
        }

        ArrayList<String> ans = new ArrayList<>();
        if(sr <= er){
            ArrayList<String> recAnsH = mazePathHDV(sr, sc + 1, er, ec);
            for(String i : recAnsH){
                ans.add(i + "H");
            }
        }

        if(sr <= er && sc <= ec){
            ArrayList<String> recAnsD = mazePathHDV(sr + 1, sc + 1, er, ec);
            for(String i : recAnsD){
                ans.add(i + "D");    
            }
        }

        if(sc <= ec){
            ArrayList<String> recAnsV = mazePathHDV(sr + 1, sc, er, ec);
            for(String i : recAnsV){
                ans.add(i + "V");
            }
        }
        return ans;
    }
    
    public static ArrayList<String> mazePathInfiniteCalls(int sr, int sc, int er, int ec){
        if(sr == er && sc == ec){
            ArrayList<String> base = new ArrayList<String>();
            base.add("");
            return base;
        }

        ArrayList<String> ans = new ArrayList<>();
        for(int jump = 1; sc + jump <= ec; jump++){
            ArrayList<String> recAnsH = mazePathInfiniteCalls(sr, sc + jump, er, ec);
            for(String i : recAnsH){
                ans.add(i + "H" + jump);
            }
        }

        for(int jump = 1; sr + jump <= er && sc + jump <= ec; jump++){
            ArrayList<String> recAnsD = mazePathInfiniteCalls(sr + jump, sc + jump, er, ec);
            for(String i : recAnsD){
                ans.add(i + "D" + jump);    
            }
        }

        for(int jump = 1; sr + jump <= er; jump++){
            ArrayList<String> recAnsV = mazePathInfiniteCalls(sr + jump, sc, er, ec);
            for(String i : recAnsV){
                ans.add(i + "V" + jump);
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        // String str = "abckl";

        // System.out.println(getAllSubstrings(str));
        // System.out.println(getAllNokiaKeysCombinations("456"));
        // System.out.println(decodeTheGivenNumber("11284"));
        // System.out.println(decodeTheGivenNokiaKeyNumber("110"));
        // System.out.println(countAllStairsPath(3));
        // System.out.println(countAllBoardPath(6));

        // int[] arrBoardPath = {2,4,5};
        // System.out.println(countAllBoardPathOnArray(10,arrBoardPath));

        // System.out.println(mazePathHV(0,0,2,2));
        // System.out.println(mazePathHDV(0,0,2,2));
        System.out.println(mazePathInfiniteCalls(0,0,2,2));
    }
}
