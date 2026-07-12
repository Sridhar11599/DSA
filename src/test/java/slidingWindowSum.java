/*
1. Initialize a pointer i on first index in a for loop
2. Intialize a pointer j on first index in inner for loop . this should
run until k which is length of sliding window
3. Initialize a variable maxSum.
4. Compare maxSum with computed sum and reassign it with new sum if sum is greater than maxSum
5. return sum
 */



import org.testng.Assert;
import org.testng.annotations.Test;

public class slidingWindowSum {

  @Test
  public void slidingWindowTest() {
      int[] arr = {100, 200, 300, 400};
      int k = 2;
      Assert.assertEquals(slidingWindowSum(arr,k),700);
  }

    public int slidingWindowSum(int[] arr, int k) {

        int sum = 0;
        int maxSum  = Integer.MIN_VALUE;
        for(int i = 0; i<k; i++) {
            sum = sum + arr[i];
        }

        if(maxSum < sum) {
            maxSum = sum;
        }

        for(int i = k;i < arr.length; i++) {
            sum = sum  + arr[i];
            sum = sum - arr[i-k];
            maxSum = Math.max(maxSum, sum);
        }
        System.out.println("maxSum: "+maxSum);
        return maxSum;
    }
}
