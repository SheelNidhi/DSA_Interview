package BinarySerach;

import java.util.Arrays;

public class MinimumDivisors {

    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = Arrays.stream(nums).max().getAsInt();
        int answer = 0;
        while (high - low >= 0){
            int mid = low +(high -low)/2;
           if( ifPossible(nums,mid, threshold)){
               answer = mid;
               high = mid -1;

            } else{

               low = mid +1;

            }

        }
     return answer;
    }
    public boolean ifPossible(int[] nums, int number, int threshold) {
        int sum = 0;

        for (int num : nums) {
            // Integer formula for Math.ceil(num / number)
            sum += (num + number - 1) / number;
        }
        return sum <= threshold;
    }

    public static void main(String[] args) {
        MinimumDivisors minimumDivisors = new MinimumDivisors();
        int nums[] = {44,22,33,11,1};

        int answer =minimumDivisors.smallestDivisor(nums,5);
        System.out.println("answer+"+answer);
    }

}
