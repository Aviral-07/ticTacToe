import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ticTacToe {
	static List <Integer> playerPositions=new ArrayList<>();
	static List <Integer> cpuPositions=new ArrayList<>();
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	        char [][] board ={{' ','|',' ','|',' '},
	                          {'-','+','-','+','-'},
	                          {' ','|',' ','|',' '},
	                          {'-','+','-','+','-'},
	                          {' ','|',' ','|',' '},
	        };
	        drawBoard(board);
	        Scanner scan=new Scanner(System.in);
	        int bsize=0;
	        while(bsize<=9)
	        {
	        	System.out.println("Enter the position(1-9)");
	        	int pos=scan.nextInt();
	        	while(playerPositions.contains(pos)||cpuPositions.contains(pos))
	        	{
	        		System.out.println("Enter valid position!");
	        		pos=scan.nextInt();
	        	}
	        	enterinput(pos,board,"player");
	        	if(checkWin()) {
	        		drawBoard(board);
	        		System.out.println("Congratulations, you won!");
	        		break;
	        	}
	        	bsize++;
	        	if(bsize==9)
		        {
		        	drawBoard(board);
		        	System.out.println("Match tied!");
		        	break;
		        }
	        	Random rand =new Random();
	        	int cpuPos=rand.nextInt(9)+1;
	        	while(playerPositions.contains(cpuPos)||cpuPositions.contains(cpuPos))
	        	{
	        		cpuPos=rand.nextInt(9)+1;
	        	}
	        	Thread.sleep(1000);
	        	enterinput(cpuPos,board,"cpu");
	        	if(checkWin()) {
	        		drawBoard(board);
	        		System.out.println("Computer won!");
	        		break;
	        	}
	        	bsize+=1;
	        	drawBoard(board);
	        }
	}
		static void drawBoard(char [][] board)
	    {
	        for(char[] row:board)
	        {
	            for(char c:row)
	            {
	                System.out.print(c);
	            }
	            System.out.println();
	        }
	    }
		static void enterinput(int pos,char [][] board,String s)
		{
			char a;
			if(s=="player")
			{
				a='X';
				playerPositions.add(pos);
			}
			else
			{
				a='O';
				cpuPositions.add(pos);
			}
			switch(pos)
			{
				case 1:board[0][0]=a;
					break;
				case 2:board[0][2]=a;
					break;
				case 3:board[0][4]=a;
					break;
				case 4:board[2][0]=a;
					break;
				case 5:board[2][2]=a;
					break;
				case 6:board[2][4]=a;
					break;
				case 7:board[4][0]=a;
					break;
				case 8:board[4][2]=a;
					break;
				case 9:board[4][4]=a;
					break;
				default: System.out.println("Enter right input!");
		}
	}
	static boolean  checkWin()
	{
		List <List<Integer>> l=new ArrayList<>();
		List <Integer> row1= Arrays.asList(1,2,3);
		List <Integer> row2= Arrays.asList(4,5,6);
		List <Integer> row3= Arrays.asList(7,8,9);
		List <Integer> col1= Arrays.asList(1,4,7);
		List <Integer> col2= Arrays.asList(2,5,8);
		List <Integer> col3= Arrays.asList(3,6,9);
		List <Integer> diag1= Arrays.asList(1,5,9);
		List <Integer> diag2= Arrays.asList(3,5,7);
		l.add(row1);
		l.add(row2);
		l.add(row3);
		l.add(col1);
		l.add(col2);
		l.add(col3);
		l.add(diag1);
		l.add(diag2);
		for(List l2:l)
		{
			if(playerPositions.containsAll(l2)||cpuPositions.containsAll(l2))
			{
				return true;
			}
		}
		return false;
	}
}
