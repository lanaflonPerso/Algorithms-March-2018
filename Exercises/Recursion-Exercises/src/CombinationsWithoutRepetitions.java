import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CombinationsWithoutRepetitions {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());
        String[] vector = new String[k];
        generate(n, vector, 0, 1);
    }

    private static void generate(int n, String[] vector, int index, int border) {
        if (index == vector.length) {
            if (distinctValues(vector)) {
                System.out.println(String.join(" ", vector));
            }
        } else {
            for (int i = border; i <= n; i++) {
                vector[index] = String.valueOf(i);
                generate(n, vector, index + 1, i);
            }
        }
    }

    private static boolean distinctValues(String[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].equals(arr[j])) {
                    return false;
                }
            }
        }
        return true;
    }
}
