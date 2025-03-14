import java.util.ArrayList;
import java.util.List;

public class Eta {
    private final String name;
    private final boolean isFinalState;
    private final String tokenType; // Store token type if final state
    private final List<Transition> transitions;

    public Eta(String name, boolean isFinalState, String tokenType) {
        this.name = name;
        this.isFinalState = isFinalState;
        this.tokenType = tokenType;
        this.transitions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public boolean isFinalState() {
        return isFinalState;
    }

    public String getTokenType() {
        return isFinalState ? tokenType : null;
    }

    public void addTransition(Eta targetState, char... inputs) {
        transitions.add(new Transition(targetState, inputs));
    }

    public Eta nextState(char input) {
        for (Transition transition : transitions) {
            if (transition.matches(input)) {
                return transition.getTargetState();
            }
        }
        return null;
    }
}
