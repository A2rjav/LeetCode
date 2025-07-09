class Solution {
    class TrieNode{
        TrieNode []children;
        TrieNode(){
            children = new TrieNode[2];
        }
    }
    TrieNode root = new TrieNode();
    public int findMaximumXOR(int[] nums) {
        for(int num : nums) buildTrie(num);
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int res = getMax(nums[i]);
            max = Math.max(max,res);
        }
        return max;
    }
    public void buildTrie(int num){
        TrieNode curr = root;
        for(int i=31;i>=0;i--){
            int bit = (num>>i)& 1;
            if(curr.children[bit] == null ) 
            curr.children[bit] = new TrieNode();
            curr = curr.children[bit];
        }
    }
    public int getMax(int num){
        TrieNode curr = root;
        int res=0;
        for(int i=31;i>=0;i--){
            int bit = (num>>i)&1;
            int desiredBit = 1-bit;
            if(curr.children[desiredBit]!= null ){
                res = res | (1<<i);
                curr = curr.children[desiredBit];
                }
            else
            curr = curr.children[bit];
        }
        return res;
    }
}