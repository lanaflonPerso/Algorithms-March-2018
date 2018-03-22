package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LinearSearch {
    private static final int INDEX_OF_NUMBER_THAT_NOT_EXIST = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = reader.readLine().split("\\s+");
        String number = reader.readLine();

        int numberPosition = findNumberPosition(numbers, number);
        System.out.println(numberPosition);
    }

    private static int findNumberPosition(String[] numbers, String number) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i].equals(number)) {
                return i;
            }
        }
        return INDEX_OF_NUMBER_THAT_NOT_EXIST;
    }
}
