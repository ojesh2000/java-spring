package model;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
    Cell[][] cells;
    //10 * 10 array
    public Board(int boardSize, int snakeCount, int ladderCount){
        initializeBoard(boardSize);
        addSnakesAndLadders(cells, snakeCount, ladderCount);
    }

    private void addSnakesAndLadders(Cell[][] cells, int snakeCount, int ladderCount) {
        //add Snakes
        for(int i = 0;i < snakeCount;++i){
            int start = ThreadLocalRandom.current().nextInt(1, cells.length * (cells.length));
            int end = ThreadLocalRandom.current().nextInt(1, start);
            Jump snakeObj = new Jump(start, end);

            Cell startCell = getCell(start);
            startCell.jump = snakeObj;
        }

        //add Ladders
        for(int i = 0;i < ladderCount;++i){
            int start = ThreadLocalRandom.current().nextInt(1, cells.length * (cells.length));
            int end = ThreadLocalRandom.current().nextInt(start + 1, cells.length * (cells.length));
            if(start >= end){
                continue ;
            }
            Jump snakeObj = new Jump(start, end);

            Cell startCell = getCell(start);
            startCell.jump = snakeObj;
        }
    }

    private void initializeBoard(int boardSize) {
        cells = new Cell[boardSize][boardSize];
        for(int i = 0;i < boardSize;++i){
            for(int j = 0;j < boardSize;++j){
                cells[i][j] = new Cell();
            }
        }
    }

    public Cell getCell(int x){
        return cells[x / cells.length][x % cells.length];
    }
}
