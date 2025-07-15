class Solution {
    public int minFlips(int a, int b, int c) {
        int cnt=0;
       for(int i=0;i<32;i++){
        int msbA = (a>>i) & 1;
        int msbB = (b>>i) & 1;
        int msbC = (c>>i)&1;

        if((msbA|msbB) != msbC){
            if(msbC==0){
                if(msbA==1 && msbB==1)
                cnt+=2;
                else
                cnt++;
            }else{
                cnt++;
            }
        }else
            continue;
        }
        return cnt; 
    }
}