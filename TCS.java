import java.util.ArrayList;

public class TCS {
    public static int maxElement(int [] nums, int right, int left){
        int max = Integer.MIN_VALUE;
        for(int i = left; i <= right; i++){
            if(nums[i] > max){
                max = nums[i];
            }
        }
        return max;
    }

    public static ArrayList<Integer> leaderElement(int [] nums){
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int max = maxElement(nums, nums.length - 1, i);
            if(nums[i] >= max){
                result.add(nums[i]);
            }
        }
        return result;
    }

    // Find the second largest element in an array
    public static int secondLargest(int [] nums){
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > first){
                second = first;
                first = nums[i];
            }else if(nums[i] > second && nums[i] != first){
                second = nums[i];
            }
        }
        return second == Integer.MIN_VALUE ? -1 : second;
    }
        
    // Find the maximum sum of two distinct elements in the array
    public static int maxSumOfTwoDistinct(int [] nums){
        int windowSize = 2;
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i <= nums.length - windowSize; i++){
            int sum = nums[i] + nums[i + 1];
            if(sum == maxSum){
                return -1;
            }
            if(sum > maxSum){
                maxSum = sum;
            }
        }
        return maxSum == Integer.MIN_VALUE ? -1: maxSum;
    }
    public static void main(String[] args) {
        int [] nums = {5, 5, 5, 5};
        System.out.println("Maximum sum of two distinct elements in the array: " + maxSumOfTwoDistinct(nums));
}
}
