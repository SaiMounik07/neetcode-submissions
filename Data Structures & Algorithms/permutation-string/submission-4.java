class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length())
            return false;

        int[] freq1 = new int[26];
        for(char c: s1.toCharArray()){
            freq1[c - 'a']++;
        }

        int[] freq2 = new int[26];
        for(int i = 0; i < s1.length(); i++){
            freq2[s2.charAt(i) - 'a']++;
        }

        int l = 0;
        for(int r = s1.length(); r < s2.length(); r++){
            if(Arrays.equals(freq1, freq2)) return true;

            freq2[s2.charAt(l) - 'a']--;
            l++;

            freq2[s2.charAt(r) - 'a']++;
        }

        return Arrays.equals(freq1, freq2);
    }   
}
