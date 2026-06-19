class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] fA = new int[26];
        for(char a : tasks){
            fA[a - 'A']++;
        }
        int maxF = Arrays.stream(fA).max().getAsInt();
        int c =0;
        for(int i : fA){
            if(i == maxF){
                c++;
            }
        }
        int tak = (maxF-1)*(n+1) +c;
        return Math.max(tak,tasks.length);
    }
}
