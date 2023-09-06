public class ticTacToe
{
    public static void main(String args[])
    {
        char [][] board ={{' ','|',' ','|',' '},
                        {'-','+',' ','+','-'},
                        {' ','|',' ','|',' '},
                        {'-','+',' ','+','-'},
                        {' ','|',' ','|',' '},
        };
        drawBoard(board);

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
}