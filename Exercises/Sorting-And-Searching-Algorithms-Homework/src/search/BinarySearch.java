package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = reader.readLine().split("\\s+");
        int number = Integer.parseInt(reader.readLine());

        int numberPosition = findNumberPosition(numbers, number, 0, numbers.length - 1);
        System.out.println(numberPosition);
    }

    private static int findNumberPosition(String[] numbers, int number, int left, int right) {
        if (left > right) {
            return -1;
        }

        int middleIndex = left + ((right - left) / 2);
        int middleNumber = Integer.parseInt(numbers[middleIndex]);
        if (middleNumber == number) {
            return middleIndex;
        } else if (middleNumber < number) {
            return findNumberPosition(numbers, number, middleIndex + 1, right);
        } else {
            return findNumberPosition(numbers, number, left, middleIndex - 1);
        }
    }
}
