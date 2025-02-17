class WordDictionary {
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    public TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    // Add a word to the dictionary
    public void addWord(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.isEnd = true; // Mark the end of the word
    }

    // Search helper method to handle '.' wildcard
    public boolean searchHelper(String word, int idx, TrieNode node) {
        if (idx == word.length()) {
            return node.isEnd; 
        }

        char ch = word.charAt(idx);
        if (ch == '.') {
            // If it's a dot, we try all possible children at this point
            for (TrieNode child : node.children) {
                if (child != null && searchHelper(word, idx + 1, child)) {
                    return true;
                }
            }
            return false; // No match found with any child
        } else {
            int index = ch - 'a';
            if (node.children[index] == null) {
                return false; // No match for this character
            }
            return searchHelper(word, idx + 1, node.children[index]); // Recurse to the next character
        }
    }

    // Public search function
    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }
}
