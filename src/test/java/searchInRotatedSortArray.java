import org.testng.Assert;
import org.testng.annotations.Test;

public class searchInRotatedSortArray {

    @Test
    public void test1() {
        int[] nums  = {4,5,6,7,0,1,2};
        int target = 0;
        int expOutput = 4;
        Assert.assertEquals(search(nums,target),expOutput);
    }

    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(nums[mid] == target) {
                return mid;
            }
            if (nums[low] <= nums[mid]) {
                if(target >= nums[low]  && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if(nums[mid] <= nums[high]) {
                if(target >= nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

        }
        return -1;
    }
}
