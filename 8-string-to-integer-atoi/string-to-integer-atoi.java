class Solution {
    public int myAtoi(String s) {
        s= s.trim();
        if(s.isEmpty()){
            return 0;
        }
        int ans = 0,i=0;
        boolean pos = true;
        if(s.charAt(0)=='-'){
            pos = false;
            i++;
        }
        else if(s.charAt(0) == '+'){
            i++;
        }

        while(i<s.length() && Character.isDigit(s.charAt(i))){
            int digit = s.charAt(i) - '0';
            if (ans > (Integer.MAX_VALUE - digit) / 10) { return pos ? Integer.MAX_VALUE : Integer.MIN_VALUE; }
            ans = ans *10 + digit;
            i++;
        }
        if(pos){
            return ans;
        }
        return -ans;
    }

}