package Basics;

public class Patterns {
    public static void rightAngleTriangle(int n){
        int nst = 1;
        for(int row = 1; row <= n; row++){
            for(int cst = 1; cst <= nst; cst++){
                System.out.print("*");
            }
            System.out.println();
            nst++;
        }
    }

    public static void mirrorRightAngleTriangle(int n){
        int nsp = n - 1;
        int nst = 1;
        for(int row = 1; row <= n; row++){
            for(int csp = 1; csp <= nsp; csp++){
                System.out.print(" ");
            }
            for(int cst = 1; cst <= nst; cst++){
                System.out.print("*");
            }
            nsp--;
            nst++;
            System.out.println();
        }
    }

    public static void diamond(int n){
        int nsp = n/2;
        int nst = 1;
        for(int row = 1; row <= n; row++){
            for(int csp = 1; csp <= nsp; csp++){
                System.out.print(" ");
            }
            for(int cst = 1; cst <= nst; cst++){
                System.out.print("*");
            }
            for(int csp = 1; csp <= nsp; csp++){
                System.out.print(" ");
            }
            if(row < n/2 + 1){
                nsp--;
                nst+=2;
            }else{
                nsp++;
                nst-=2;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // rightAngleTriangle(5);
        // mirrorRightAngleTriangle(5);
        // diamond(7);
    }
}
