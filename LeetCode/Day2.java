package LeetCode;

public class Day2 {

    //Arays Problem 1: Left Rotate an array by one place without using extra space (extra array)
    //Time complexity O(n) and space complexity O(1)
    public static void leftRotate(int [] nums){
        int temp = nums[0];                         //Store the first element in a temporary ariable temp
        int i = 1;
        for( ; i < nums.length; i++){               
            nums[i - 1] = nums[i];                  //shift the current element to the previos index i.e assume the current i = 1 then the nums[i] will be copied to nums[i - 1]
        }
        nums[i - 1] = temp;                         //after the ende of the loop the i will be nums.length + 1 so we sould copy the temp (first element) to i - 1th index to avoid the ArrayIndexOutOfBoundsException
    }


    //Array Problume 2: left Rotate K elemente in an array by one place without using extra space (extra array)

    //Solution 1: Time complexity O(n) and space complexity O(k)
    public static void leftRotateK(int [] nums, int k){
        int d = k % nums.length;
        int n = nums.length;

        if(d == 0 || n <= 1) return;

        int [] temp = new int [d];
        for(int i = 0; i < d; i++){        //Storing the first K elements in temp array
            temp[i] = nums[i];
        }


        int i = d;                          //initialize i pointer to the index after the first kth element 
        for(; i < n; i++){
            nums[i - d] = nums[i];          //Shift the elements from index d to the i - dth index. basically we are moving the elements from ith index and copy the elements from beginning of the array to the end of the array 
        }

        for(int j = 0; j < d; j++){         //copy the elements from temp array to the end of the array
            nums[n - d + j] = temp[j];
        }
    }

    //Solution 2: Time complexity O(n) and space complexity O(1)
    public static void leftRotateK2(int [] nums, int k){
        int n = nums.length;
        k = k % n;

        reverseHelper(nums, 0, k - 1);        //reverse the first k elements
        reverseHelper(nums, k, n - 1);              //reverse the remaining n - k elements
        reverseHelper(nums, 0, n - 1);        //reverse the whole array

    }

    //Hrlper function to reverse the elements in the array from start index to end index
    public static void reverseHelper(int [] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
    public static void main(String[] args) {
        int [] nums = {1, 2, 3, 4, 5};
        leftRotateK2(nums, 2);
        for(int i : nums){
            System.out.print(i + " ");
        }
    }
}
