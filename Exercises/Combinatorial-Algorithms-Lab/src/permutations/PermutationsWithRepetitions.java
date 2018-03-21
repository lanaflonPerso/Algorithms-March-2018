package permutations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PermutationsWithRepetitions {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = String.join("", reader.readLine().split(" "));
        Set<String> permutations = getPermutations(str);

        for(String s : permutations){
            String[] permutation = s.split("");
            System.out.println(String.join(" ", permutation));
        }

    }

    private static Set<String> getPermutations(String remained){
        if(remained.length() <= 1){
            Set<String> set = new LinkedHashSet<>();
            set.add(remained);
            return set;
        }

        char c = remained.charAt(0);
        Set<String> old_permutations = getPermutations(remained.substring(1));
        Set<String> new_permutations = new LinkedHashSet<>();

        for(String old_s : old_permutations){
            for(int j = 0; j < old_s.length(); j++){
                new_permutations.add(old_s.substring(0, j) + c + old_s.substring(j));
            }
            new_permutations.add(old_s + c);
        }

        return new_permutations;
    }
}