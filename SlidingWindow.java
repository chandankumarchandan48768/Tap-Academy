public class SlidingWindow {
    // Given an array of integers and a number k, find the maximum sum of a subarray of size k.
    //Using the sliding window tecknique and time complexity is O(n) and space complexity is O(1)
    public static int MaxSumOfSubArray(int [] nums, int k){
        int sum = 0;
        for(int i = 0; i < k; i++){         //To find the sum of first k elements in the array
            sum += nums[i];
        }

        int maxSum = sum;                   //Assign the initial sum to maxSum because we assume that initial sum will be the max sum
        int l = 0;                          //left pointer is pointing to the first element of the array
        int r = k;                          //right pointer is pointing to the element after the first k elements of the array  

        while(r < nums.length - 1){         //The loop will run until the right pointer reaches the end of the array (i.e n - 1) if we use (r < n) the exception will raise (ArrayIndexOutOfBoundsException)
            sum = sum - nums[l];            //Subtract the value pointing to the left pointer 
            l += 1;                         //Move the left pointer to the right by 1   
            r += 1;                         //Move the right pointer to the right by 1
            sum += nums[r];                 //Add the value pointing to the right pointer
            maxSum = Math.max(maxSum, sum); //Update the maxSum if the current sum is greater than the maxSum
        }
        return maxSum;                     //Return the maxSum after the loop ends

    }

// Given an array of integers and a number k, find the length of the longest subarray with sum less than or equal to k.
//Using the sliding window tecknique and time complexity is O(n) and space complexity is O(1) which comes under the category of variable size sliding window because the size of the window is not fixed and it can grow or shrink based on the condition (sum <= k)
    public static int LongestSubArrayWithSumK(int [] nums, int k){
        int sum = 0;                    //To keep track of the sum of the current window
        int maxLen = 0;                 //To keep track of the maximum length of the subarray with sum less than or equal to k
        int left = 0;                   //left pointer is pointing to the first element of the array
        int right = 0;                  //right pointer is pointing to the first element of the array    

        while(right < nums.length){     //The loop will run until the right pointer reaches the end of the array
            sum = sum + nums[right];    //Add the value pointing to the right pointer to the sum

            while(sum > k){             //If the sum is greater than k, we need to shrink the window from the left side until the sum is less than or equal to k
                sum -= nums[left];      //Subtract the value pointing to the left pointer from the sum
                left += 1;              //Move the left pointer to the right by 1
            }

            if(sum <= k){               //If the sum is less than or equal to k, we can update the maxLen if the current window size (right - left + 1) is greater than the maxLen
                maxLen = Math.max(maxLen, right-left+1);    //Update the maxLen if the current window size is greater than the maxLen
            }

            right += 1;         //Move the right pointer to the right by 1

        }
        return maxLen;
    }

    public static void main(String[] args) {
        int [] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int sum = 13;
        System.out.println(LongestSubArrayWithSumK(nums, sum));
    }
}
