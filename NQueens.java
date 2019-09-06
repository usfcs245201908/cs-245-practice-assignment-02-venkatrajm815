

//Venkatraj Mohan

public class NQueens
{

	public int [][] board;
	public int num;

	public NQueens(int n)
	{
		num = n;
		//creates board of size n
		board = new int [num][num]; 

	}
	public boolean placeNQueens() throws Exception
	{
		//this function places the Queens

		//if num is less than 0, it throws exception and tells user that the number must be greater than 0
		if(num <= 0)
		{
			throw new Exception("The size must be greater than 0.");
		}

		//otherwise, it places in the first column and calls the placeNColumn

		else
		{
			return placeNColumn(0);
		}
		
	}

	public boolean placeNColumn(int col)
	{


		if (col >= num)
		{
			return true;
		}
		for (int i = 0; i < num; i++)
		{
			if (placeNQueenOrNot(i, col))
			{
				board[i][col] = 1;
				if (placeNColumn(col+1))
				{
					return true;
				} 
				else 
				{
					board[i][col] = 0;
				}
			}
		}

		return false;
	}


	private boolean placeNQueenOrNot(int row,int col)
    {
    	int i = 0;
    	int j = 0;

    	//for loop checks sides
    	for (i = 0; i < col; i++)
    	{
			if (board[row][i] == 1) 
			{
				return false;
			}
		}

		//for loop checks upper left diagonal
		for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
		{ 
			if (board[i][j] == 1) 
			{
				return false;
			}
		} 

		//for loop chec lower left diagonal
		for (i = row, j = col; j >= 0 && i < num; i++, j--)
		{ 
			if (board[i][j] == 1) 
			{
				return false;
			}
		}


		return true;


    }

	

	
	public static void printToConsole(int [][] board)
	{
		//this function prints the board 
		//the value 1 is assigned to the spots where the Queens are placed
		// the value _ is assigned where it is empty

		int i,j;
		for(i = 0 ; i < board.length ; i++)
		{
			for(j = 0 ; j < board.length; j++)
	        {
	            if( board[i][j] == 1)
	            {
	            	System.out.println("Q\t");
	            }
	            else
	            {
	            	System.out.println("_\t");
	            }
	        }
	        System.out.println();

		}

		//this is to print each elemt of the 2d array
		for(i = 0 ; i < board.length ; i++)
	    {
	        for(j = 0 ; j < board.length ; j++)
	        {
	            System.out.print(board[i][j]);
	        }
	        System.out.println(" ");
	    }
    }


    
    //toString to print the board, not called in the main test function
    public String toString()
    {
    	
    	printToConsole(board);
    	return " ";
    }

   

}






