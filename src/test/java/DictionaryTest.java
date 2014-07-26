import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class DictionaryTest {
    Trie trie = mock(Trie.class);

    @Test
    public void preprocessShould_ignoreCases() throws Exception{
        String path = System.getProperty("user.dir") + "/src/testDict";
        Dictionary dictionary = new Dictionary(path);
        dictionary.trie = this.trie;
        ArgumentCaptor<String> wordCaptor = ArgumentCaptor.forClass(String.class);
        dictionary.preprocess();
        verify(trie, times(3)).add(wordCaptor.capture());
        List<String> words = wordCaptor.getAllValues();
        //abc
        //aAa
        //aD
        List<String> expected = new ArrayList<String>(Arrays.asList("abc", "aaa", "ad"));
        assertArrayEquals(expected.toArray(), words.toArray());
    }
}
