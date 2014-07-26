import java.util.*;


public class Combination {
    /**
     * @return all sorted combinations of characters in a word of all possible length, no duplication.
     * eg. "aba" -> [[a],[b],[a,a],[a,b],[a,a,b]]
     */
    public static List<List<Character>> combination(String word) {
        ArrayList<List<Character>> result = new ArrayList<List<Character>>();
        for (int i = 1; i < word.length() + 1; i ++) {
            result.addAll(combine(word, i));
        }
        return result;
    }

    /**
     * @return all sorted combinations of characters in a word of all possible length, no duplication.
     * eg. "aba", 2 -> [[a],[b],[a,a],[a,b]]
     */
    public static List<List<Character>> combination(String word, int k) {
        ArrayList<List<Character>> result = new ArrayList<List<Character>>();
        for (int i = 1; i <= k; i ++) {
            result.addAll(combine(word, i));
        }
        return result;
    }

    /**
     * @return all sorted length k combinations of characters in a word, no duplication
     * eg. "aba", 2 -> [[a,b],[a,a]]
     */
    public static List<List<Character>> combine(String word, int k) {
        List<Character> list = new ArrayList<Character>();

        for (int i = 0; i < word.length(); i ++) {
            list.add(word.charAt(i));
        }
        Collections.sort(list);
        return comb(k, list);
    }

    public static List<List<Character>> comb(int k, List<Character> list) {
        List<List<Character>> result = new ArrayList<List<Character>>();
        Set<Character> visited = new HashSet<Character>();

        if (k > list.size() || k <= 0)
            return result;
        if (k == 1) {
            for (Character c : list) {
                if (!visited.contains(c)) {
                    List<Character> charList = new ArrayList<Character>();
                    charList.add(c);
                    result.add(charList);
                    visited.add(c);
                }
            }
            return result;
        }

        for (int i = 0; i <= list.size() - k; i ++) {
            if (!visited.contains(list.get(i))) {
                List<List<Character>> prevResult = comb(k - 1, list.subList(i + 1, list.size()));
                for (List<Character> subResult : prevResult) {
                    subResult.add(0, list.get(i));
                    result.add(subResult);
                }
                visited.add(list.get(i));
            }
        }

        return result;
    }
}
