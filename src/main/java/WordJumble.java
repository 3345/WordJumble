import java.util.*;
import java.util.concurrent.TimeUnit;

public class WordJumble {
    static final String FILE_PATH = "/src/dict.txt";
    static final int MAX_UNIQUE_CHARS = 16;
    static final int MAX_LENGTH = 30;

    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + FILE_PATH;
        Dictionary dictionary = new Dictionary(path);
        System.out.println("initializing dictionary...");
        dictionary.preprocess();
        Scanner userInputScanner = new Scanner(System.in);
        System.out.print("Enter a word or % to quit: ");
        String input = userInputScanner.nextLine();
        if (input.equals("%"))
            return;
        while (!input.equals("%")) {
            long startTime = System.currentTimeMillis();
            try {
                validate(input);
                input = input.toLowerCase();
                List<String> findings = dictionary.find(input);
                System.out.println("Found: " + findings);
                System.out.println(String.format("%d words found in %d seconds", findings.size(),
                        TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - startTime)));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.print("Enter a word or % to quit: ");
            input = userInputScanner.nextLine();
        }
        System.out.println("Game over");

    }

    private static void validate(String input) throws Exception {
        if (input.length() > MAX_LENGTH)
            throw new Exception("word can be no longer than 30 characters");
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < input.length(); i++) {
            set.add(input.charAt(i));
            if (!Character.isLetter(input.charAt(i)))
                throw new Exception("Word can only has letters");
        }
        if (set.size() > MAX_UNIQUE_CHARS)
            throw new Exception(String.format("word can not have more than %d unique characters", MAX_UNIQUE_CHARS));
    }

}
