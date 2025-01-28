class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0){
            return false;
        }

        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<hand.length;i++){
            map.put(hand[i],map.getOrDefault(hand[i],0)+1);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int key : map.keySet()){
            list.add(key);
        }

        Collections.sort(list);

        for(int key : list){
            if(map.get(key) > 0){
                int startCount = map.get(key);
                for(int i=key;i<key + groupSize;i++){
                    if(map.getOrDefault(i,0)<startCount ){
                        return false;
                    }
                    map.put(i,map.get(i)-startCount);
                }
            }
        }
        return true;
    }
}