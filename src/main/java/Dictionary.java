import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dictionary {
    public String path;
    public Trie trie;
    public Trie sortedTrie;
    public int maxWordLength;

    public Dictionary(String path) {
        this.path = path;
        this.trie = new Trie();
        this.sortedTrie = new Trie();
    }

    public void preprocess() {
        File file = new File(path);
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line;

            while((line = reader.readLine()) != null) {
                String word = line.toLowerCase();
                maxWordLength = Math.max(maxWordLength, word.length());
                trie.add(word);
                sortedTrie.add(sort(word));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> find(String input) {
        List<String> result = new ArrayList<String>();
        // sub-strings of length greater than max word length in dictionary are guaranteed not
        // to be found. So don't produce them as it is very costly.
        List<List<Character>> charLists = Combination.combination(input, maxWordLength);
        //each charList is sorted !!
        for (List<Character> charList : charLists) {
            //skip if combination does not have a match in sortedTrie
            //this will save a lot of costly permutation computation
            if (sortedTrie.contains(charList)) {
                List<String> words = Permutation.permuteAsStrings(charList);
                for (String word : words) {
                    if (trie.contains(word))
                        result.add(word);
                }
            }
        }
        return result;
    }

    private String sort(String word) {
        char [] arr = word.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }


}
