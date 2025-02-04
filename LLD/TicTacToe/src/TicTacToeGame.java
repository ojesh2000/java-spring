import model.Board;
import model.Player;
import model.PlayingPieceO;
import model.PlayingPieceX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class TicTacToeGame {
    Deque<Player> players;
    Board gameBoard;

    public TicTacToeGame(){
        init();
    }

    public void init(){
        this.players = new LinkedList<>();
        PlayingPieceX crossPiece = new PlayingPieceX();
        Player player1 = new Player("Player 1", crossPiece);

        PlayingPieceO notPiece = new PlayingPieceO();
        Player player2 = new Player("Player 2", notPiece);

        this.players.add(player1);
        this.players.add(player2);

        gameBoard = new Board(3);
    }

    public void playGame() throws IOException {
        boolean winner = false;
        int chance = 0;

        while(!winner){
            Player currentPlayer = players.pollFirst();
            System.out.println("Player " + currentPlayer.getName() + "'s turn");
            System.out.println(gameBoard.toString());
            System.out.println("Enter Row and Column");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] rc = br.readLine().split(",");
            int row = Integer.parseInt(rc[0].trim());
            int col = Integer.parseInt(rc[1].trim());
            if(gameBoard.board[row][col] == null){
                gameBoard.board[row][col] = currentPlayer.getPiece();
                if(gameBoard.won()){
                    System.out.println("Player " + currentPlayer.getName() + " has won the game");
                    winner = true;
                }else if(gameBoard.occupied()){
                    System.out.println("The game is a draw!!");
                    break ;
                }
            }else{
                System.out.println("Invalid Move: This place is already occupied");
                players.addFirst(currentPlayer);
                continue ;
            }
            players.addLast(currentPlayer);
            chance++;
        }
    }
}
