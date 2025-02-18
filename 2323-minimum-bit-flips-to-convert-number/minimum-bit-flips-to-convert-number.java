class Solution {
    public int minBitFlips(int start, int goal) {
        int xor = start ^ goal;
        int ans = Integer.bitCount(xor);
        return ans;
    }
}