class Solution {
    class Pair{
        String str;
        int level;
        Pair(String str, int level ){
            this.str = str;
            this.level = level;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));
        Set<String> set = new HashSet<>();
        for(String word : wordList){
            set.add(word);
        }

        set.remove(beginWord);

        while(!q.isEmpty()){
            Pair curr = q.poll();
            String word = curr.str;
            int level = curr.level;

            if(word.equals(endWord)) return level;

            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char [] replacedChar= word.toCharArray();
                    replacedChar[i] = ch;
                    String replacedWord = new String(replacedChar);
                    if(set.contains(replacedWord)){
                        q.add(new Pair(replacedWord,level+1));
                        set.remove(replacedWord);
                    }
                }
            }
        }
        return 0;
    }

}