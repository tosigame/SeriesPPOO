package cs108;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BurrowsWheelerTransformTest {
    private static String toBeOrNotToBe =
            "To be, or not to be, that is the question";
    private static Pair<Integer, String> toBeOrNotToBeBWT =
            new Pair<>(11, "ootr,e,steenh  hbbuttt o Tti n oieao  s q");

    @Test
    public void forwardTransformOfEmptyStringFails() {
        assertThrows(IllegalArgumentException.class, () -> {
            BurrowsWheelerTransform.forward("");
        });
    }

    @Test
    public void forwardTransformOfTrivialStringIsCorrect() {
        assertEquals(new Pair<>(0, "a"), BurrowsWheelerTransform.forward("a"));
    }

    @Test
    public void forwardTransformOfKnownStringIsCorrect() {
        assertEquals(toBeOrNotToBeBWT, BurrowsWheelerTransform.forward(toBeOrNotToBe));
    }

    @Test
    public void backwardTransformWithEmptyStringFails() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            BurrowsWheelerTransform.backward(new Pair<>(0, ""));
        });
    }

    @Test
    public void backwardTransformWithNegativeIndexFails() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            BurrowsWheelerTransform.backward(new Pair<>(-1, "test"));
        });
    }

    @Test
    public void backwardTransformWithTooBigIndexFails() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            BurrowsWheelerTransform.backward(new Pair<>(4, "test"));
        });
    }

    @Test
    public void backwardTransformOfKnownPairIsCorrect() {
        assertEquals(toBeOrNotToBe, BurrowsWheelerTransform.backward(toBeOrNotToBeBWT));
    }

    @Test
    public void backwardTransformOfRandomStringIsInverseOfForwardTransform() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz 0123456789,.;:!?";
        Random rng = new Random();
        for (int i = 0; i < 1000; ++i) {
            StringBuilder b = new StringBuilder();
            for (int l = 0; l < 1 + rng.nextInt(100); ++l)
                b.append(alphabet.charAt(rng.nextInt(alphabet.length())));
            String s = b.toString();
            assertEquals(s, BurrowsWheelerTransform.backward(BurrowsWheelerTransform.forward(s)));
        }
    }
}
