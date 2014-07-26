import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CombinationTest {
    Combination combination = new Combination();

    @Test
    public void combination_shouldReturnCombOfAllLength() {
        String word = "abc";
        String expected = "[[a], [b], [c], [a, b], [a, c], [b, c], [a, b, c]]";
        String actual = combination.combination(word).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void combinationWithLength_shouldReturnCombOfMaxLengthK() {
        String word = "abc";
        assertEquals("[[a], [b], [c], [a, b], [a, c], [b, c]]",
                combination.combination(word,2).toString());
        assertEquals("[[a], [b], [c], [a, b], [a, c], [b, c], [a, b, c]]",
                combination.combination(word,3).toString());

    }

    @Test
    public void combine_shouldReturnCombOfSpecifiedLength() {
        String word = "abcd";
        assertEquals("[[a], [b], [c], [d]]", combination.combine(word, 1).toString());
        assertEquals("[[a, b], [a, c], [a, d], [b, c], [b, d], [c, d]]", combination.combine(word, 2).toString());
        assertEquals("[[a, b, c], [a, b, d], [a, c, d], [b, c, d]]", combination.combine(word, 3).toString());
        assertEquals("[[a, b, c, d]]", combination.combine(word, 4).toString());

    }

    @Test
    public void combine_shouldReturnEmptyList_whenSpecifiedLengthOutOfRange() {
        String word = "abcd";
        assertEquals("[]", combination.combine(word, 0).toString());
        assertEquals("[]", combination.combine(word, 5).toString());

    }

    @Test
    public void dedup_whenInputContainsDuplicatedChars() {
        String word = "aaa";
        assertEquals("[[a, a]]", combination.combine(word, 2).toString());
        assertEquals("[[a, a, a], [a, a, b], [a, b, b], [b, b, b]]", combination.combine("ababbbba", 3).toString());
    }

}
