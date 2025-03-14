import java.util.Scanner;


public class TicTacToe {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char[][] board = new char[3][3];
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				board[i][j] = ' ';
			}
		}
		
		int count= 0;
		printBoard(board);
		 while(true) {
			
	// retry logic 1		
			//boardInput(board,'X',sc);
//			if (!boardInput(board,'X',sc)) {
//				continue;
//			}
			 
			while (!boardInput(board,'X',sc)) {} 
			printBoard(board);
			count++;
			if(hasWon(board, 'X')) {
				break;
			};
			if(count == 9) {
				System.out.println("Tie");
				break;
			}
			
			//boardInput(board,'O',sc);
			while (!boardInput(board,'O',sc)) {}
			printBoard(board);
			count++;
			if(hasWon(board, 'O')) {
				break;
			}
			
			if(count == 9) {
				System.out.println("Tie");
				break;
			}
		}
		

		
		
	}
	
	//prints board on console
	static void printBoard(char[][] board) {
		for(int i =0 ; i < board.length;i++) {
			for(int j = 0; j < board[i].length;j++) {
				if(j != board[i].length -1) {
				System.out.print(" "+board[i][j] + " |");
				}else {
					System.out.print(" "+board[i][j]);
				}
			}
			System.out.println();
			if(i != board.length -1)
			System.out.println("---+---+---");
		}
	}
	//input for board
	static boolean boardInput(char[][] board,char user ,Scanner sc) {
			
			char a = user;
			System.out.println("Player move : "+a);
//			Scanner sc = new Scanner(System.in);
			
			System.out.print("At position: ");
			int i = sc.nextInt();
			int j = sc.nextInt(); 
			if( i < 3 && j < 3 && i >= 0 && j >= 0 && board[i][j] == ' ') {
			board[i][j] = a;
			return true;
			}
			else {
				System.out.println("Invalid move");
			return false;	
			}
		
	}
	

	// checks if any player has won
	static boolean hasWon(char[][] board,char user) {
		for(int i = 0 ; i < 3 ;i++) {
		if(board[i][0] == user && board[i][1] == user && board[i][2] == user) {
			System.out.println(user+" wins");
			
			return true;
				}
		
		else if (board[0][i] == user && board[1][i] == user && board[2][i] == user) {
			System.out.println(user+" wins");
			
			return true;
				}
		
		}
		if (board[0][0] == user && board[1][1] == user && board[2][2] == user) {
			System.out.println(user+" wins");
			return true;
		}else if (board[0][2] == user && board[1][1] == user && board[2][0] == user) {
			System.out.println(user+" wins");
			return true;
		}
		
		return false;
	}	
	
}
