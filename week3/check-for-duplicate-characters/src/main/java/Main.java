import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // O(n^2)
        System.out.println(containsDuplicateCharacters("dog")); // false
        System.out.println(containsDuplicateCharacters("apple")); // true

        // O(n log n) -> much better than O(n^2)
        System.out.println(containsDuplicateCharactersSorting("dog")); // false
        System.out.println(containsDuplicateCharactersSorting("apple")); // true
    }

    // return true, if there are duplicate characters in the word
    // return false, if there are only unique characters in the word
    // input: dog -> false
    // input: apple: -> true

    // O(n^2)
    public static boolean containsDuplicateCharacters(String word) {
        for (int i = 0; i < word.length() - 1; i++) {
            for (int j = i + 1; j < word.length(); j++) {
                if (word.charAt(i) == word.charAt(j)) {
                    return true;
                }
            }
        }

        return false;
    }

    // O(n log n)

    // # of operations: n log n + n
    // lim(n log n + n) n -> infinity = n log n -> O(n log n)
    public static boolean containsDuplicateCharactersSorting(String word) {
        char[] wordCharArray = word.toCharArray();
        Arrays.sort(wordCharArray); // O(n log n)

        // The reason we can do this is because duplicate characters, if there are any, will be next to each other,
        // since we have sorted the array
        for (int i = 0; i < wordCharArray.length - 1; i++) {
            if (wordCharArray[i] == wordCharArray[i+1]) {
                return true;
            }
        }

        return false;
    }

}
