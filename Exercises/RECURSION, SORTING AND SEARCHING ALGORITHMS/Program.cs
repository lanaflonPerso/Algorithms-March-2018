using System;
using System.Linq;
using System.Collections.Generic;

namespace RECURSION__SORTING_AND_SEARCHING_ALGORITHMS
{
    class Program
    {
        static void Main(string[] args)
        {
            // 1. Recursive array sum
            // int[] numbers = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
            // int sum = sumDigitsInArray(numbers);
            // Console.WriteLine(sum);

            // 2. Recursive factorial
            // int number = int.Parse(Console.ReadLine());
            // int factorial = calculateFactorial(number);

            // 3. Recursive drawing
            // int number = int.Parse(Console.ReadLine());
            // drawFigure(number);

            // 4. Generate 0/1 vectors
            // int number = int.Parse(Console.ReadLine());
            // int[] emptyArray = new int[number];
            // generateVectors(number, emptyArray, 0);

            // 5. Generating combinations
            // int[] numbers = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
            // int number = int.Parse(Console.ReadLine());
            // int[] emptyArray = new int[number];
            // generateCombinations(numbers, emptyArray, 0, -1);

            // 8 Queens Puzzle
            // string[,] chessBoard = new string[,]
            // {
            //     {"-", "-", "-", "-", "-", "-", "-", "-"},
            //     {"-", "-", "-", "-", "-", "-", "-", "-"},
            //     {"-", "-", "-", "-", "-", "-", "-", "-"},
            //     {"-", "-", "-", "-", "-", "-", "-", "-"},
            //     {"-", "-", "-", "-", "-", "-", "-", "-"},
            //     {"-", "-", "-", "-", "-", "-", "-", "-"},
            //     {"-", "-", "-", "-", "-", "-", "-", "-"},
            //     {"-", "-", "-", "-", "-", "-", "-", "-"},
            // };

            // findAll8QueensPuzzleSolutions(chessBoard, 0);

            // Find All Paths in a Labyrinth
            // int rows = int.Parse(Console.ReadLine());
            // int cols = int.Parse(Console.ReadLine());
            // string[,] labyrinth = new string[rows, cols];
            // for (int i = 0; i < rows; i++)
            // {
            //     string line = Console.ReadLine();
            //     for (int j = 0; j < cols; j++)
            //     {
            //         labyrinth[i, j] = line[j].ToString();
            //     }
            // }

            // findAllPathsInLabyrinth(labyrinth, new List<string>(), 0, 0, "");

            // 1. Permutations without Repetitions
            // string[] input = Console.ReadLine().Split();
            // generatePermutationsWithoutRepetition(input, 0);

            // 2. Permutations with Repetitions
            // string[] input = Console.ReadLine().Split();
            // generatePermutationsWithRepetition(input);

            // 3. Variations without Repetitions
            // string[] input = Console.ReadLine().Split();
            // int count = int.Parse(Console.ReadLine());
            // generateVariationsWithoutRepetition(input, count);

            // 4. Variations with Repetition
            string[] input = Console.ReadLine().Split();
            int count = int.Parse(Console.ReadLine());
            string[] vector = new string[count];
            generateVariationsWithRepetition(input, vector, 0);

            // 5. Combinations without Repetition
            // string[] input = Console.ReadLine().Split(' ');
            // int count = int.Parse(Console.ReadLine());
            // string[] vector = new string[count];
            // combinationsWithoutRepetition(input, vector, 0);
        }

        static void combinationsWithoutRepetition(string[] input, string[] vector, int index)
        {
            if (index > vector.Length) {
                Console.WriteLine(string.Join(' ', vector));
            } else {
                for (int i = index; i < input.Length; i++)
                {
                    vector[index] = input[i];
                    combinationsWithoutRepetition(input, vector, index + 1);
                }
            }
        }

        static void generateVariationsWithRepetition(string[] input, string[] vector, int index)
        {
            if (index >= vector.Length) {
                Console.WriteLine(string.Join(' ', vector));
            } else {
                for (int i = 0; i < input.Length; i++)
                {
                    vector[index] = input[i];
                    generateVariationsWithRepetition(input, vector, index + 1);
                }
            }
        }

        static void generatePermutationsWithRepetition(string[] input, int? end = null, int start = 0)
        {
            if (end == null)
            {
                end = input.Length - 1;
            }

            Console.WriteLine(string.Join(" ", input));

            for (int left = end.Value - 1; left >= start; left--)
            {
                for (int right = left + 1; right <= end; right++)
                    if (input[left].CompareTo(input[right]) != 0)
                    {
                        swap(ref input[left], ref input[right]);
                        generatePermutationsWithRepetition(input, end, left + 1);
                    }

                var firstElement = input[left];

                for (int i = left; i <= end.Value - 1; i++)
                {
                    input[i] = input[i + 1];
                }

                input[end.Value] = firstElement;
            }
        }

        static void generatePermutationsWithoutRepetition(string[] input, int index)
        {
            if (index >= input.Length)
                Console.WriteLine(string.Join(" ", input));
            else
            {
                generatePermutationsWithoutRepetition(input, index + 1);
                for (int i = index + 1; i < input.Length; i++)
                {
                    swap(ref input[index], ref input[i]);
                    generatePermutationsWithoutRepetition(input, index + 1);
                    swap(ref input[index], ref input[i]);
                }
            }
        }

        static void swap(ref string item1, ref string item2)
        {
            string temp = item1;
            item1 = item2;
            item2 = temp;
        }

        static void findAllPathsInLabyrinth(string[,] labyrinth, List<string> path, int row, int col, string direction)
        {
            if (row >= 0 && col >= 0 && row < labyrinth.GetLength(0) && col < labyrinth.GetLength(1) && labyrinth[row, col] == "e")
            {
                path.Add(direction);
                Console.WriteLine(string.Join("", path));
                path.RemoveAt(path.Count - 1);
            }
            else
            {
                if (isValidPositionInLabyrinth(labyrinth, row, col))
                {
                    labyrinth[row, col] = "v";
                    path.Add(direction);
                    findAllPathsInLabyrinth(labyrinth, path, row, col + 1, "R");
                    findAllPathsInLabyrinth(labyrinth, path, row + 1, col, "D");
                    findAllPathsInLabyrinth(labyrinth, path, row, col - 1, "L");
                    findAllPathsInLabyrinth(labyrinth, path, row - 1, col, "U");
                    labyrinth[row, col] = "v";
                    path.RemoveAt(path.Count - 1);
                }
            }
        }

        static bool isValidPositionInLabyrinth(string[,] labyrinth, int row, int col)
        {
            return row >= 0 && row < labyrinth.GetLength(0) && col >= 0 && col < labyrinth.GetLength(1) && labyrinth[row, col] != "*" && labyrinth[row, col] != "v";
        }

        static void findAll8QueensPuzzleSolutions(string[,] chessBoard, int row)
        {
            if (row == 8)
            {
                printChessBoard(chessBoard);
            }
            else
            {
                for (int col = 0; col < 8; col++)
                {
                    if (isValidPosition(chessBoard, row, col))
                    {
                        chessBoard[row, col] = "*";
                        markAttackedCells(chessBoard, row, col);
                        findAll8QueensPuzzleSolutions(chessBoard, row + 1);
                        chessBoard[row, col] = "-";
                        unMarkAttackedCells(chessBoard, row, col);
                    }
                }
            }
        }

        static void printChessBoard(string[,] chessBoard)
        {
            for (int i = 0; i < chessBoard.GetLength(0); i++)
            {
                for (int j = 0; j < chessBoard.GetLength(1); j++)
                {
                    if (chessBoard[i, j] == "*")
                    {
                        Console.Write(chessBoard[i, j] + " ");
                    }
                    else
                    {
                        Console.Write("- ");
                    }

                }
                Console.WriteLine();
            }
            Console.WriteLine();
        }

        static bool isValidPosition(string[,] chessBoard, int row, int col)
        {
            return row >= 0 && row < chessBoard.GetLength(0) && col >= 0 && col < chessBoard.GetLength(1) && chessBoard[row, col] != "*" && !chessBoard[row, col].Contains("a");
        }

        static void markAttackedCells(string[,] chessBoard, int row, int col)
        {
            string attackCellName = row + "" + col + "a";
            string regularCellName = "-";
            for (int i = 0; i < 8; i++)
            {
                if (chessBoard[row, i] == regularCellName)
                {
                    chessBoard[row, i] = attackCellName;
                }

                if (chessBoard[i, col] == regularCellName)
                {
                    chessBoard[i, col] = attackCellName;
                }
            }
            int colLeftDiagonal = col;
            int colRightDiagonal = col;
            for (int i = row + 1; i < chessBoard.GetLength(0); i++)
            {
                if (colRightDiagonal + 1 < chessBoard.GetLength(1) && chessBoard[i, ++colRightDiagonal] == regularCellName)
                {
                    chessBoard[i, colRightDiagonal] = attackCellName;
                }

                if (colLeftDiagonal > 0 && chessBoard[i, --colLeftDiagonal] == regularCellName)
                {
                    chessBoard[i, colLeftDiagonal] = attackCellName;
                }
            }
            colLeftDiagonal = col;
            colRightDiagonal = col;
            for (int i = row - 1; i > 0; i--)
            {
                if (colRightDiagonal + 1 < chessBoard.GetLength(1) && chessBoard[i, ++colRightDiagonal] == regularCellName)
                {
                    chessBoard[i, colRightDiagonal] = attackCellName;
                }

                if (colLeftDiagonal > 0 && chessBoard[i, --colLeftDiagonal] == regularCellName)
                {
                    chessBoard[i, colLeftDiagonal] = attackCellName;
                }
            }
        }

        static void unMarkAttackedCells(string[,] chessBoard, int row, int col)
        {
            string attackCellName = row + "" + col + "a";
            string regularCellName = "-";
            for (int i = 0; i < chessBoard.GetLength(0); i++)
            {
                if (chessBoard[row, i] == attackCellName)
                {
                    chessBoard[row, i] = regularCellName;
                }

                if (chessBoard[i, col] == attackCellName)
                {
                    chessBoard[i, col] = regularCellName;
                }
            }

            int colLeftDiagonal = col;
            int colRightDiagonal = col;
            for (int i = row + 1; i < chessBoard.GetLength(0); i++)
            {
                if (colRightDiagonal + 1 < chessBoard.GetLength(1) && chessBoard[i, ++colRightDiagonal] == attackCellName)
                {
                    chessBoard[i, colRightDiagonal] = regularCellName;
                }

                if (colLeftDiagonal > 0 && chessBoard[i, --colLeftDiagonal] == attackCellName)
                {
                    chessBoard[i, colLeftDiagonal] = regularCellName;
                }
            }
            colLeftDiagonal = col;
            colRightDiagonal = col;
            for (int i = row - 1; i > 0; i--)
            {
                if (colRightDiagonal + 1 < chessBoard.GetLength(1) && chessBoard[i, ++colRightDiagonal] == attackCellName)
                {
                    chessBoard[i, colRightDiagonal] = regularCellName;
                }

                if (colLeftDiagonal > 0 && chessBoard[i, --colLeftDiagonal] == attackCellName)
                {
                    chessBoard[i, colLeftDiagonal] = regularCellName;
                }
            }
        }

        static void generateCombinations(int[] numbers, int[] resultNumbers, int index, int border)
        {
            if (index == resultNumbers.Length)
            {
                Console.WriteLine(string.Join(" ", resultNumbers));
            }
            else
            {
                for (int i = border + 1; i < numbers.Length; i++)
                {
                    resultNumbers[index] = numbers[i];
                    generateCombinations(numbers, resultNumbers, index + 1, i);
                }
            }
        }

        static void generateVectors(int number, int[] array, int index)
        {
            if (index == array.Length)
            {
                Console.WriteLine(string.Join("", array));
            }
            else
            {
                for (int i = 0; i < 2; i++)
                {
                    array[index] = i;
                    generateVectors(number, array, index + 1);
                }
            }
        }

        static void drawFigure(int number)
        {
            if (number == 0)
            {
                return;
            }

            Console.WriteLine(new string('*', number));

            drawFigure(number - 1);

            Console.WriteLine(new string('#', number));
        }

        static int calculateFactorial(int number)
        {
            if (number == 0)
            {
                return 1;
            }

            return number * calculateFactorial(number - 1);
        }

        static int sumDigitsInArray(int[] numbers)
        {
            if (numbers.Length == 1)
            {
                return numbers[0];
            }

            int firstNumber = numbers[0];
            int[] numbersWithoutFirstNumber = numbers.Skip(1).ToArray();

            int sum = firstNumber + sumDigitsInArray(numbersWithoutFirstNumber);

            return sum;
        }
    }
}
