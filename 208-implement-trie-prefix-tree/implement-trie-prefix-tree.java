class Trie {
    Node root;
    class Node{
        Node [] nodes;
        boolean isEnd;
        public Node(){
            nodes = new Node[26];
        }
    }
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node curr = root;

        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i) - 'a';

            if(curr.nodes[idx] == null) curr.nodes[idx] = new Node();
            curr = curr.nodes[idx];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        Node curr = root;
        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i)-'a';
            if(curr.nodes[idx] == null) return false;
            curr = curr.nodes[idx];
        }
        return curr.isEnd;

    }
    
    public boolean startsWith(String prefix) {
        Node curr = root;
        for(int i=0;i<prefix.length();i++){
            int idx = prefix.charAt(i) - 'a';

            if(curr.nodes[idx] == null) return false;

            curr = curr.nodes[idx];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */