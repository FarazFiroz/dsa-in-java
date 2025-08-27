
import java.util.ArrayList;
import java.util.List;

public class Backtracking{
    public static void main (String[] main){
        // printPermutations("abc", "");

        List<List<String>> board = solveNQueens(4);
        for(List<String> list : board){
            System.out.println("Solution: ");
            for(String s : list){
                System.out.println(s);
            }
            System.out.println("");
        }
    }

    // Print all permutations
    public static void printPermutations(String str, String perm){
        // base case
        if(str.length() == 0){
            System.out.println(perm);
            return;
        }

        for(int i = 0; i<str.length(); i++){
            String newStr = str.substring(0, i) + str.substring(i+1);
            printPermutations(newStr, perm+str.charAt(i));
        }
    }

    // N Queens
    public static List<List<String>> solveNQueens(int n){
        List<List<String>> allBoard = new ArrayList<>();
        char[][] board = new char[n][n];
        helper(board, allBoard, 0);
        return allBoard;
    }

    public static void helper(char[][] board, List<List<String>> allBoard, int col){
        // base case 
        if(col == board.length){
            saveBoard(board, allBoard);
            return;
        }

        for (int row = 0; row<board.length; row++){
            if(isSafe(board, row, col)){
                board[row][col] = 'Q';
                helper(board, allBoard, col+1);
                board[row][col] = '.';
            }
        }
    }

    public static boolean isSafe(char[][] board, int row, int col){
        // horizontal
        for (int i = 0; i<board.length; i++){
            if(board[row][i] == 'Q'){
                return false;
            }
        }

        // vertical 
        for (int i = 0; i<board.length; i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        // upper left
        int r = row;
        for(int c = col; c>=0 && r>=0; r--, c--){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        // upper right 
        r = row;
        for(int c = col; c<board.length && r>=0; r--, c++){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        // lower left
        r = row;
        for(int c = col; c>=0 && r<board.length; c--, r++){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        // lower rigth 
        r = row;
        for (int c = col; c<board.length && r<board.length; c++, r++){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        return true;
    }

    public static void saveBoard(char[][] board, List<List<String>> allBoard){
        List<String> newBoard = new ArrayList<>();

        for (int r = 0; r<board.length; r++){
            String row = "";
            for(int c = 0; c<board[0].length; c++){
                if(board[r][c] == 'Q')
                    row += "Q";
                else
                    row += ".";
            }
            newBoard.add(row);
        }

        allBoard.add(newBoard);
    }

}