public class SudukoSolver {
    public static void main(String[] args){
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        }; 
        
        SudukoSolver solver = new SudukoSolver();
        solver.solve(board, 0, 0);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean solve(char[][] board, int row, int col){
        if(row == board.length){
            return true;
        }

        int nrow = 0;
        int ncol = 0;
        if(col == board.length-1){
            ncol = 0;
            nrow = row+1;
        } else {
            nrow = row;
            ncol = col+1;
        }

        if(board[row][col] == '.'){
            for(char c = '1'; c<='9'; c++){
                if(isSafe(board, row, col, c)){
                    board[row][col] = c;
                    
                    if(solve(board, nrow, ncol)) return true;          
                    else board[row][col] = '.';
                } 
            }
        } else{
            return solve(board, nrow, ncol);
        }
        
        return false;
    }

    public boolean isSafe(char[][] board, int row, int col, char c){
        for(int i = 0; i<9; i++){
            if(board[row][i] == c || board[i][col] == c){
                return false;
            }
        }

        int sr = 3 * (row/3);
        int sc = 3 * (col/3);

        for(int i=sr; i<sr+3; i++){
            for(int j = sc; j<sc+3; j++){
                if(board[i][j] == c) return false;
            }
        }

        return true;
    }
}