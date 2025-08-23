public class Recursion3 {
    public static void main(String[] args){
        // printPermutations("abc", "");

        /* int m = 3, n = 3;
        System.out.println(countPath(0, 0, m, n)); */

        // System.out.println(placeTiles(4, 2));

        // System.out.println(pairFriends(4));

        printSubsets("abc", "", 0);
    }

    // Print all the permutations of a string.
    public static void printPermutations(String str, String perm){
        if(str.length() == 0){
            System.out.println(perm);
            return;
        }
        for(int i = 0; i<str.length(); i++){
            char currentChar = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i+1);
            printPermutations(newStr, perm+currentChar);
        }
    }

    // CountPathMaze 
    public static int countPath(int i, int j, int m, int n){
        if( i== m || j==n){
            return 0;
        }

        if(i == m-1 && j == n-1){
            return 1;
        }

        // right
        int rightPaths = countPath(i, j+1, m, n);

        // bottom
        int bottomPaths = countPath(i+1, j, m, n);

        return rightPaths + bottomPaths;
    }

    //Tiling problem
    public static int placeTiles(int n, int m){
        if(n == m){
            return 2;
        }
        if(n < m){
            return 1;
        }
        // horizontally
        int horizontally = placeTiles(n-1, m);

        // vertically
        int vertically = placeTiles(n-m, m);

        return horizontally + vertically;
    }

    // Friends pairing problem
    public static int pairFriends(int n){
        if(n <= 1){
            return 1;
        }

        // single
        int single = pairFriends(n-1);

        // pair
        int pair = (n-1) * pairFriends(n-2);

        return single + pair;
    }

    // Subsets of a set
    public static void printSubsets(String set, String current, int n){
        if(n == set.length()){
            System.out.println(current);
            return;
        }
        // aayega
        printSubsets(set, current+set.charAt(n), n+1);

        // nahi aayega
        printSubsets(set, current, n+1);
    }

}