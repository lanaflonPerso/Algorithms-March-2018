using System;
using System.Collections.Generic;

namespace Recursion__Sorting_and_Searching_Algorithms___Exercise
{
    class Program
    {
        static void Main(string[] args)
        {
            // 1. Reverse Array
            // string[] array = Console.ReadLine().Split(' ');
            // string[] reversedArray = reverse(array, new string[array.Length], 0, array.Length - 1);
            // Console.WriteLine(string.Join(' ', reversedArray));

            // 2. Nested Loops To Recursion
            // int n = int.Parse(Console.ReadLine());
            // int[] vector = new int[n];
            // generateCombinations(0, vector);

            // 3. Combinations with Repetition
            // int n = int.Parse(Console.ReadLine());
            // int k = int.Parse(Console.ReadLine());
            // int[] vector = new int[k];
            // generateCombinationsWithRepetitions(n, vector, 0, 1);

            // 4. Towers of Hanoi
            // int n = int.Parse(Console.ReadLine());
            // List<int> source = new List<int>();
            // for (int i = n; i > 0; i--)
            // {
            //     source.Add(i);
            // }
            // List<int> spare = new List<int>();
            // List<int> destination = new List<int>();
            // moveTowersOfHanoi(source, spare, destination);

            // 5. Combinations without Repetition
            // int n = int.Parse(Console.ReadLine());
            // int k = int.Parse(Console.ReadLine());
            // int[] vector = new int[k];
            // generateCombinationsWithoutRepetitions(n, vector, 0, 1);
        }

        // static void generateCombinationsWithoutRepetitions(int n, int[] vector, int index, int border)
        // {
        //     if (index == vector.Length)
        //     {
        //         Console.WriteLine(string.Join(' ', vector));
        //     }
        //     else
        //     {
        //         for (int i = border; i <= n; i++)
        //         {
        //             vector[index] = i;
        //             generateCombinationsWithoutRepetitions(n, vector, index + 1, i + 1);
        //         }
        //     }
        // }
        // static void moveTowersOfHanoi(List<int> source, List<int> spare, List<int> destination)
        // {

        //     int sourceElement = source[source.Count - 1];

        //     if (destination.Count == 0 || sourceElement < destination[destination.Count - 1])
        //     {
        //         destination.Add(sourceElement);
        //         source.RemoveAt(source.Count - 1);
        //         sourceElement = source[source.Count - 1];
        //     }
        //     if (spare.Count == 0 || sourceElement < spare[spare.Count - 1])
        //     {
        //         spare.Add(sourceElement);
        //         source.RemoveAt(source.Count - 1);
        //     }


        //     moveTowersOfHanoi(source, spare, destination);

        //     // if ()
        //     // {

        //     // }
        //     // else
        //     // {

        //     //     if (c is perspective candidate)
        //     //     {
        //     //         MarkPositionVisited(c);
        //     //         Backtracking(c);
        //     //         UnmarkPositionVisited(c);
        //     //     }
        //     // }
        // }

        // static void generateCombinationsWithRepetitions(int n, int[] vector, int index, int border)
        // {
        //     if (index == vector.Length)
        //     {
        //         Console.WriteLine(string.Join(' ', vector));
        //     }
        //     else
        //     {
        //         for (int i = border; i <= n; i++)
        //         {
        //             vector[index] = i;
        //             generateCombinationsWithRepetitions(n, vector, index + 1, i);
        //         }
        //     }
        // }

        // static void generateCombinations(int index, int[] vector)
        // {
        //     if (index == vector.Length)
        //     {
        //         Console.WriteLine(string.Join(' ', vector));
        //     }
        //     else
        //     {
        //         for (int i = 1; i <= vector.Length; i++)
        //         {
        //             vector[index] = i;
        //             generateCombinations(index + 1, vector);
        //         }
        //     }
        // }

        static string[] reverse(string[] array, string[] reversedArray, int indexOfArray, int indexOfReversedArray)
        {
            if (indexOfArray == array.Length)
            {
                return reversedArray;
            }

            reversedArray[indexOfReversedArray] = array[indexOfArray];

            return reverse(array, reversedArray, indexOfArray + 1, indexOfReversedArray - 1);
        }
    }
}
