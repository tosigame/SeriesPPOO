package cs108;

import java.util.Objects;

public final class Pair<F, S> {
    private final F first;
    private final S second;

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public F first() { return first; }
    public S second() { return second; }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }

    @Override
    public boolean equals(Object thatO) {
        if (thatO instanceof Pair) {
            @SuppressWarnings("unchecked")
            Pair<F, S> that = (Pair<F, S>)thatO;
            return first.equals(that.first) && second.equals(that.second);
        } else
            return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
