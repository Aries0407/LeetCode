package LeetCode.SwordToOffer;

public class JZ42 {
    public static void main(String[] args) {
        int []nums = {-2,1,-3,4,-1,2,1,-5,4};
        JZ42 jz42 = new JZ42();
        System.out.println(jz42.maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i-1],0);
            max = Math.max(nums[i],max);
        }
        return max;
    }
}
