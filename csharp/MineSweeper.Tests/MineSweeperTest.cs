using ApprovalTests;
using ApprovalTests.Reporters;
using System;
using System.Collections.Generic;
using System.IO;
using Xunit;

namespace MineSweeper.Tests
{
    [UseReporter(typeof(DiffReporter))]
    public class MineSweeperTest
    {
        public static class DemoPropertyDataSource
        {
            private static readonly List<List<List<int>>> _data
                = new List<List<List<int>>>
                    {
                        new List<List<int>> { new List<int>() { 5, 0, 0, 5 },
            new List<int>() { 0, 0, 0, 0 }, new List<int>() { 0, 0, 0, 0 },
                       new List<int>() { 5, 0, 0, 5 }
                    } };

            public static IEnumerable<List<List<int>>> TestData
            {
                get { return _data; }
            }
        }

        [Fact]
        public void RunMinesweeper()
        {
            int[,] board = new int[,] { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 5, 0 }, { 0, 0, 0, 0 } };
            Minesweeper.CalculateNeighbours(4, 4, board);

            var sw = new StringWriter();
            Console.SetOut(sw);
            string result = sw.ToString();

            Minesweeper.PrintOutTheGrid(4, 4, board);

            Approvals.Verify(sw.ToString());
        }

        [Fact]
        public void RunMinesweeperWithBombsInCorners()
        {
            int[,] board = new int[,] { { 5, 0, 0, 5 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 5, 0, 0, 5 } };
            Minesweeper.CalculateNeighbours(4, 4, board);

            var sw = new StringWriter();
            Console.SetOut(sw);
            string result = sw.ToString();

            Minesweeper.PrintOutTheGrid(4, 4, board);

            Approvals.Verify(sw.ToString());
        }

        [Fact]
        public void runMinesweeperWithBombsInDiagonals()
        {
            int[,] board = new int[,] { { 5, 0, 0, 5 }, { 0, 5, 5, 0 }, { 0, 5, 5, 0 }, { 5, 0, 0, 5 } };
            Minesweeper.CalculateNeighbours(4, 4, board);

            var sw = new StringWriter();
            Console.SetOut(sw);
            string result = sw.ToString();

            Minesweeper.PrintOutTheGrid(4, 4, board);

            Approvals.Verify(sw.ToString());
        }

        [Fact]
        public void runMinesweeperWithSmallGrid()
        {
            int[,] board = new int[,] { { 5, 5 }, { 5, 5 } };
            Minesweeper.CalculateNeighbours(2, 2, board);

            var sw = new StringWriter();
            Console.SetOut(sw);
            string result = sw.ToString();

            Minesweeper.PrintOutTheGrid(2, 2, board);

            Approvals.Verify(sw.ToString());
        }
    }
}
