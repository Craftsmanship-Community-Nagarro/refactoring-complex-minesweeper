using ApprovalTests;
using ApprovalTests.Reporters;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using ApprovalTests.Combinations;
using Xunit;

namespace MineSweeper.Tests
{
    [UseReporter(typeof(DiffReporter))]
    public class MineSweeperTest
    {
        [Fact]
        [UseReporter(typeof(DiffReporter))]
        public void VerifyAllCombinations()
        {
            IEnumerable<int> gridWidthValues = new List<int>() { 2, 3, 4 };
            IEnumerable<int> gridHeightValues = new List<int>() { 2, 3, 4 };
            IEnumerable<int> numberOfMinesValues = new List<int>() { 0, 1, 2, 3, 4 };
            IEnumerable<int> randomSeedValues = Enumerable.Range(1, 4).ToList();

            CombinationApprovals.VerifyAllCombinations(
                this.MinesweeperMainForTest,
                gridWidthValues,
                gridHeightValues,
                numberOfMinesValues,
                randomSeedValues);
        }

        private string MinesweeperMainForTest(
            int gridWith,
            int gridHeight,
            int numberOfMines,
            int randomSeed)
        {
            var outputWriter = new StringWriter();
            Console.SetOut(outputWriter);

            Minesweeper.RandomGenerator = new Random(randomSeed);

            Minesweeper.Main(new string[] {
                gridWith.ToString(),
                gridHeight.ToString(),
                numberOfMines.ToString()
            });

            return outputWriter.ToString();
        }
    }
}
