package practice;

public class TicTacToe {
    public static void main(String[] args) {
        int[][] board = new int[3][3];

        boolean game = true;
        while(game){
            for(int row = 0; row < 3; row++){
                if(board[row][0] == board[row][1] && board[row][1] == 
                board[row][2]){
                    game = false;
                }
            }
        }
        

    }
}
