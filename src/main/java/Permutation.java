import java.util.ArrayList;
import java.util.List;

public class Permutation {
    /**
     * @return permutations without duplication even if input has duplicated characters
     * eg. [a,b,b]->[[a,b,b],[b,a,b],[b,b,a]]
     */
    public static List<List<Character>> permute(List<Character> chars) {
        List<List<Character>> result = new ArrayList<List<Character>>();
        permute(chars, 0, result);
        return result;
    }

    /**
     * @return permutations as strings without duplication even if input has duplicated characters
     * eg. [a,b,b]->["abb","bab","bba"]
     */
    public static List<String> permuteAsStrings(List<Character> chars) {
        List<List<Character>> charLists = new ArrayList<List<Character>>();
        List<String> result = new ArrayList<String>();
        permute(chars, 0, charLists);
        for (List<Character> charList : charLists) {
            StringBuilder sb = new StringBuilder();
            for (Character c : charList) {
                sb.append(c);
            }
            result.add(sb.toString());
        }
        return result;
    }

    public static void permute(List<Character> chars, int start, List<List<Character>> result) {
        if (start >= chars.size()) {
            List<Character> newChars = new ArrayList<Character>(chars);
            result.add(newChars);
        }

        for (int j = start; j <= chars.size() - 1; j++) {
            if (!containsDuplicate(chars, start, j)) {
                swap(chars, start, j);
                permute(chars, start + 1, result);
                swap(chars, start, j);
            }
        }
    }

    public static void swap(List<Character> list, int i, int j) {
        Character temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    private static boolean containsDuplicate(List<Character> chars, int start, int end) {
        for (int i = start; i <= end-1; i++) {
            if (chars.get(i)== chars.get(end)) {
                return true;
            }
        }
        return false;
    }


}
