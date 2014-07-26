import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PermutationTest {
    Permutation permutation = new Permutation();

    @Test
    public void basic() {
        List<Character> chars = new ArrayList<Character>(Arrays.asList('a', 'b', 'c'));
        String actual = permutation.permute(chars).toString();
        String expected = "[[a, b, c], [a, c, b], [b, a, c], [b, c, a], [c, b, a], [c, a, b]]";
        assertEquals(expected, actual);
    }

    @Test
    public void dedup_whenInputContainsDuplicatedChars() {
        List<Character> chars = new ArrayList<Character>(Arrays.asList('a', 'b', 'b'));
        String expected = "[[a, b, b], [b, a, b], [b, b, a]]";
        String actual = permutation.permute(chars).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void returnOne_whenInputCharsAreAllTheSame() {
        List<Character> chars = new ArrayList<Character>(Arrays.asList('b', 'b', 'b'));
        String expected = "[[b, b, b]]";
        String actual = permutation.permute(chars).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void returnListOfStrings_whenCallPermuteAsStrings() {
        List<Character> chars = new ArrayList<Character>(Arrays.asList('a', 'b', 'c'));
        String expected = "[abc, acb, bac, bca, cba, cab]";
        String actual = permutation.permuteAsStrings(chars).toString();
        assertEquals(expected, actual);

    }
}
