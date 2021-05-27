package com.craftmanship;

import org.junit.Test;

public class MinesweeperTest {

	@Test
	public void runMinesweeper() {
		Minesweeper.main(new String []{"2", "2", "4"});
		
		Minesweeper.main(new String []{"5", "6", "7"});

	}

}
