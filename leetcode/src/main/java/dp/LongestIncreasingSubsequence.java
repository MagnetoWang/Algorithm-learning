package dp;

/**
 * @program: leetcode
 * @description: 题号：300
 * @author: MagnetoWang
 * @create: 2018-08-04 21:16
 **/
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums={10,9,2,5,3,7,101,18};
        lengthOfLIS(nums);
    }
    public static int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }

    /**
     *
     * @param nums
     * @return
     */
    public static int lengthOfLISHumanRead(int[] nums){
        int[] tails=new int[nums.length];
        int size=0;
        for(int currentNumber:nums){
            int tail_start=0;
            int tail_end=size;
            //当前的数在尾巴数组中进行筛选
            while (tail_start<tail_end){
                int tail_mid=(tail_end+tail_start)/2;
                if(tails[tail_mid]<currentNumber){
                    tail_start=tail_mid+1;
                }else{
                    tail_end=tail_mid;
                }
            }
            //关键是这一步，当前的数一定可以更新到数组里面
            //并且如果如果start的位置到了size位置，就要自增。这里逻辑动作特别容易出错！
            tails[tail_start]=currentNumber;
            if(tail_start==size){
                size++;
            }
        }
        return size;

    }
}
