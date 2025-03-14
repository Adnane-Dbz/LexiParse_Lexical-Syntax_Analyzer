import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Transition {
    private final Set<Character> inputs;
    private final Eta targetState;

    // Constructor accepts multiple characters for the transition
    public Transition(Eta targetState, char... inputs) {
        this.targetState = targetState;
        this.inputs = new HashSet<>();
        for (char input : inputs) {
            this.inputs.add(input);
        }
    }

    public Eta getTargetState() {
        return targetState;
    }

    // Method to check if a character matches any of the allowed inputs
    public boolean matches(char input) {
        return inputs.contains(input);
    }

    public static char[] giveme(String... excludedCharacters) {
        // Create a set of excluded characters for quick lookup
        Set<Character> excludedSet = new HashSet<>();
        for (String s : excludedCharacters) {
            if (s.length() == 1) { // Ensure it's a single character string
                excludedSet.add(s.charAt(0));
            }
        }

        // Use StringBuilder to collect allowed characters
        StringBuilder result = new StringBuilder();

        // Add all alphabets except excluded ones
        for (char c = 'a'; c <= 'z'; c++) {
            if (!excludedSet.contains(c)) {
                result.append(c);
            }
        }

        for (char c = 'A'; c <= 'Z'; c++) {
            if (!excludedSet.contains(c)) {
                result.append(c);
            }
        }

        // Add all digits except excluded ones
        for (char c = '0'; c <= '9'; c++) {
            if (!excludedSet.contains(c)) {
                result.append(c);
            }
        }

        // Convert to char[] and return
        return result.toString().toCharArray();
    }


}
