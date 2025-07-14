class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);

        for(String product : products)
        insert(product);
        
        List<List<String>> result = new ArrayList<>();
        TrieNode node= root;
        for(char c: searchWord.toCharArray()){
            if(node !=null)
            node = node.children[c-'a'];
            if(node != null)
            result.add(node.list);
            else
            result.add(new ArrayList<>());
        }
        return result;
    }
    TrieNode root = new TrieNode();
    class TrieNode{
        TrieNode children[] = new TrieNode[26];
        ArrayList<String> list = new ArrayList<>();
    }
    public void insert(String word){
        TrieNode curr= root;
        for(char ch:word.toCharArray()){
            int idx= ch-'a';
            if(curr.children[idx]== null)
            curr.children[idx] = new TrieNode();
            curr = curr.children[idx];
            
            if(curr.list.size()<3)
            curr.list.add(word);
        }
        
    }
}