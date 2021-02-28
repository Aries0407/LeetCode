package LeetCode.SwordToOffer;

import java.util.HashMap;
import java.util.HashSet;

public class JZ3 {


    //方法一：通过桶计数
    public int findRepeatNumber(int[] nums) {
        int count[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] >= 2) return i;
        }
        return 0;
    }

    //方法二：原地置换(效率最好)
    public int findRepeatNumber2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                } else {
                    int temp = nums[i];
                    nums[i] = nums[temp];
                    nums[temp] = temp;
                }
            }
        }
        return 0;
    }

    //哈希表
    public int findRepeatNumber3(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            if (map.get(i) >= 2) {
                return i;
            }
        }
        return -1;
    }

    public int findRepeatNumber4(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums){
            if (!set.contains(i)) set.add(i);
            else return i;
        }
        return -1;
    }



    public static void main(String[] args) {

    }
}
