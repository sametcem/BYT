package exercise_06;

// TODO :  changed representation of the board.
//		:  code optimization: suggetMove(), winner();
public class TicTacToe 
{
	private final int BOARD_WIDTH;
	private char[][] board;
	
	public TicTacToe(String s) 
	{
		int i = s.length();
		BOARD_WIDTH = (int) Math.sqrt(i);
		initBoard(s);
	}

	public TicTacToe(String s, int position, char player) 
	{
		this(s);
		setPlayerAtPosition(position, player);
	}
	
	private void initBoard(String s)
	{
		this.board = new char[BOARD_WIDTH][BOARD_WIDTH];
		int i = 0;
		for (int r = 0; r < BOARD_WIDTH; ++r)
		{
			for (int c = 0; c < BOARD_WIDTH; ++c)
			{
				board[r][c] = s.charAt(i);
				++i;
			}
		}
	}

	private void setPlayerAtPosition(int position, char player) 
	{
		int row = position / BOARD_WIDTH;
		int col = position % BOARD_WIDTH;
		board[row][col] = player;
	}
	
	public String boardToString()
	{
		String output = "";
		for (int r = 0; r < BOARD_WIDTH; ++r) 
		{
			for (int c = 0; c < BOARD_WIDTH; ++c)
			{
				output += board[r][c];
			}
		}
		return output;
	}

	public int suggestMove(char player) 
	{
		int firstAvailable = -1;
		int i = 0;
		for (int r = 0; r < BOARD_WIDTH; ++r) 
		{
			for (int c = 0; c < BOARD_WIDTH; ++c)
			{
				if (board[r][c] == '-') 
				{
					TicTacToe game = makeMove(i, player);
					if (game.winner() == player)
						return i;
					if (firstAvailable < 0) firstAvailable = i;
				}
				++i;
			}
		}

		return firstAvailable;
	}

	public TicTacToe makeMove(int i, char player) 
	{
		return new TicTacToe(boardToString(), i, player);
	}
	
	public char winner() 
	{
		// TODO: inline methods: Horizontal,Vertical and Diagonal
		
		// check for Horizontal or Vertical winner
		for (int i = 0; i < BOARD_WIDTH; ++i) 
		{
			if ((board[i][0] != '-' && board[i][0] == board[i][1] && board[i][0] == board[i][2]) ||
				(board[0][i] != '-' && board[0][i] == board[1][i] && board[0][i] == board[2][i]))
					return board[i][i];
		}

		// check for diagonal winner
		if (board[0][0] != '-' && board[1][1] == board[0][0] && board[2][2] == board[0][0])
			return board[0][0];
		if (board[0][2] != '-' && board[1][1] == board[0][2] && board[2][0] == board[0][2])
			return board[0][2];

		// no winner yet
		return '-';
	}
}