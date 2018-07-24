package dp;
/**
 * leetcode题号：53
 * 只考虑加或者不加当前的数
 * 判决条件：如果总和大于0，那么加。
 * 如果总和小于0，那么减。
 * 同时维护一个sum变量，存储最大的数
 *
 * 方法二：归根到底就是计算两个状态。得出状态公式可以简化代码，同时不易出错
 *
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums={-1};//={-2,1,-3,4,-1,2,1,-5,4};
//        nums={1};
        System.out.println(maxSubArray1(nums));
    }
    public static int maxSubArray(int[] nums) {
        int sum=nums[0];
        int temp=nums[0];
        for(int i=1;i<nums.length;i++){
            temp+=nums[i];
            if(temp>=0){
                if(temp>sum){
                    sum=temp;
                }
                continue;
            }else{
                temp=0;
            }
        }
        return sum;
    }
    public static int maxSubArray1(int[] nums) {
        int sum=Integer.MIN_VALUE,f=0;
        for(int i=0;i<nums.length;i++){
            f=Math.max(nums[i],f+nums[i]);
            sum=Math.max(f,sum);
        }
        return sum;
    }
}
