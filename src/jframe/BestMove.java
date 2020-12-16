package jframe;

import javax.swing.JButton;



public class  BestMove {
	 class Move{
		 int row, col; 
		};
	static char Computer = 'X', Human = 'O';
	static Boolean isMovesLeft(char board[][]) 
	{ 
	    for (int i = 0; i < 3; i++) 
	        for (int j = 0; j < 3; j++) 
	            if (board[i][j] == 0) 
	                return true; 
	    return false; 
	} 
	  
	// This is the evaluation function who has won or tie
	
	static int evaluate(char b[][]) 
	{ 
	    // Checking for Rows computer or human victory.
	    for (int row = 0; row < 3; row++) 
	    { 
	        if (b[row][0] == b[row][1] && 
	            b[row][1] == b[row][2]) 
	        { 
	            if (b[row][0] ==Computer) 
	                return +10; 
	            else if (b[row][0] ==Human) 
	                return -10; 
	        } 
	    } 
	  
	    // Checking for Columns for computer or human victory.
	    for (int col = 0; col < 3; col++) 
	    { 
	        if (b[0][col] == b[1][col] && 
	            b[1][col] == b[2][col]) 
	        { 
	            if (b[0][col] ==Computer) 
	                return +10; 
	  
	            else if (b[0][col] == Human) 
	                return -10; 
	        } 
	    } 
	  
	    // Checking for Diagonals for computer or human victory. 
	    if (b[0][0] == b[1][1] && b[1][1] == b[2][2]) 
	    { 
	        if (b[0][0] == Computer) 
	            return +10; 
	        else if (b[0][0] == Human) 
	            return -10; 
	    } 
	  
	    if (b[0][2] == b[1][1] && b[1][1] == b[2][0]) 
	    { 
	        if (b[0][2] ==Computer) 
	            return +10; 
	        else if (b[0][2] == Human) 
	            return -10; 
	    } 
	  
	    // Else if none of them have won then return 0 
	    return 0; 
	} 
	  
	//
	static int minimax(char board[][],  
	                    int depth, Boolean isMax) 
	{ 
	    int score = evaluate(board); 
	  
	    // If Computer has won the game  
	    // return his/her evaluated score 
	    if (score == 10) 
	        return score; 
	  
	    // If Human has won the game  
	    // return his/her evaluated score 
	    if (score == -10) 
	        return score; 
	  
	    // If there are no more moves and  
	    // no winner then it is a tie 
	    if (isMovesLeft(board) == false) 
	        return 0; 
	  
	    // Computer move
	    if (isMax) 
	    { 
	        int best = -1000; 
	  
	        // Traverse all cells 
	        for (int i = 0; i < 3; i++) 
	        { 
	            for (int j = 0; j < 3; j++) 
	            { 
	                // Check if cell is empty 
	                if (board[i][j]==0) 
	                { 
	                    // Make the move 
	                    board[i][j] = Computer; 
	  
	                    // Call minimax recursively and choose 
	                    // the maximum value 
	                    best = Math.max(best, minimax(board,  
	                                    depth + 1, !isMax)); 
	  
	                    // Undo the move  (backtracking part)
	                    board[i][j] = 0; 
	                } 
	            } 
	        } 
	        return best; 
	    } 
	  
	    // Human move
	    else
	    { 
	        int best = 10000; 
	  
	        // Traverse all cells 
	        for (int i = 0; i < 3; i++) 
	        { 
	            for (int j = 0; j < 3; j++) 
	            { 
	                // Check if cell is empty 
	                if (board[i][j] == 0) 
	                { 
	                    // Make the move 
	                    board[i][j] = Human; 
	  
	                    best = Math.min(best, minimax(board,  
	                                    depth + 1, !isMax)); 
	  
	                    // Undo the move (backtracking part)
	                    board[i][j] = 0; 
	                } 
	            } 
	        } 
	        return best; 
	    } 
	} 
	  
	// This will set the best possible 
	// move for the computer. 
	 public int findrowcol( int i, int j,int count ,JButton b1,JButton b2,JButton b3,JButton b4,JButton b5,JButton b6,JButton b7,JButton b8,JButton b9)
	 {     count++;
	     if( i==0 && j==0)
	     {   
	    	 b1.setText("X"); 
	    	 b1.setEnabled(false);
	    	 
	     }
	     else if( i==0&&j==1)
	     {
	    	 b2.setText("X"); 
	    	 b2.setEnabled(false);
	    	 
	     }
	     else if(i==0 && j==2)
	     {
	    	 b3.setText("X"); 
	    	 b3.setEnabled(false);
	    	 
	     }
	     else if(i==1&&  j==0)
	     {
	    	 b4.setText("X"); 
	    	 b4.setEnabled(false);
	    	 
	     }
	     else if( i==1&&  j==1)
	     {
	    	 b5.setText("X"); 
	    	 b5.setEnabled(false);
	    	 
	     }
	     else if(i==1&&j==2)
	     {
	    	 b6.setText("X"); 
	    	 b6.setEnabled(false);
	    	 
	     }
	     else if( i==2&& j==0)
	     {
	    	 b7.setText("X"); 
	    	 b7.setEnabled(false);
	    	 
	     }
	     else if( i==2 && j==1)
	     {
	    	 b8.setText("X"); 
	    	 b8.setEnabled(false);
	    	 
	     }
	     else if( i==2&&  j==2)
	     {
	    	 b9.setText("X"); 
	    	 b9.setEnabled(false);
	    	 
	     }
	     else
	     {
	    	 
	     }
	     return count;
	    }
	 
	 
	

	
	    //return best move for the  computer 
	public  Move findBestMove(char board[][]) 
	{ 
	    int bestVal = -10000; 
	    Move bestMove = new Move(); 
	    bestMove.row = -1; 
	    bestMove.col = -1; 
	  	     
	    for (int i = 0; i < 3; i++) 
	    { 
	        for (int j = 0; j < 3; j++) 
	        { 
	            
	            if (board[i][j] == 0) 
	            { 
	                // Make the move 
	                board[i][j] = Computer; 
	  
	                
	                int moveVal = minimax(board, 0, false); 
	  
	                // Undo the move (backtracking part) 
	                board[i][j] = 0; 
	  
	              
	                if (moveVal > bestVal) 
	                { 
	                    bestMove.row = i; 
	                    bestMove.col = j; 
	                    bestVal = moveVal; 
	                } 
	            } 
	        } 
	    } 
	  
	    System.out.printf("The value of the best Move " +  
	                             "is : %d\n\n", bestVal); 
	  
	    return  bestMove; 
	}

	
}
