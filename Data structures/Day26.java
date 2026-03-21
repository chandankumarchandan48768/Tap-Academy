import java.util.HashSet;

public class Day26 {

    //Repeted element in a two array (sorted)
    //Method used in this problume is Two pointers approach with time complexity of O(n) and space complexity of O(n) (size of original array occupies)
    public static void repeatedElementInArray(int [] nums1, int [] nums2){
        int n = nums1.length;
        int m = nums2.length;

        int i = 0;
        int j = 0;
        boolean flag = false;

        while(i < n && j < m){
            if(nums1[i] == nums2[j]){
                System.out.print(nums1[i] + " ");
                i++;
                j++;
                flag = true;
            }else if(nums1[i] > nums2[j]){
                j++;
            }else{
                i++;
            }
        }

        if(!flag){
            System.out.println("No common elements are present.");
        }
    }

    //This is the optimal approach where we can find the olution whith one go so the time complexity is O(n) but the space complexity is also O(n + m). that is the drawback of this approach.
    public static void repetedElementBetter(int [] nums1, int [] nums2){
        int n = nums1.length;
        int m = nums2.length;

        HashSet<Integer> set = new HashSet<>();

        for(int i : nums1){
            set.add(i);
        }

        boolean flag = false;

        for(int j : nums2){
            if(set.contains(j)){
                System.out.print(j + " ");
                flag = false;
            }
        }

        if(!flag){
            System.out.println("No common element was found");
        }
    }

    //this code will find the unique element in a sorted array but thare is the problume in it it won't find distinct element (an element which is repeted once in an array)
    public static int countUniqueElements(int [] nums){
        int n = nums.length;
        int count = 0;

        for(int i = 0; i < n - 1; i++){
            if(nums[i] != nums[i + 1]){
                count++;
            }else{
                while(i < n - 1 && nums[i] == nums[i + 1]){
                    i++;
                }
            }
        }

        return count + 1;
    }

    //This code corectly finds the distinct elements in an array and inrement the coutn variable and return the count of elements which accurs exactly once in the array.
    public static int countDistincElement(int [] nums){
        int n = nums.length;

        int count = 0;
        int i = 0;

        while(i < n){
            int current = nums[i];
            int freeq = 0;

            while(i < n && nums[i] == current){
                freeq++;
            }

            if(freeq == 1){
                count++;
            }
        }

        return count;
    }

    //Longest repeating element in an array
    public static int longestRepeatingElement(int [] nums){
        int n = nums.length;

        int max = Integer.MIN_VALUE;
        boolean isFound = false;

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(nums[i] == nums[j] && nums[i] > max){
                    max = Math.max(max, nums[i]);
                    isFound = true;
                }
            }
        }

        return isFound == false ? -1 : max;
    }
    public static void main(String[] args) {
        int [] num1 = {1, 1, 1, 1, 1, 3};
        System.out.println(countUniqueElements(num1));
    }
    
}