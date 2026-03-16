package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Day1 {

    //LertCode 1. Two Sum

    //Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    //Brute fore solution with time complexity of O(n^2) with space complexity of O(1) because heare we are not using any extra space to store the elements of the array.
    public static int [] twoSum(int [] nums, int target){
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){   //we are using two loops to iterate through the array and check if the sum of the two numbers is equal to the target.
                if(nums[i] + nums[j] == target){        //if the sum of the two numbers is equal to the target then we return the indices of the two numbers.
                    return new int [] {i, j};
                }
            }
        }
        return new int [] {-1, -1};                     //if we don't find any two numbers that add up to the target then we return -1, -1.
    }

    //Optimized solution with time complexity of O(n) and HashMap with space complexity of O(n).
    public static int [] twoSumOptimised(int [] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();        //Stores array element as key and its index as values.
        for(int i = 0; i < nums.length; i++){
            int sum = target - nums[i];             //we are calculating the sum by subtracting the current element from the target. If the sum is present in the map then we return the indices of the two numbers.
            if(map.containsKey(sum)){               //Chech if the sum(Target - current element) is present in the map or not.
                return new int [] {map.get(sum), i};//if the sum is present in the map then we return the indices of the two numbers. The index of the current element is i and the index of the sum is map.get(sum).
            }
            map.put(nums[i], i);                    //if the sum is not present in the map then we put the current element and its index in the map. So that we can check for the next elements in the array.
        }

        return new int [] {-1, -1};                 //if we don't find any two numbers that add up to the target then we return -1, -1. that clears that thare is no such two numbers in the array that add up to the target.
    }


    //26. Remove Duplicates from Sorted Array

//Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.
//we can solve this problume using two pointers approach with time complexity of O(n) and space complexity of O(1) because we are not using any extra space to store the elements of the array.
    public static int removeDuplicates(int [] nums){
        int i = 0;
        int j = 1;

        while(j < nums.length){                     //Run the loop untill the second pointer reches the end of the array.
            if(nums[i] == nums[j]){                 //if the elements are same the we move the second pointer to the next element and check if the next element is same or not. If the next element is same then we keep moving the second pointer until we find a different element.
                j++;
            }else if(nums[i] != nums[j]){           //if the elements are diffrent then we move the first pointer(i) to the next pointer and copy the jth element to with the ith element and move the jth pointer to the next element.
                i++;
                nums[i] = nums[j];
                j++;
            }
        }
        return i + 1;                               //we return i + 1 because the first pointer is pointing to the last unique element in the array and we need to return the number of unique elements in the array. So we add 1 to the index of the last unique element to get the number of unique elements in the array.    
    }

    //283. Move Zeroes

    //Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zeroes. You must do this in-place without making a copy of the array.
    //we can solve this problume using two pointers approach with time complexity of O(n)

    public static void moveZeroes(int [] nums){
        int i = 0;
        for(int j = 0; j < nums.length; j++){
            if(nums[i] != 0){                       //replace the non-zero element with the first pointer and move the first pointer to the next element. So that we can keep track of the last non-zero element in the array.
                nums[i] = nums[j];
                i++;                                //move the first pointer to the next element after replacing the non-zero element with the first pointer. So that we can keep track of the last non-zero element in the array.
            }
        }

        while(i < nums.length){                     //using while loop to replace the remaining element with zero. so that we can move all the zeroes to the end of the array.
            nums[i++] = 0;
        }
    }
    public static void main(String[] args) {
       
    }
}
