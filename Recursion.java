public class Recursion {
    public static void main(String[] args){
        System.out.println(calcPower2(2, 5));
    }

    // Print numbers from n to 1.
    public static void printNTo1(int n){
        if(n==0) return;

        System.out.println(n);
        printNTo1(n-1);
    }

    // Print numbers from 1 to n.
    public static void print1ToN(int from, int to){
        if(from == to+1) return;

        System.out.println(from);
        print1ToN(from+1, to);
    }

    // Print the sum of first n natural numbers.
    public static void printSumOfNNumbers(int n, int sum){
        if(n == 0){
            System.out.println(sum);
            return;
        }
        sum+=n;
        printSumOfNNumbers(n-1, sum);
    }

    // Print factorial of a number n.
    public static int calcFact(int n){
        if(n == 1 || n == 0) return 1;
        return n * calcFact(n-1);   
    }

    // Print the fibonacci sequence till nth term.
    public static void printFib(int a, int b, int n){
        if(n == 0){
            return;
        }
        System.out.println(a);
        printFib(b, a+b, n-1);
    }

    // Print x^n (with stack height = n)
    public static int calcPower(int x, int n){
        if(n == 1) return x;
        if(n == 0) return 1;
        return x * calcPower(x, n-1);
    }

    // Print x^n (with stack height = logn)
    public static int calcPower2(int x, int n){
        if(n == 0){
            return 1;
        }

        int half = calcPower2(x, n/2);
        if(n%2 == 0){
            return half * half;
        } else {
            return half * half * x;
        }
    }
}