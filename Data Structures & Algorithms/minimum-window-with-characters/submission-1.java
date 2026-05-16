class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> mapT = new HashMap<>();
        Map<Character,Integer> mapS = new HashMap<>();
        for(char c : t.toCharArray()){
            mapT.put(c,mapT.getOrDefault(c,0)+1);
        }
        int l = 0;
        int res = Integer.MAX_VALUE;
        int[] arr = {-1,-1};
        int have  = 0,need = mapT.size();
        for(int  i = 0;i<s.length();i++){
            char c = s.charAt(i);
            mapS.put(c,mapS.getOrDefault(c,0)+1);
            if(mapT.containsKey(c) && mapS.get(c).equals(mapT.get(c))){
                have++;
            }
            while(have == need ){
                if((i - l +1) < res){
                    res = i - l+1;
                    arr[0] = l;
                    arr[1] = i;
                }
                char ch = s.charAt(l);
                mapS.put(ch,mapS.get(ch)-1);
                if(mapT.containsKey(ch) && mapS.get(ch) < mapT.get(ch)){
                    have--;
                }
                l++;
            }
        }
        return res == Integer.MAX_VALUE ? "" : s.substring(arr[0],arr[1]+1); 

    }
}
