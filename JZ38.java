package LeetCode.SwordToOffer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JZ38 {

    List<String> list = new ArrayList<>();
    char[] chars;

    public String[] permutation(String s) {
        chars = s.toCharArray();
        dfs(0);
        return list.toArray(new String[list.size()]);
    }

    private void dfs(int index) {
        if (index == chars.length - 1) {
            list.add(String.valueOf(chars));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            if (set.contains(chars[i])) continue;
            set.add(chars[i]);
            swap(chars,index,i);
            dfs(index+1);
            swap(chars,index,i);
        }
    }

    public void swap(char[] chars, int i, int j) {
        char c = chars[i] ;
        chars[i] = chars[j];
        chars[j] = c;
    }

}
