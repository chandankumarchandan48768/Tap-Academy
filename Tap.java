import java.util.HashMap;

public class Tap {

    public static void main(String[] args) {
        int [] nums = {1, 2, 3, 3, 4, 4, 4, 5};

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i : nums){
            if(map.containsKey(i)){
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        int count = (int) map.entrySet().stream().filter(entry -> entry.getValue() == 1).count();
        System.out.println(count);
    }
}