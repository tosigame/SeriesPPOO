package cs108;

import java.util.*;
import java.util.stream.Collectors;

public final class BurrowsWheelerTransform {
    private BurrowsWheelerTransform() {}

    public static Pair<Integer, String> forward(String s) {
        if(s.isEmpty()){throw new IllegalArgumentException();}

        List<Pair<Integer,String>> rotations=new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            rotations.add(new Pair<>(i,s.substring(s.length()-i)+s.substring(0,s.length()-i)));
        }
        var OG=rotations.get(0);
        rotations.sort(Comparator.comparing(Pair::second));

        String str="";
        for (int i = 0; i < rotations.size(); i++) {
            str+=rotations.get(i).second().charAt(s.length()-1);
        }
        //rotations.forEach(System.out::println);
        return new Pair<>(rotations.indexOf(OG), str);
        //throw new Error("à faire");
    }

    public static String backward(Pair<Integer, String> p) {
        throw new Error("à faire");
    }
}
