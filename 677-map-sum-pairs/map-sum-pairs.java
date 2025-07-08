class TrieNode{
    TrieNode[] children;
    int sum;
    TrieNode(){
        children = new TrieNode[26];
        sum = 0;
    }
}
class MapSum {
    TrieNode root;
    HashMap<String,Integer> map;
    public MapSum() {
        root = new TrieNode();
        map = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        TrieNode curr = root;
        int delta = val - map.getOrDefault(key,0);
        map.put(key,val);
        for(char ch: key.toCharArray()){
            int idx = ch-'a';
            if(curr.children[idx] == null )
            curr.children[idx] = new TrieNode();

            curr =curr.children[idx];
            curr.sum += delta;
        }
    }
    
    public int sum(String prefix) {
        TrieNode curr = root;
        for(char ch : prefix.toCharArray()){
            int idx = ch-'a';
            if(curr.children[idx] == null ){
                return 0;
            }
            curr = curr.children[idx];
        }
        return curr.sum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */