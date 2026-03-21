package Programming;

import java.util.HashSet;
import java.util.Set;

public class Day23 {
    //Non-Repeating elements in an array
    public static void nonRepeatingElements(int [] a, int [] b){
        int n = a.length;
        int m = b.length;

        Set<Integer> set = new HashSet<>();
        for(int i : a){
            set.add(i);
        }

        for(int j : b){
            set.add(j);
        }

        for(int i : set){
            System.out.print(i + " ");
        }
    }
    public static void main(String[] args) {
        int [] a = {1, 2, 3, 4, 5};
        int [] b = {4, 5, 6, 7, 8}; 
        nonRepeatingElements(a, b);
    }
}
