class Solution {
   public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(int i = 0;i<strs.length;i++){
            String s = getUniqueString(strs[i]);
            if(map.containsKey(s)){
                map.get(s).add(strs[i]);
            }else{
                ArrayList<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(s,list);
            }
        }
        List<List<String>> list = new ArrayList<>();
        for(List<String> st : map.values()){
            list.add(st);
        }
        return list;
    }
    public String getUniqueString(String s){
        int[] a = new int[26];
        for(int i = 0;i<s.length();i++){
            a[s.charAt(i) - 97]++;
        }
        String st = "";
        for(int i = 0;i<26;i++){
            st+=a[i]+" ";
        }
        return st;
    }
}
