package permutations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PermutationsWithoutRepetitions {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        generate(input, 0);
    }

    private static void generate(String[] input, int index) {
        if (index >= input.length)
            System.out.println(String.join(" ", input));
        else {
            generate(input, index + 1);
            for (int i = index + 1; i < input.length; i++) {
                swap(input, index, i);
                generate(input, index + 1);
                swap(input, index, i);
            }
        }
    }

    private static void swap(String[] array, int from, int to) {
        String temp = array[from];
        array[from] = array[to];
        array[to] = temp;
    }
}
