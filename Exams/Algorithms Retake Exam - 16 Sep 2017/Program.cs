using System;
using System.Collections.Generic;

namespace Algorithms_Retake_Exam___16_Sep_2017
{
    class Program
    {
        static void Main(string[] args)
        {
            int pockets = int.Parse(Console.ReadLine());
            int balls = int.Parse(Console.ReadLine());
            int maxBallsInPocket = int.Parse(Console.ReadLine());
            int[] vector = new int[pockets];
            List<string> solutions = new List<string>();
            generateAllBallsCombinationsWithoutEmptyPockets(balls, maxBallsInPocket, vector, 0, solutions);
        }

        static void generateAllBallsCombinationsWithoutEmptyPockets(int balls, int maxBallsInPocket, int[] vector, int index, List<string> solutions)
        {
            if (balls <= 0 && index >= vector.Length)
            {
                string solution = string.Join(", ", vector);
                if (!solutions.Contains(solution)) {
                    Console.WriteLine(solution);
                    solutions.Add(solution);
                }
            }

            if (index >= vector.Length)
            {
                return;
            }
            else
            {
                for (int i = balls; i > 0; i--)
                {
                    vector[index] = i;
                    int currentBalls = balls - i;
                    if (vector[index] > maxBallsInPocket) {
                        vector[index] = maxBallsInPocket - currentBalls;
                        currentBalls = balls - vector[index];
                    }
                    generateAllBallsCombinationsWithoutEmptyPockets(currentBalls, maxBallsInPocket, vector, index + 1, solutions);
                }
            }
        }
    }
}
