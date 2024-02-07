class Solution {
    public boolean exist(char[][] board, String word) {
        // check basics 
        if(word.length() == 0 || board == null || board.length == 0 || board[0].length == 0 || word == null){
            return false;
        }

        int rows = board.length;
        int col = board[0].length;

        //checks every box of the board
        for(int i=0;i<rows;i++){
            for(int j=0;j<col;j++){
                if(search(board,word,0,i,j)){
                    return true;
                }
            }
        }
        //word not found
        return false;
    }
    private boolean search(char[][] board,String word,int index,int row,int col){
        //base case : when whole word checked
        if(index == word.length()){
            return true;
        }

        //checks if curr position is not valid or curr char not matched
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(index)){
            return false;
        }

        //save the curr char and mark as read
        char temp = board[row][col];
        board[row][col] = '*';

        //recursive call in all four direction 
        boolean found = search(board,word,index+1,row+1,col)
                     || search(board,word,index+1,row-1,col) 
                     || search(board,word,index+1,row,col+1)
                     || search(board,word,index+1,row,col-1);

        //restore the curr char and backtrack
        board[row][col] = temp;

        return found;
    }
}
