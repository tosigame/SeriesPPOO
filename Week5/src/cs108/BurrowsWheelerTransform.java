package cs108;

import java.util.*;
import java.util.stream.Collectors;

public final class BurrowsWheelerTransform {
    private BurrowsWheelerTransform() {}

    public static Pair<Integer, String> forward(String s) {
        if(s.isEmpty()){throw new IllegalStateException();}

        Queue<Character> queue=new LinkedList<>(){};
        List<Character> characters=s.chars().mapToObj(e->(char) e).collect(Collectors.toList());
        System.out.println(Arrays.toString(characters.toArray()));

        return null;
        //throw new Error("à faire");
    }

    public static String backward(Pair<Integer, String> p) {
        throw new Error("à faire");
    }
}
