import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseArray {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] array = reader.readLine().split("\\s+");
        String[] reversedArray = reverse(array, new String[array.length], 0, array.length - 1);
        System.out.println(String.join(" ", reversedArray));
    }


    private static String[] reverse(String[] array, String[] reversedArray, int indexOfArray, int indexOfReversedArray) {
        if (indexOfArray == array.length) {
            return reversedArray;
        }

        reversedArray[indexOfReversedArray] = array[indexOfArray];

        return reverse(array, reversedArray, indexOfArray + 1, indexOfReversedArray - 1);
    }
}
