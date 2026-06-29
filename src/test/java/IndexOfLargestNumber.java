import org.testng.Assert;
import org.testng.annotations.Test;

public class IndexOfLargestNumber {

    @Test
    public void postiveTest() {
        int[] arr = {1,3,9,8,7};
        Assert.assertEquals(findLargestIndex(arr),2);
    }

    public int findLargestIndex(int[] arr) {
        int indexOfLargestNumber = 0;
        int largestNumber = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largestNumber) {
                largestNumber = arr[i];
                indexOfLargestNumber = i;
            }
        }
        return indexOfLargestNumber;
    }
}
