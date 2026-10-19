class WordDictionary {

    public static class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public boolean isWord = false;
    }

    public static TrieNode root;

    public WordDictionary() {
        root = new TrieNode();

    }

    public void addWord(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            int index  = ch - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }

        current.isWord = true;
    }

    public boolean search(String word) {

        return search(word, root);

    }

    public boolean search(String word, TrieNode current) {

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch != '.') {
                int index = ch - 'a';
                if (current.children[index] == null) {
                    return false;
                }
                current = current.children[index];
            } else {
                boolean isPresent = false;
                for(int j = 0; j < 26; j++) {
                    if (current.children[j] == null) continue;
                    isPresent = search(word.substring(i+1, word.length()), current.children[j]);
                    if (isPresent) return true;
                }
                return isPresent;
            }
            

        }
        return current.isWord;

    }
}
