
import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args){
        List<List<String>> allBoard = new ArrayList<>();
        int n = 4;
        char[][] board = new char[n][n];

        helper(allBoard, board, 0);
        printBoard(allBoard);
    }

    public static void helper(List<List<String>> allBoard, char[][] board, int col){
        // base case 
        if(col == board.length){
            saveBoard(allBoard, board);
            return;
        }
        for (int row = 0; row<board.length; row++){
            if(isSafe(board, row, col)){
                board[row][col] = 'Q';
                helper(allBoard, board, col+1);
                board[row][col] = '.';
            }
        }
    }

    public static boolean isSafe(char[][] board, int row, int col){
        // vertical check
        for(int r=0; r<board.length; r++){
            if(board[r][col] == 'Q'){
                return false;
            }
        }

        // horizontal check
        for(int c = 0; c<board.length; c++){
            if(board[row][c] == 'Q'){
                return false;
            }
        }

        // diagonally top left
        int r = row;
        for(int c = col; c>=0 && r>=0; r--, c--){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        // diagonally top right
        r = row;
        for(int c = col; c<board.length && r>=0; r--, c++){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        // diagonally bottom left
        r = row;
        for(int c = col; c>=0 && r<board.length; c--, r++){
            if(board[r][c] == 'Q'){
                return false;
            }
        }
    
        // diagonally bottom right
        r = row;
        for(int c = col; c<board.length && r<board.length; c++, r++){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        return true;
    }

    public static void saveBoard(List<List<String>> allBoard, char[][] board){
        List<String> boardList = new ArrayList<>();

        for(int row = 0; row<board.length; row++){
            StringBuilder boardString = new StringBuilder();
            for(int col = 0; col<board.length; col++){
                if(board[row][col] == 'Q'){
                    boardString.append("Q");
                } else {
                    boardString.append(".");
                }
            }
            boardList.add(boardString.toString());
        }

        allBoard.add(boardList);
    }

    public static void printBoard(List<List<String>> allBoard){
        int solutionCount = 0;
        for(List<String> boardList : allBoard){
            System.out.println("Solution " + solutionCount + ": ");

            for(String boardString : boardList){
                System.out.println(boardString);
            }

            System.out.println("");
            solutionCount++;
        }
    }

}