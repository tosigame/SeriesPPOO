package cs108;

import java.util.*;
import java.util.stream.Collectors;

public final class Polynomial {

    private final Map<Integer, Integer> coefs = new HashMap<>();

    public Polynomial(Map<Integer, Integer> coefs) {
        for (Map.Entry<Integer, Integer> entry : coefs.entrySet()) {
            if (entry.getKey() < 0) {
                throw new IllegalArgumentException();
            } else {
                this.coefs.put(entry.getKey(), entry.getValue());
            }
        }

    }

    public Polynomial add(Polynomial that) {

        System.out.println(that);
        HashMap<Integer, Integer> sumMap = new HashMap<>(coefs);

        for (Map.Entry<Integer, Integer> pair : that.coefs.entrySet()) {
            if (sumMap.containsKey(pair.getKey())) {
                double sum = sumMap.get(pair.getKey()) + pair.getValue();
                if (sum != 0)
                    sumMap.put(pair.getKey(), sumMap.get(pair.getKey()) + pair.getValue());
                //  System.out.println("tyo");
            } else {
                sumMap.put(pair.getKey(), pair.getValue());
            }
        }

        System.out.println();
        // sumMap.forEach((k,v)-> System.out.println("Key: " + k + " value: " + v));
        return new Polynomial(sumMap);
    }

    public double valueAt(double x) {
        double sum = 0;
        for (Map.Entry<Integer, Integer> pair : this.coefs.entrySet()) {
            sum += pair.getValue() * Math.pow(x, pair.getKey());
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        SortedSet<Integer> keys = new TreeSet<>(coefs.keySet());
        Iterator<Integer> it = keys.iterator();
        while (it.hasNext()) {
            int key = it.next();
            stringBuilder.append(((coefs.get(key) != 1) ? ((coefs.get(key) != 0) ? coefs.get(key) : "+") : ""));
            stringBuilder.append(((key != 0) ? "x" : ""));
            stringBuilder.append((key != 1 && key != 0) ? "^" + key : "");
            stringBuilder.append((it.hasNext()) ? ((coefs.get(key) < 0) ? "" : "+") : "");

        }

        return stringBuilder.toString();//.replace("+-", "-").replace("++", "");
    }
}
