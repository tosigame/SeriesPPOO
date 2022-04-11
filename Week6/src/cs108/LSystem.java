package cs108;

import java.util.*;
import java.util.stream.Collectors;
import static java.util.Collections.unmodifiableSet;

public final class LSystem {

    private final String string;
    private final Map<Character, String> rules;
    private final Set<Character> lineChars;
    private final int turningAngle;

    private LSystem(String string, Map<Character, String> rules, Set<Character> lineChars, int turningAngle) {
        this.string = string;
        this.rules = rules;
        this.lineChars = lineChars;
        this.turningAngle = turningAngle;
    }
    public LSystem(String string,
                   Map<Character, String> rules,
                   String lineChars,
                   int turningAngle) {
        this(string,
                Map.copyOf(rules),
                setFromString(lineChars),
                turningAngle);
    }

    private static Set<Character> setFromString(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); ++i)
            set.add(s.charAt(i));
        return unmodifiableSet(set);
    }

    public String string() {
        return string;
    }

    public Map<Character, String> rules() {

        return rules;
    }

    public Set<Character> lineChars() {

        return lineChars;
    }

    public int turningAngle() {


        return turningAngle;
    }

    public LSystem evolve() {
        // TODO: à compléter (exercice 2)
        StringBuilder newString= new StringBuilder();
        for (int i = 0; i <string.length() ; i++) {


           char c=string.charAt(i);
           newString.append(rules.getOrDefault(c,String.valueOf(c)));
        }
        return new LSystem(newString.toString(),rules,setFromString(newString.toString()),turningAngle);
    }

    public LSystem evolve(int steps) {
        LSystem lSystem=this;
        for (int i = 0; i < steps; i++) {
            lSystem=lSystem.evolve();
        }
        return lSystem;
    }
}
