package LeetCode.SwordToOffer;

import java.util.HashMap;
import java.util.HashSet;

public class JZ48 {
    public static void main(String[] args) {
        JZ48 jz48 = new JZ48();
        System.out.println(jz48.lengthOfLongestSubstring("abcabcbb"));

    }

    //滑动窗口，哈希表去重
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashSet<Character> set = new HashSet<>();
        int right = 0;
        int left = 0;
        int maxLen = 0;
        int n = s.length();

        char[] chars = s.toCharArray();
        while (right < n) {
            char c = chars[right];
            if (!set.contains(c)) {
                set.add(c);
            } else {
                maxLen = Math.max(maxLen, right - left);
                while (chars[left] != chars[right]) {
                    set.remove(chars[left]);
                    left++;
                }
                left++;
            }
            right++;
        }
        return Math.max(maxLen,set.size());
    }

    //哈希表
    public int lengthOfLongestSubstring1(String s) {
        if (s.length() == 0 || s == null) return 0;
        int max = 0;
        int i = -1;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)));
            }
            map.put(s.charAt(j), j);
            max = Math.max(max, j - i);
        }
        return max;
    }

    /*
     滑动窗口
     */
    public int lengthOfLongestSubstring3(String s) {
        if (s.length() == 0) return 0;
        int maxLen = 0;
        int left = 0, right = 0;
        int n = s.length();
        char[] chars = s.toCharArray();
        int[] winCount = new int[128];
        int winLength = 0;
        while (right < n) {
            if (winCount[chars[right]] == 0) {
                winCount[chars[right]]++;
                winLength++;
            } else {
                maxLen = Math.max(maxLen, right - left);
                char c = chars[right];
                while (c != chars[left]) {
                    winCount[chars[left]]--;
                    left++;
                    winLength--;
                }
                left++;
            }
            right++;
        }
        return Math.max(maxLen,winLength);
    }


}
