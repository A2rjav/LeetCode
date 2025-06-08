class Solution {
    int[] rank;
    int[] par;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        par = new int[n];
        rank = new int[n];

        for(int i=0;i<n;i++) par[i] = i;

        Map<String,Integer> emailToAccount = new HashMap<>();
        for(int i=0;i<n;i++){
            List<String> acc = accounts.get(i);
            String name = acc.get(0);
            int m = acc.size();
            for(int j=1;j<m;j++){
                String email = acc.get(j);
                if(!emailToAccount.containsKey(email)){
                    emailToAccount.put(email,i);
                }else  union(i,emailToAccount.get(email));
            }
        }

        Map<Integer,Set<String>> merged = new HashMap<>();
        for(Map.Entry<String,Integer> entry : emailToAccount.entrySet()){
            String email  = entry.getKey();
            int root = find(entry.getValue());
            merged.putIfAbsent(root,new TreeSet<>());
            merged.get(root).add(email);
        }

        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<Integer,Set<String>> entry : merged.entrySet()){
            int idx = entry.getKey();
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(idx).get(0));
            temp.addAll(entry.getValue());
            res.add(temp);
        }
        return res;
        
    }
    public int find(int x){
        if(par[x] == x) return x;
        return par[x] = find(par[x]);
    }
    public void union(int a,int b){
        int parA = find(a);
        int parB= find(b);

        if(rank[parA] < rank[parB])
        par[parA] = parB;
        else if(rank[parA] > rank[parB])
        par[parB] = parA;
        else 
        par[parB] = parA;
        rank[parA]++;
    }
    class Pair{
        String name;
        String email;
        Pair(String name, String email){
            this.name = name;
            this.email = email;
        }
    }
}