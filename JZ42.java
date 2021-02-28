package LeetCode.SwordToOffer;

public class JZ42 {
    public static void main(String[] args) {
        int []nums = {-2,1,-3,4,-1,2,1,-5,4};
        JZ42 jz42 = new JZ42();
        System.out.println(jz42.maxSubArray(nums));

    }

    //不修原数组
    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length == 0) return 0;
        int sum = nums[0];
        int max = nums[0];
        for(int i = 1 ; i < nums.length ; i++){
            sum = sum + nums[i] > nums[i] ? sum + nums[i] : nums[i] ;
            max = Math.max(sum,max);
        }
        return max;
    }

    //修改原数组
    public int maxSubArray2(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i-1],0);
            max = Math.max(nums[i],max);
        }
        return max;
    }
}
