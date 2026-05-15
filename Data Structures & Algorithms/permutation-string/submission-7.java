class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) return false;
       int[] f1 = new int[26];
       int[] f2 = new int[26];
       for(char c : s1.toCharArray()){
        f1[c - 'a']++;
       }
       for(int  i = 0;i<s1.length();i++){
        f2[s2.charAt(i) - 'a']++;
       }
       int l = 0;
       for(int i = s1.length();i<s2.length();i++){
        if(Arrays.equals(f1,f2)) return true;
        f2[s2.charAt(l) - 'a']--;
        l++;
        f2[s2.charAt(i) - 'a']++;
       }
       return Arrays.equals(f1,f2);
    }   
}
