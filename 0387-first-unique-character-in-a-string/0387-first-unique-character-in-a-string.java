class Solution {

   public int firstUniqChar(String s) { 
       
       for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if(s.lastIndexOf(currChar) == s.indexOf(currChar)){
                return i;
            }
       }   
       return -1;
       
    }
}