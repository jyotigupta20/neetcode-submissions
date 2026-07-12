class Solution {
    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> map = new HashMap();
        int start = 0;
        int maxLength = 0;

        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
               start = Math.max(map.get(s.charAt(i)) + 1, start);
            }
            map.put(s.charAt(i), i);
            maxLength = Math.max(maxLength, i-start+1);
        }
       return maxLength; 
    }
}
