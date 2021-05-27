package com.craftmanship;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.stream.Stream;

import org.approvaltests.Approvals;
import org.approvaltests.core.Options;
import org.approvaltests.reporters.JunitReporter;
import org.approvaltests.reporters.QuietReporter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MinesweeperTest {
	
	private static Stream<Arguments> provideBoard() {
		return Stream.of(
				Arguments.of(new int[][] { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 5, 0 }, { 0, 0, 0, 0 } })
				);
	}

	@ParameterizedTest(name = "#{index} - Test with {0} and {1}")
	@MethodSource("provideBoard")
	public void runMinesweeper(int[][] board) throws FileNotFoundException {
		Minesweeper.calculateNeighbours(board.length, board[0].length, board);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));

		Minesweeper.printOutTheGrid(board.length, board[0].length, board);

		Approvals.verify(out.toString(), new Options().withReporter(QuietReporter.INSTANCE));
	}


	@Test
	public void runMinesweeperWithBombsInCorners() throws FileNotFoundException {
		int[][] board = new int[][] { { 5, 0, 0, 5 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 5, 0, 0, 5 } };
		Minesweeper.calculateNeighbours(4, 4, board);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));

		Minesweeper.printOutTheGrid(4, 4, board);

		Approvals.verify(out.toString());
	}

	@Test
	public void runMinesweeperWithBombsInDiagonals() throws FileNotFoundException {
		int[][] board = new int[][] { { 5, 0, 0, 5 }, { 0, 5, 5, 0 }, { 0, 5, 5, 0 }, { 5, 0, 0, 5 } };
		Minesweeper.calculateNeighbours(4, 4, board);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));

		Minesweeper.printOutTheGrid(4, 4, board);

		Approvals.verify(out.toString());
	}

	@Test
	public void runMinesweeperWithSmallGrid() throws FileNotFoundException {
		int[][] board = new int[][] { { 5, 5 }, { 5, 5 } };
		Minesweeper.calculateNeighbours(2, 2, board);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));

		Minesweeper.printOutTheGrid(2, 2, board);

		Approvals.verify(out.toString());
	}
}
