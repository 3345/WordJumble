import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TrieTest {
    Trie trie;

    @Before
    public void setUp() {
        trie = new Trie();
    }

    @Test
    public void canGetWord_whenWordExist() {
        trie.add("abc");
        assertTrue(trie.contains("abc"));
    }

    @Test
    public void canNotGetWord_whenWordDoesNotExist() {
        trie.add("abc");
        assertFalse(trie.contains("abcd"));
    }

    @Test
    public void nullAndEmptyStringsAreIgnored_whenAdded() {
        trie.add(null);
        trie.add("");
        //assertFalse(trie.contains(null));
        assertFalse(trie.contains(""));
    }

    @Test
    public void canGetWord_whenWordIsSubStringOfExistingWordInTrie() {
        trie.add("abc");
        trie.add("ab");
        assertTrue(trie.contains("ab"));
    }

    @Test
    public void cannotGetWord_whenGettingSubstringOfExistingWord() {
        trie.add("abc");
        assertFalse(trie.contains("ab"));
    }

    @Test
    public void getGetWords_whenWordsHaveDuplicatedCharacters() {
        trie.add("aaa");
        trie.add("a");
        assertTrue(trie.contains("a"));
        assertTrue(trie.contains("aaa"));
        assertFalse(trie.contains("aa"));
    }

    @Test
    public void canGetWords_whenWordsSharePrefixes() {
        trie.add("abc");
        trie.add("abd");
        trie.add("abcd");
        assertTrue(trie.contains("abc"));
        assertTrue(trie.contains("abd"));
        assertTrue(trie.contains("abcd"));
        assertFalse(trie.contains("abdc"));
    }
}
