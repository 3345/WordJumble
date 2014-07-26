import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {
    Node root;

    public Trie() {
        this.root = new Node('*'); //dummy root
    }

    public void add(String word) {
        if (word == null || word.isEmpty())
            return;
        Node localRoot = root;
        for (int i = 0; i < word.length(); i ++) {
            Character c = word.charAt(i);
            if (localRoot.children.containsKey(c)) {
                localRoot = localRoot.children.get(c);
            } else {
                Node node = new Node(c);
                localRoot.children.put(c, node);
                localRoot = node;
            }
        }
        localRoot.isLeaf = true;
    }

    public boolean contains(String word) {
        if (word == null)
            return false;
        Node currentRoot = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (currentRoot.children.containsKey(c))
                currentRoot = currentRoot.children.get(c);
            else
                return false;
        }
        return currentRoot.isLeaf;
    }

    public boolean contains(List<Character> word) {
        if (word == null)
            return false;
        Node currentRoot = root;
        for (int i = 0; i < word.size(); i++) {
            Character c = word.get(i);
            if (currentRoot.children.containsKey(c))
                currentRoot = currentRoot.children.get(c);
            else
                return false;
        }
        return currentRoot.isLeaf;
    }

    public class Node {
        public Character val;
        public Map<Character, Node> children = new HashMap<Character, Node>();

        // This is a pseudo leaf
        // node is leaf not does not necessarily mean it has no children,
        // rather it flags whether a node is an ending character of a word
        public boolean isLeaf;

        public Node(Character val) {
            this.val = val;
            isLeaf = false;
        }
    }
}


