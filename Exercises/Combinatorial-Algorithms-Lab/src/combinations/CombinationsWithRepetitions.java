package combinations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CombinationsWithRepetitions {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        int count = Integer.parseInt(reader.readLine());
        String[] vector = new String[count];
        generate(input, vector, 0, 0);
    }

    private static void generate(String[] input, String[] vector, int index, int indexOfLastLetter) {
        if (index >= vector.length) {
            System.out.println(String.join(" ", vector));
        } else {
            for (int i = indexOfLastLetter; i < input.length; i++) {
                vector[index] = input[i];
                indexOfLastLetter = Arrays.asList(input).indexOf(vector[index]);
                generate(input, vector, index + 1, indexOfLastLetter);
            }
        }
    }
}