/*
Given a sorted array, nums={1,2,3,4,5} and a target t=5,
find the index of the element, if not present, return -1
 */

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class binarySearchBasic {

    public void test1() {
        int[] nums={1,2,3,4,5};
        int target = 5;
        Assert.assertEquals(findIndexBinarySearch(nums,target),4);
    }

    public void test2() {
        int[] nums={1,2,3,4,5};
        int target = 6;
        Assert.assertEquals(findIndexBinarySearch(nums,target),-1);
    }

    public void test3() {
        int[] nums={1,2,3,4,5,6,7,10};
        int target = 4;
        Assert.assertEquals(findIndexBinarySearch(nums,target),3);
    }

    public int findIndexBinarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(arr[mid] == target) {
                return mid;
            }
            if(target < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return  -1;
    }
}
