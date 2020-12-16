package jframe;
import java.awt.event.*;
import javax.swing.*;
class GUI extends JFrame 
{ 
private static final long serialVersionUID = 1L;

    BestMove g=new BestMove();
	int m=0,count=1;
	char board[][] ={{ 0, 0, 0 }, 
                     { 0, 0, 0 },
                     { 0, 0, 0}};
 
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b;
	JTextField tf;
	
	public GUI(String s){
		super(s);	
	}

    public class Move {
         int row;
         int col;
	 };
	public void setComponent()
	{
	 tf=new JTextField();
	 tf.setBounds(20,370,250,30);
	 tf.setEditable(false);
	 b=new JButton("Start New Game");
	 b.setBounds(90,320,130,30);
     b1=new JButton("");
	 b1.setBounds(13,13,90,90);
	 b2=new JButton("");
	 b2.setBounds(110,13,90,90);
	 b3=new JButton("");
	 b3.setBounds(207,13,90,90); 
	 b4=new JButton("");
	 b4.setBounds(13,110,90,90); 
	 b5=new JButton("");
	 b5.setBounds(110,110,90,90);
	 b6=new JButton("");
	 b6.setBounds(207,110,90,90); 
	 b7=new JButton("");
	 b7.setBounds(13,207,90,90);
	 b8=new JButton("");
	 b8.setBounds(110,207,90,90);
	 b9=new JButton("");
	 b9.setBounds(207,207,90,90);
	  
	 b1.addActionListener(new A1());
	 b2.addActionListener(new A2());
	 b3.addActionListener(new A3());
	 b4.addActionListener(new A4());
	 b5.addActionListener(new A5());
	 b6.addActionListener(new A6());
	 b7.addActionListener(new A7());
	 b8.addActionListener(new A8());
	 b9.addActionListener(new A9());
	 
	 b.addActionListener(new A());
	 add(b1);
	 add(b2);
	 add(b3);
	 add(b4);
	 add(b5);
	 add(b6);
	 add(b7);
	 add(b8);
	 add(b9);
	 add(b);
	 add(tf);	
	} 
	public void setEnable()
	{
		b1.setEnabled(false);
		b2.setEnabled(false);
		b3.setEnabled(false);
		b4.setEnabled(false);
		b5.setEnabled(false);
		b6.setEnabled(false);
		b7.setEnabled(false);
		b8.setEnabled(false);
		b9.setEnabled(false);
	}
	public int findmatch()
	{
				
		if(b1.getText()=="X"&&b2.getText()=="X"&&b3.getText()=="X")
			return 1;
		else if(b1.getText()=="X"&&b4.getText()=="X"&&b7.getText()=="X")
			return 1 ;
		else if(b1.getText()=="X"&&b5.getText()=="X"&&b9.getText()=="X")
			return 1;
		
		else if(b2.getText()=="X"&&b5.getText()=="X"&&b8.getText()=="X")
			return 1;
		
		else if(b3.getText()=="X"&&b6.getText()=="X"&&b9.getText()=="X")
			return 1;
		else if(b3.getText()=="X"&&b5.getText()=="X"&&b7.getText()=="X")
			return 1;
		
		else if(b4.getText()=="X"&&b5.getText()=="X"&&b6.getText()=="X")
			return 1;
		
		else if(b7.getText()=="X"&&b8.getText()=="X"&&b9.getText()=="X")
			return 1;
		else{
			  if(count==9)
				tf.setText("Game Draw");
			  return 3;
	}
	}
	
			
		
	
	class A implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
		   m=0;count=1;
		   board[0][0]=0;
		   board[0][1]=0;
		   board[0][2]=0;
		   board[1][0]=0;
		   board[1][1]=0;
		   board[1][2]=0;
		   board[2][0]=0;
		   board[2][2]=0;
		 
		   b1.setText("");
		   b2.setText("");
		   b3.setText("");
		   b4.setText("");
		   b5.setText("");
		   b6.setText("");
		   b7.setText("");
		   b8.setText("");
		   b9.setText("");
		   b1.setEnabled(true);
		   b2.setEnabled(true);
		   b3.setEnabled(true);
		   b4.setEnabled(true);
		   b5.setEnabled(true);
		   b6.setEnabled(true);
		   b7.setEnabled(true);
		   b8.setEnabled(true);
		   b9.setEnabled(true);
		   tf.setText("");
		
	}
	}
	class A1 implements ActionListener
	{   
		public void actionPerformed(ActionEvent e)
		 {   count++;
			
			    b1.setText("O"); 
			    board[0][0]='O';
			
				b1.setEnabled(false);
				 if(count<10) {
				jframe.BestMove.Move bestMove = g.findBestMove(board);
				board[bestMove.row][bestMove.col]='X';
				count=g.findrowcol( bestMove.row, bestMove.col,count,b1,b2,b3,b4,b5,b6,b7,b8,b9);

			    System.out.printf("The Optimal Move is :\n"); 
			    System.out.printf("ROW: %d COL: %d\n\n",  
			               bestMove.row, bestMove.col ); 
			   m=findmatch();
				
				if(m==1){
					tf.setText("AI won");
					setEnable();
				}
				
				}
				
			}
			
	 }
	
	class A2 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		 {   count++;
			
			    b2.setText("O"); 
			    board[0][1]='O';
				
				b2.setEnabled(false);
				if(count<10) {
				jframe.BestMove.Move bestMove =g.findBestMove(board);
				board[bestMove.row][bestMove.col]='X';
				count=g.findrowcol( bestMove.row, bestMove.col,count,b1,b2,b3,b4,b5,b6,b7,b8,b9);

			    System.out.printf("The Optimal Move is :\n"); 
			    System.out.printf("ROW: %d COL: %d\n\n",  
			               bestMove.row, bestMove.col ); 
                m=findmatch();
				
				if(m==1){
					tf.setText("AI won");
					setEnable();
				}
			
				
			}	
		 }
	} 
	class A3 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		 {	count++;
			    b3.setText("O"); 
			    board[0][2]='O';
				
				b3.setEnabled(false);
				if(count<10) {
			    jframe.BestMove.Move bestMove = g.findBestMove(board);
				board[bestMove.row][bestMove.col]='X';
		        count=g.findrowcol( bestMove.row, bestMove.col,count,b1,b2,b3,b4,b5,b6,b7,b8,b9);

		      System.out.printf("The Optimal Move is :\n"); 
		      System.out.printf("ROW: %d COL: %d\n\n",  
		               bestMove.row, bestMove.col ); 
		      m=findmatch();
			
			  if(m==1){
					tf.setText("AI won");
					setEnable();
				}
				
				
			}	
		 }
	}
	class A4 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		 {count++;
			
			    b4.setText("O"); 
			    board[1][0]='O';
				
				b4.setEnabled(false);
				if(count<10) {
				jframe.BestMove.Move bestMove = g.findBestMove(board);
				board[bestMove.row][bestMove.col]='X';
				count=g.findrowcol( bestMove.row, bestMove.col,count,b1,b2,b3,b4,b5,b6,b7,b8,b9);

			    System.out.printf("The Optimal Move is :\n"); 
			    System.out.printf("ROW: %d COL: %d\n\n",  
			               bestMove.row, bestMove.col ); 
                m=findmatch();
				
				if(m==1){
					tf.setText("AI won");
					setEnable();
				}
				
			}	
		 }
	}
	class A5 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		 {count++;
			    b5.setText("O"); 
			    board[1][1]='O';
				
				b5.setEnabled(false);
				if(count<10) {
				jframe.BestMove.Move bestMove = g.findBestMove(board);
				board[bestMove.row][bestMove.col]='X';
				count=g.findrowcol( bestMove.row, bestMove.col,count,b1,b2,b3,b4,b5,b6,b7,b8,b9);

			    System.out.printf("The Optimal Move is :\n"); 
			    System.out.printf("ROW: %d COL: %d\n\n",  
			               bestMove.row, bestMove.col ); 
                m=findmatch();
				
				if(m==1){
					tf.setText("AI won");
					setEnable();
				}
				
				
			}
		 }
	}
	class A6 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		 {
			count++;
			    b6.setText("O"); 
			    board[1][2]='O';
			
				b6.setEnabled(false);
				if(count<10) {
				jframe.BestMove.Move bestMove = g.findBestMove(board);
				board[bestMove.row][bestMove.col]='X';
				count=g.findrowcol( bestMove.row, bestMove.col,count,b1,b2,b3,b4,b5,b6,b7,b8,b9);

			    System.out.printf("The Optimal Move is :\n"); 
			    System.out.printf("ROW: %d COL: %d\n\n",  
			               bestMove.row, bestMove.col ); 
                m=findmatch();
				
				if(m==1){
					tf.setText("AI won");
					setEnable();
				}
				
			}
		 }
	}
	class A7 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		 {count++;
			    b7.setText("O"); 
			    board[2][0]='O';
				
				b7.setEnabled(false);
				if(count<10) {
				jframe.BestMove.Move bestMove = g.findBestMove(board);
				board[bestMove.row][bestMove.col]='X';
				count=g.findrowcol( bestMove.row, bestMove.col,count,b1,b2,b3,b4,b5,b6,b7,b8,b9);

			    System.out.printf("The Optimal Move is :\n"); 
			    System.out.printf("ROW: %d COL: %d\n\n",  
			               bestMove.row, bestMove.col ); 
                m=findmatch();
				
				if(m==1){
					tf.setText("AI won");
					setEnable();
				}
				
				
			}
		 }
	}
	class A8 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		 {
			count++;
			    b8.setText("O"); 
			    board[2][1]='O';
				
				b8.setEnabled(false);
				if(count<10) {
				jframe.BestMove.Move bestMove = g.findBestMove(board);
				board[bestMove.row][bestMove.col]='X';
				count=g.findrowcol( bestMove.row, bestMove.col,count,b1,b2,b3,b4,b5,b6,b7,b8,b9);

			    System.out.printf("The Optimal Move is :\n"); 
			    System.out.printf("ROW: %d COL: %d\n\n",  
			               bestMove.row, bestMove.col ); 
                 m=findmatch();
				
				if(m==1){
					tf.setText("AI won");
					setEnable();
				}
				
				
			}
		 }
	}
	class A9 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		 {count++;
			
			    b9.setText("O"); 
			    board[2][2]='O';
				
				b9.setEnabled(false);
				if(count<10) {
				jframe.BestMove.Move bestMove = g.findBestMove(board);
				board[bestMove.row][bestMove.col]='X';
				count=g.findrowcol( bestMove.row, bestMove.col,count,b1,b2,b3,b4,b5,b6,b7,b8,b9);

			    System.out.printf("The Optimal Move is :\n"); 
			    System.out.printf("ROW: %d COL: %d\n\n",  
			               bestMove.row, bestMove.col ); 
                m=findmatch();
				
				if(m==1){
					tf.setText("AI won");
					setEnable();
				}
			
				
			}
		 }
	}  
	
	 
	
	
	public static void main(String []args)
{
	 GUI jf=new GUI("Tic Tac Toe");
	 jf.setComponent(); 
	 jf.setSize(325,450);
	 jf.setLocation(100,100);
	 jf.setLayout(null);
	 jf.setVisible(true);
	 jf.setResizable(false);
	 jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
	 
	}
}
