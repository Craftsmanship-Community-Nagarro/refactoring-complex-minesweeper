package com.craftmanship;

import org.approvaltests.Approvals;
import org.approvaltests.reporters.JunitReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

@UseReporter(JunitReporter.class)
public class MinesweeperTest {

    @Test
    public void shouldSolveBoardWithMultipleBombs() throws FileNotFoundException {
        int[][] board = new int[][]{
                {0, 0, 0, 0, 0},
                {5, 0, 0, 5, 0},
                {5, 5, 0, 5, 5},
                {0, 0, 0, 0, 0}
        };

        String solvedBoard = solvedBoard(board);

        Approvals.verify(solvedBoard);
    }

    @Test
    public void solvedBoardWithBombsInCorners() throws FileNotFoundException {
        int[][] board = new int[][]{
                {5, 0, 0, 5},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {5, 0, 0, 5}
        };

        String solvedBoard = solvedBoard(board);

        Approvals.verify(solvedBoard);
    }

    @Test
    public void solvedBoardWithBombsInDiagonals() throws FileNotFoundException {
        int[][] board = new int[][]{
                {5, 0, 0, 5},
                {0, 5, 5, 0},
                {0, 5, 5, 0},
                {5, 0, 0, 5}
        };

        String solvedBoard = solvedBoard(board);

        Approvals.verify(solvedBoard);
    }

    @Test
    public void solvedBoardWithSmallGrid() throws FileNotFoundException {
        int[][] board = new int[][]{
                {5, 5},
                {5, 5}
        };

        String solvedBoard = solvedBoard(board);

        Approvals.verify(solvedBoard);
    }

    private String solvedBoard(int[][] board) {
        Minesweeper.calculateNeighbours(board.length, board[0].length, board);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Minesweeper.printOutTheGrid(board.length, board[0].length, board);

        String solvedBoard = out.toString();
        return solvedBoard;
    }

}
