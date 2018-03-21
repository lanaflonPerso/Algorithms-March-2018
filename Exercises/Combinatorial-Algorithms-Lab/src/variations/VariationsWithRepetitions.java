package variations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VariationsWithRepetitions {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        int count = Integer.parseInt(reader.readLine());
        String[] vector = new String[count];
        generate(input, vector, 0);
    }

    private static void generate(String[] input, String[] vector, int index) {
        if (index >= vector.length) {
            System.out.println(String.join(" ", vector));
        } else {
            for (String letter : input) {
                vector[index] = letter;
                generate(input, vector, index + 1);
            }
        }
    }
}
