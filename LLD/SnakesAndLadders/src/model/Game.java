package model;

import java.util.Deque;
import java.util.LinkedList;

public class Game {
    Board board;
    Dice dice;
    Deque<Player> players = new LinkedList<>();
    Player winner;


    public Game(){
        init();
    }

    private void init() {
        board = new Board(10, 4,4);
        dice = new Dice(1);
        winner = null;
        addPlayers();
    }

    private void addPlayers() {
        players.add(new Player("Player 1", 0));
        players.add(new Player("Player 2", 0));
    }

    public void startGame(){
        while(winner == null){
            //business logic

        }
    }





}
