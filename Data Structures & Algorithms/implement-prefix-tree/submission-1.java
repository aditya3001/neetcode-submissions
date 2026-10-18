class PrefixTree {

    public static class PrefixTreeNode {
        private PrefixTreeNode[] children = new PrefixTreeNode[26];;
        private boolean isWord = false;
    }

    private PrefixTreeNode root;

    public PrefixTree() {
        root = new PrefixTreeNode();
    }

    public void insert(String word) {

        PrefixTreeNode current = root;

        for(char c : word.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                current.children[c-'a'] = new PrefixTreeNode();

            }
            current = current.children[c-'a'];

        }
        current.isWord = true;

    }

    public boolean search(String word) {
        PrefixTreeNode current = root;
        for(char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                return false;
            } 
            current = current.children[index];
        }
        return current!= null && current.isWord;
    }

    public boolean startsWith(String prefix) {
        PrefixTreeNode current = root;
        for(char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                return false;
            } 
            current = current.children[index];
        }
        return current!= null;
    }
}
