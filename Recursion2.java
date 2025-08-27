
import java.util.HashSet;

public class Recursion2 {
    public static void main(String[] args){
        //towerOfHanoi(3, "A", "B", "C");

        /* String string = "hello";
        reverseString(string, string.length()); */

        //firstAndLastOcc("hello", 'l', 0);

        /* int[] arr = {1,2,4,3,5};
        System.out.println(isIncreasing(arr, 0)); */

        // moveAllXToEnd("abcdefxghxixjxxxk", 0);

        /* String string = "abcadbcefghabi";
        boolean[] arr = new boolean[string.length()];
        removeDuplicates(string, 0, arr); */

        // printAllSubSequence("abc", 0, "");

        /* HashSet<String> hashSet = new HashSet<>();
        printAllUniqueSubSequence("aaa", 0, "", hashSet); */

        printKeypadCombination("23", 0, "");
    }

    // tower of hanoi
    public static void towerOfHanoi(int n, String src, String helper, String dest){
        // base case 
        if(n == 1){
            System.out.println("Transferring disk " + n + " from " + src + " to " + dest);
            return;
        }
        // transfer n-1 disk from source to helper using helper as destination and dest as helper
        towerOfHanoi(n-1, src, dest, helper);

        // now transfer the nth disk from source to destination
        System.out.println("Transferring disk " + n + " from " + src + " to " + dest);

        // now tranfer n-1 disks from helper to dest using src as helper
        towerOfHanoi(n-1, helper, src, dest);
    }

    // reverse a string
    public static void reverseString(String string, int length){
        // base case 
        if(length == 0){
            System.out.println("");
            return;
        }

        System.out.print(string.charAt(length-1));
        reverseString(string, length-1);
    }

    // find first and last occurence of a character or element in a string
    public static int first = -1;
    public static int last = -1;
    public static void firstAndLastOcc(String string, char element, int idx){
        // base case 
        if(idx == string.length()){
            System.out.println("First idx: " + first);
            System.out.println("Last idx: " + last);
            return;
        }
        if(string.charAt(idx) == element){
            if(first == -1) first = idx;
            last = idx;
        }
        firstAndLastOcc(string, element, idx+1);
    }

    // Check if an array is sorted (strictly increasing)
    public static boolean isIncreasing(int arr[], int idx){
        // base case 
        if(idx == arr.length-1) return true;

        if(arr[idx] > arr[idx+1]) return false;
        return isIncreasing(arr, idx+1);
    }

    // Move all ‘x’ to the end of the string. 
    public static int count = 0;
    public static void moveAllXToEnd(String string, int idx){
        // base case 
        if(idx == string.length()){
            for(int i = 0; i<count; i++){
                System.out.print("x");
            }
            System.out.println("");
            return;
        }
        if(string.charAt(idx) == 'x'){
            count++; 
            moveAllXToEnd(string, idx+1);
        } else{
            System.out.print(string.charAt(idx));
            moveAllXToEnd(string, idx+1);
        }
    }

    // Remove duplicates in a string.
    public static void removeDuplicates(String string, int idx, boolean[] arr){
        // base case
        if(idx == string.length()){
            System.out.println("");
            return;
        }

        if(arr[string.charAt(idx)-'a']) removeDuplicates(string, idx+1, arr);
        else{
            System.out.print(string.charAt(idx)+"");
            arr[string.charAt(idx)-'a'] = true;
            removeDuplicates(string, idx+1, arr);
        }
    }
    
    // Print all the subsequences of a string.
    public static void printAllSubSequence(String string, int idx, String res){
        // base case
        if(idx == string.length()){
            System.out.println(res);
            return;
        }
        // include current character
        printAllSubSequence(string, idx+1, res + string.charAt(idx));

        // exclude current character
        printAllSubSequence(string, idx+1, res);
    }

    // Print all unique subsequences of a string.
    public static void printAllUniqueSubSequence(String string, int idx, String res, HashSet<String> hashSet){
        // base case
        if(idx == string.length()){
            if(hashSet.contains(res)) return;
            else {
                hashSet.add(res);
                System.out.println(res);
                return;
            }
        }
        // include current character
        printAllUniqueSubSequence(string, idx+1, res + string.charAt(idx), hashSet);

        // exclude current character
        printAllUniqueSubSequence(string, idx+1, res, hashSet);
    }

    // Print keypad combination
    public static String[] keypad = {
        "",     // 0
        "",     // 1 (no mapping)
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public static void printKeypadCombination(String number, int idx, String res){
        // base case
        if(idx == number.length()){
            System.out.println(res);
            return;
        }

        // get the string at the given idx like here we get '2' - '0' = 2
        String mapping = keypad[number.charAt(idx) - '0'];

        // now we loop through each characters in our string named mapping
        for(int i = 0; i<mapping.length(); i++){
            printKeypadCombination(number, idx+1, res+mapping.charAt(i));
        }
    }

}