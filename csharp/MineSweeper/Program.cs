using System;
namespace MineSweeper
{
    public class Minesweeper
    {
        public static void Main(string[] args)
        {
            int m = int.Parse(args[0]);
            int n = int.Parse(args[1]);
            int k = int.Parse(args[2]);

            int[,] mine = InitializeGrid(m, n, k);
            CalculateNeighbours(m, n, mine);
            PrintOutTheGrid(m, n, mine);
        }

        public static void PrintOutTheGrid(int m, int n, int[,] mine)
        {
            //print out the grid
            for (int y = 0; y < n; y++)
            {
                for (int x = 0; x < m; x++)
                {
                    //println at the right edge of the grid
                    if (x == m - 1)
                    {
                        if (mine[x, y] >= 5)
                        {
                            Console.WriteLine("*");
                        }
                        else
                        {
                            Console.WriteLine(mine[x, y]);
                        }
                    }
                    //other tiles, no need to switch lines
                    else
                    {
                        if (mine[x, y] >= 5)
                        {
                            Console.Write("*  ");
                        }
                        else
                        {
                            Console.Write(mine[x, y] + "  ");
                        }
                    }
                }
            }
        }

        public static void CalculateNeighbours(int m, int n, int[,] mine)
        {
            for (int y = 0; y < n; y++)
            {
                for (int x = 0; x < m; x++)
                {
                    //first row of the grid
                    if (y == 0)
                    {
                        //upper left corner
                        if (x == 0)
                        {
                            if (mine[x + 1, y] >= 5)
                            {
                                mine[x, y] += 1;
                            }
                            if (mine[x, y + 1] >= 5)
                            {
                                mine[x, y] += 1;
                            }
                        }
                        //upper right corner
                        else if (x == m - 1)
                        {
                            if (mine[x - 1, y] >= 5)
                            {
                                mine[x, y] += 1;
                            }
                            if (mine[x, y + 1] >= 5)
                            {
                                mine[x, y] += 1;
                            }
                        }
                        //mid of first row
                        else
                        {
                            if (mine[x - 1, y] >= 5)
                            {
                                mine[x, y] += 1;
                            }
                            if (mine[x + 1, y] >= 5)
                            {
                                mine[x, y] += 1;
                            }
                            if (mine[x, y + 1] >= 5)
                            {
                                mine[x, y] += 1;
                            }
                        }
                    }
                    //mid rows
                    else if (y < n - 1)
                    {
                        //left side
                        if (x == 0)
                        {
                            if (mine[x, y - 1] >= 5)
                            {
                                mine[x, y] += 1;
                            }
                            if (mine[x, y + 1] >= 5)
                            {
                                mine[x, y] += 1;
                            }
                            if (mine[x + 1, y] >= 5)
                            {
                                mine[x, y] += 1;
                            }
                        }
                        //right side
                        else if (x == m - 1)
                        {
                            if (mine[x, y - 1] >= 5)
                            {
                                mine[x, y] += 1;
                            }
                            if (mine[x, y + 1] >= 5)
                            {
                                mine[x, y] += 1;
                            }
                            if (mine[x - 1, y] >= 5)
                            {
                                mine[x, y] += 1;
                            }
                        }
                        //mid
                        else
                        {
                            if (mine[x, y - 1] >= 5)
                            {
                                mine[x, y] += 1;
                            }
                            if (mine[x, y + 1] >= 5)
                            {
                                mine[x, y] += 1;
                            }
                            if (mine[x - 1, y] >= 5)
                            {
                                mine[x, y] += 1;
                            }
                            if (mine[x + 1, y] >= 5)
                            {
                                mine[x, y] += 1;
                            }
                        }
                    }
                    //bottom row
                    else if (y == n - 1)
                    {
                        //bottom left corner
                        if (x == 0)
                        {
                            if (mine[x + 1, y] >= 5)
                            {
                                mine[x, y] += 1;
                            }
                            if (mine[x, y - 1] >= 5)
                            {
                                mine[x, y] += 1;
                            }
                        }
                        //bottom right corner
                        else if (x == m - 1)
                        {
                            if (mine[x - 1, y] >= 5)
                            {
                                mine[x, y] += 1;
                            }
                            if (mine[x, y - 1] >= 5)
                            {
                                mine[x, y] += 1;
                            }
                        }
                        //middle of the bottom row
                        else
                        {
                            if (mine[x + 1, y] >= 5)
                            {
                                mine[x, y] += 1;
                            }
                            if (mine[x - 1, y] >= 5)
                            {
                                mine[x, y] += 1;
                            }
                            if (mine[x, y - 1] >= 5)
                            {
                                mine[x, y] += 1;
                            }
                        }
                    }
                }
            }
        }

        private static int[,] InitializeGrid(int m, int n, int k)
        {
            int[,] mine = new int[m, n];
            //put the mines
            for (int z = 0; z < k; z++)
            {
                Random r = new Random();
                int randomX = (int)(r.NextDouble() * m);
                int randomY = (int)(r.NextDouble() * n);
                mine[randomX, randomY] = 5;
            }

            return mine;
        }
    }
}
