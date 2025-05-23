class Solution {
    public int countWays(int n,int ways[]){
        if(n <0) return 0;
        if(n==0) return 1;

        if(ways[n] != -1 ) return ways[n];

        return ways[n] = countWays(n-1,ways)+ countWays(n-2,ways);
    }
    public int climbStairs(int n) {
        int ways[] = new int[n+1];
        Arrays.fill(ways,-1);
        return countWays(n,ways);
    }
}