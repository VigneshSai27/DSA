package Tries;

public class TriesMain {

    static Trie trie = new Trie();

    public static void main(String[] args) {
        String[] words = {"apple", "apps", "baby", "boss"};
        for (String word : words) {
            trie.insert(word);
        }
        System.out.println(searchWord("apple"));
        System.out.println(searchWord("apps"));
        System.out.println(prefix("app"));
        System.out.println(prefix("ba"));
        System.out.println(prefix("bay"));
    }

    private static boolean prefix(String word) {
        return trie.prefix(word);
    }

    private static boolean searchWord(String word) {
        return trie.search(word);
    }
}

class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.contains(ch)) {
                node.put(word.charAt(i), new Node());
            }
            node = node.next(ch);
        }
        node.setFlag();
    }

    public boolean search(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.contains(ch))
                return false;
            node = node.next(ch);
        }
        return node.flag;
    }

    public boolean prefix(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.contains(ch))
                return false;
            node = node.next(ch);
        }
        return true;
    }
}

class Node {
    Node[] nodes;
    boolean flag;

    public Node() {
        nodes = new Node[26];
        flag = false;
    }

    public boolean contains(char ch) {
        return nodes[ch - 'a'] != null;
    }

    public void put(char ch, Node node) {
        nodes[ch - 'a'] = node;
    }

    public Node next(char ch) {
        return nodes[ch - 'a'];
    }

    public void setFlag() {
        flag = true;
    }
}