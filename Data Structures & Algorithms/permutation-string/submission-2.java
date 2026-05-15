class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l = s1.length();
        String s = findUnique(s1);
        int le = 0,r = s1.length();
        while(r <= s2.length()){
            String d = findUnique(s2.substring(le,r));
            if(s.equals(d)){
                return true;
            }
            System.out.println(" "+s+" "+d+" ");
            le++;
            r++;
        }
        return false;
    }
    public String findUnique(String s){
        String st = "";
        int[] f = new int[26];
        for(int i = 0;i<s.length();i++){
            f[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < 26; i++){
        st += "#" + f[i];
    }
        return st;
    }
}
