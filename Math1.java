import java.util.Scanner;

public class Math1 {
  
  // To calculate the factorial of a number n, we can use a simple iterative approach. We initialize a variable result to 1 and then multiply it by each integer from n down to 1. This will give us the factorial of n.
  static long fact(int n){
    int i = 1;
    long result = 1;

    while(n > 0){
      result *= n;
      n -= 1;
    }
    return result;
  }

  // To calculate the sum of the first n natural numbers, we can use the formula n(n + 1) / 2. This formula is derived from the observation that the sum of the first n natural numbers can be paired up to form n/2 pairs, each summing to n + 1.
  static int sumOfN(int n){
    int sum = (n * (n + 1)) / 2;
    return sum;
  }

  // TO count the number of trailing zeroes in n! we need to count the number of times 10 is a factor in the numbers from 1 to n. Since 10 is made of 2 and 5, and there are usually more factors of 2 than 5 in a factorial, we can focus on counting the number of factors of 5.
  static int countTrailingZeroes(int n){
    int res = 0;
    int powOf5 = 5;

    while(powOf5 <= n){
      res += n / powOf5;
      powOf5 = powOf5 * 5;
    }
    return res;

  }
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();

      int count = countTrailingZeroes(n);
      
      System.out.println(count);
    }
}