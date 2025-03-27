class Solution {
    public boolean lemonadeChange(int[] bills) {
        int deno[] = new int[3];
        for(int bill : bills){
            if(bill == 5) deno[0]++;
            else if(bill == 10){
                if(deno[0] < 1) return false;
                deno[0]--;
                deno[1]++;
            }else{
                if((deno[0] >= 1) && (deno[1] >=1) ){
                    deno[0]--;
                    deno[1]--;
                }else if(deno[0] >= 3){
                    deno[0]-=3;
                }else return false;
            }
        }
        return true;
    }
}