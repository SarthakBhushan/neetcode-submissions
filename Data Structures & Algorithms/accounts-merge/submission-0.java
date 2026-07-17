class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String email = accounts.get(i).get(j);
                if(!map.containsKey(email)){
                    map.put(email,i);
                }else{
                    ds.unionBySize(i,map.get(email));
                }
            }
        }

        HashMap<Integer, List<String>>merged = new HashMap<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String email = entry.getKey();
            int parent = ds.findUPar(entry.getValue());
            merged.putIfAbsent(parent, new ArrayList<>());
            merged.get(parent).add(email);
        }

        List<List<String>> ans = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry : merged.entrySet()) {
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(entry.getKey()).get(0)); // name
            temp.addAll(emails);
            ans.add(temp);
        }

        return ans;
    }
}

class DisjointSet{
    List<Integer>parent = new ArrayList<>();
    List<Integer>size = new ArrayList<>();

    public DisjointSet(int n){
        for(int i=0;i<=n;i++){
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node){
        if(node == parent.get(node))return node;
        int ulp = findUPar(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }

    public void unionBySize(int u, int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if(ulp_u==ulp_v)return;
        if(size.get(ulp_u)<size.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u)+size.get(ulp_v));
        }
        else{
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u)+size.get(ulp_v));
        }
    }
}