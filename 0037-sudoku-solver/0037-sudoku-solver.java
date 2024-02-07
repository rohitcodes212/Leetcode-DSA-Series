class Solution{
    public void solveSudoku(char[][] board){
        solve(board,0,0);
    }
    private boolean solve(char[][] board,int row,int col){
        //checks if all boxes filled or base case
        if(row == board.length){
            return true;
        }

        //checks if col ended
        if(col == board[0].length){
            return solve(board,row+1,0);
        }

        //checks if curr box filled
        if(board[row][col] != '.'){
            return solve(board,row,col+1);
        }

        // checks possibilities at particular box
        for(char num='1';num <= '9';num++){
            //fill curr box with valid num
            if(isValidPlacement(board,row,col,num)){
                board[row][col] = num;

                //move to next col
                if(solve(board,row,col+1)){
                    return true;
                }

                //backtrack to previous state if solution not found
                board[row][col] = '.';
            }
        }
        //no valid solution found
        return false;
    }
    private boolean isValidPlacement(char[][] board,int row,int col,char num){
        //checks acc. to the rules of placement of num in sudoku

        for(int i=0;i<board.length;i++){
            //check row
            if(board[i][col] == num){
                return false;
           }

            //checks col
            if(board[row][i] == num){
                return false;
            }

            //check grid
            int subgridRow = 3 * (row / 3) + i / 3;
            int subgridCol = 3 * (col / 3) + i % 3;
            if(board[subgridRow][subgridCol] == num){
                return false;
            }
        }
        //placement is valid
        return true;
    }
}