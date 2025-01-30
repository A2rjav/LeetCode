class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> dq = new LinkedList<>();
        for(int n: asteroids){
            if(n>0){
                dq.addLast(n);
            }else{
                while(!dq.isEmpty() && dq.peekLast() > 0 && dq.peekLast() < Math.abs(n) ){
                    dq.removeLast();
                }
                if(dq.isEmpty() || dq.peekLast() < 0){
                    dq.addLast(n);
                }else if (dq.peekLast() == Math.abs(n)){
                    dq.removeLast();
                }
            }
        }
        int [] result = new int[dq.size()];
        for(int i=0;i<result.length;i++){
            result[i]= dq.pollFirst();
        }
        return result;
    }
}