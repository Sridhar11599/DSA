import org.testng.Assert;
import org.testng.annotations.Test;

public class DutchNationalFlag {

    @Test
    public void test() {
        int[] nums = {2,0,2,1,1,0};
        int[] expectedOutput = {0,0,1,1,2,2};
        Assert.assertEquals(sortColors(nums),expectedOutput);
    }

    public int[] sortColors(int[] arr) {
        int left = 0;
        int mid = 0;
        int right = arr.length - 1;
        while (mid < right) {
            if(arr[mid] == 0) {
                int temp = arr[left];
                arr[left] = arr[mid];
                arr[mid] = temp;
                left++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else if(arr[mid] == 2) {
                int temp = arr[right];
                arr[right] =arr[mid];
                arr[mid] = temp;
                right--;
            }
        }
        return arr;
    }
}
