class Solution {
    public boolean isPalindrome(String s) {
        String a = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        int i=0;
        int j = a.length()-1;
        boolean ans = true;
        while(i<j){
            if(a.charAt(i)!=a.charAt(j)) ans = false;
            i++;
            j--;
        }
        return ans;
    }
}
