import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NestedLoops {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] vector = new String[n];
        generateCombinations(0, vector);
    }

    private static void generateCombinations(int index, String[] vector) {
        if (index == vector.length) {
            System.out.println(String.join(" ", vector));
        } else {
            for (int i = 1; i <= vector.length; i++) {
                vector[index] = String.valueOf(i);
                generateCombinations(index + 1, vector);
            }
        }
    }
}
