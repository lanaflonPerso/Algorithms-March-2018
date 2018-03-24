import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class p02_secCover {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] elements = reader.readLine().substring(10).split(", ");
        int[] universe = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            universe[i] = Integer.parseInt(elements[i]);
        }

        int numberOfSets = Integer.parseInt(reader.readLine().substring(16));
        List<int[]> sets = new ArrayList<>();
        for (int i = 0; i < numberOfSets; i++) {
            String[] setElements = reader.readLine().split(", ");
            int[] set = new int[setElements.length];
            for (int j = 0; j < setElements.length; j++) {
                set[j] = Integer.parseInt(setElements[j]);
            }
            sets.add(set);
        }

        List<int[]> choosenSets = chooseSets(sets, universe);

        System.out.println(String.format("Sets to take (%d):", choosenSets.size()));

        for (int[] set : choosenSets) {
            System.out.println(String.format("{ %s }", Arrays.stream(set).mapToObj(String::valueOf).collect(Collectors.joining(", "))));
        }
    }

    public static List<int[]> chooseSets(List<int[]> sets, int[] universe) {
        List<int[]> result = new ArrayList<>();
        List<Integer> universeList = Arrays.stream(universe).boxed().collect(Collectors.toList());
        List<int[]> usedArrays = new ArrayList<>();

        while (universeList.size() > 0) {
            int[] neededArray = sets
                    .stream()
                    .filter(arr -> !usedArrays.contains(arr))
                    .sorted((arr1, arr2) -> Long.compare(Arrays.stream(arr2).filter(universeList::contains).count(), Arrays.stream(arr1).filter(universeList::contains).count()))
                    .findFirst()
                    .orElse(null);

            result.add(neededArray);
            usedArrays.add(neededArray);
            for (int i : neededArray) {
                universeList.remove(new Integer(i));
            }
        }
        return result;
    }
}
