import java.util.Scanner;
import java.util.Vector;

public class Main {
    
    public static void main(String[] args) {
        new Main().start();
    }

    void start() {
        int n, m;
        String s;
        Scanner scanner = new Scanner(System.in);
        Trie trie = new Trie();
        n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            s = scanner.next();
            trie.add(s);
        }
        m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            s = scanner.next();
            System.out.println(trie.prefix(s));
        }
    }

    class Trie {
        private class TrieNode {
            int count;
            Vector<TrieNode> children;
            public TrieNode() {
                children = new Vector<TrieNode>(26);
                children.setSize(26);
                count = 0;
            }
        }

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        void add(String s) {
            TrieNode p = root;
            p.count += 1;
            for (char c : s.toCharArray()) {
                if (p.children.get(c2i(c)) == null) {
                    p.children.set(c2i(c), new TrieNode()); 
                }
                p = p.children.get(c2i(c));
                p.count += 1;
            }
        }

        int prefix(String s) {
            TrieNode p = root;
            for (char c : s.toCharArray()) {
                if (p.children.get(c2i(c)) == null) {
                    return 0;
                }
                p = p.children.get(c2i(c));
            }
            return p.count;
        }

        private int c2i(char c) {
            return c - 'a';
        }
    }
}