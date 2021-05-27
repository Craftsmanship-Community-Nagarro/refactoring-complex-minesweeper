package com.craftmanship;

public class Minesweeper {
	
	public static void main(String[] args) {
		int m = Integer.parseInt(args[0]);
		int n = Integer.parseInt(args[1]);
		int k = Integer.parseInt(args[2]);

		int[][] mine = initialiseGrid(m, n, k);

		calculateNeighbours(m, n, mine);
		
		printOutTheGrid(m, n, mine);
	}

	static void calculateNeighbours(int m, int n, int[][] mine) {
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < m; x++) {
				// first row of the grid
				if (y == 0) {
					// upper left corner
					if (x == 0) {
						if (mine[x + 1][y] >= 5) {
							mine[x][y] += 1;
						}
						if (mine[x][y + 1] >= 5) {
							mine[x][y] += 1;
						}
					}
					// upper right corner
					else if (x == m - 1) {
						if (mine[x - 1][y] >= 5) {
							mine[x][y] += 1;
						}
						if (mine[x][y + 1] >= 5) {
							mine[x][y] += 1;
						}
					}
					// mid of first row
					else {
						if (mine[x - 1][y] >= 5) {
							mine[x][y] += 1;
						}
						if (mine[x + 1][y] >= 5) {
							mine[x][y] += 1;
						}
						if (mine[x][y + 1] >= 5) {
							mine[x][y] += 1;
						}
					}
				}
				// mid rows
				else if (y < n - 1) {
					// left side
					if (x == 0) {
						if (mine[x][y - 1] >= 5) {
							mine[x][y] += 1;
						}
						if (mine[x][y + 1] >= 5) {
							mine[x][y] += 1;
						}
						if (mine[x + 1][y] >= 5) {
							mine[x][y] += 1;
						}
					}
					// right side
					else if (x == m - 1) {
						if (mine[x][y - 1] >= 5) {
							mine[x][y] += 1;
						}
						if (mine[x][y + 1] >= 5) {
							mine[x][y] += 1;
						}
						if (mine[x - 1][y] >= 5) {
							mine[x][y] += 1;
						}
					}
					// mid
					else {
						if (mine[x][y - 1] >= 5) {
							mine[x][y] += 1;
						}
						if (mine[x][y + 1] >= 5) {
							mine[x][y] += 1;
						}
						if (mine[x - 1][y] >= 5) {
							mine[x][y] += 1;
						}
						if (mine[x + 1][y] >= 5) {
							mine[x][y] += 1;
						}
					}
				}
				// bottom row
				else {
					// bottom left corner
					if (x == 0) {
						if (mine[x + 1][y] >= 5) {
							mine[x][y] += 1;
						}
						if (mine[x][y - 1] >= 5) {
							mine[x][y] += 1;
						}
					}
					// bottom right corner
					else if (x == m - 1) {
						if (mine[x - 1][y] >= 5) {
							mine[x][y] += 1;
						}
						if (mine[x][y - 1] >= 5) {
							mine[x][y] += 1;
						}
					}
					// middle of the bottom row
					else {
						if (mine[x + 1][y] >= 5) {
							mine[x][y] += 1;
						}
						if (mine[x - 1][y] >= 5) {
							mine[x][y] += 1;
						}
						if (mine[x][y - 1] >= 5) {
							mine[x][y] += 1;
						}
					}
				}
			}
		}
	}

	static void printOutTheGrid(int m, int n, int[][] mine) {
		// print out the grid
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < m; x++) {
				// println at the right edge of the grid
				if (x == m - 1) {
					if (mine[x][y] >= 5) {
						System.out.println("*");
					} else {
						System.out.println(mine[x][y]);
					}
				}
				// other tiles, no need to switch lines
				else {
					if (mine[x][y] >= 5) {
						System.out.print("*  ");
					} else {
						System.out.print(mine[x][y] + "  ");
					}
				}
			}
		}
	}

	static int[][] initialiseGrid(int m, int n, int k) {
		int[][] mine = new int[m][n];
		// put the mines
		for (int z = 0; z < k; z++) {
			int randomX = (int) (Math.random() * m);
			int randomY = (int) (Math.random() * n);
			mine[randomX][randomY] = 5;
		}
		return mine;
	}
}