class Solution {
    class TrieNode{
        TrieNode children[];
        boolean isEnd;
        public TrieNode(){
            children = new TrieNode[26];
            isEnd = false;
        }
    }
    TrieNode root;
    public String search(String word){
        TrieNode curr = root;
        int j=0;
        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i) - 'a';
            j++;
            if(curr.children[idx] == null ){
                return word;
            }else if(curr.children[idx].isEnd) 
                return word.substring(0,j);
            else curr = curr.children[idx];
        }
        return word;
    }

    public void insert(String word){
        TrieNode curr = root;
        for(char c:word.toCharArray()){
            int idx = c-'a';
            if(curr.children[idx] == null ){
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.isEnd = true;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        for(String word : dictionary){
            insert(word);
        }
        StringBuilder result = new StringBuilder();
        String [] input = sentence.split(" ");
        for(String i : input){
            result.append(search(i));
            result.append(" ");
        }
        return result.toString().trim();
    }
}