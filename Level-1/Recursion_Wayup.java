// import java.util.ArrayList;

public class Recursion_Wayup {
    
    public static void subSequenceWayUp(String str, String ans){
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        char ch = str.charAt(0);
        String roq = str.substring(1);

        subSequenceWayUp(roq, ans);
        subSequenceWayUp(roq, ans + ch);
    }

    public static void main(String[] args) {
        String ans = "";
        subSequenceWayUp("abc",ans);
    }
}
