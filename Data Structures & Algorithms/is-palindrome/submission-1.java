class Solution {
    public boolean isPalindrome(String st) {
        String s = st.toLowerCase().replaceAll("[^a-zA-Z0-9]","").replaceAll(" ","");
        int  i = 0;
        int j = s.length()-1;
        int c = 0;
        System.out.print(s);
        while(i<j){
            if(s.charAt(i) == s.charAt(j)){
                c++;
            }
            i++;
            j--;
        }
        if(c ==s.length()/2) return true;
        return false;
    }
}
