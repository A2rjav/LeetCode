class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder repeatedA = new StringBuilder(a);
        int c=1;

        if(repeatedA.toString().contains(b)) return c;
        while(repeatedA.length() < b.length()){
            repeatedA.append(a);
            c++;
            if(repeatedA.toString().contains(b)) return c;
        }

        repeatedA.append(a);
        c++;
        if(repeatedA.toString().contains(b)) return c;

        return -1;
    }
}