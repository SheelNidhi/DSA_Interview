package LeetCodeStreak;

public class MinimumOperation {

    public int minOperations(int[] nums, int x) {
        int count =0;

        int low = 0; int high = nums[nums.length -1];
        while(low <= high){
            if(nums[low] < nums[high] && nums[high] <= x){
                x=  x- nums[high];
                high--;
                count++;
            }else{
              x= x-nums[low];
              low++;
              count++;
            }
            if(x <=0){
                return count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MinimumOperation minimumOperation = new MinimumOperation();
       int nums[]= {1,1,4,2,3}, x = 5;
        int ans =minimumOperation.minOperations(nums,x);
        System.out.println("ans"+ans);

    }
}
