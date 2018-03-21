import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CombinationsWithRepetitions {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());
        String[] vector = new String[k];
        generate(n, vector, 0, 1);
    }

    private static void generate(int n, String[] vector, int index, int border) {
        if (index == vector.length) {
            System.out.println(String.join(" ", vector));
        } else {
            for (int i = border; i <= n; i++) {
                vector[index] = String.valueOf(i);
                generate(n, vector, index + 1, i);
            }
        }
    }
}
