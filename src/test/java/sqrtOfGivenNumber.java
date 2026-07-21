import org.testng.Assert;
import org.testng.annotations.Test;

public class sqrtOfGivenNumber {

    @Test
    public void test() {
        int num = 250000;
        Assert.assertEquals(sqrt(num),500);
    }

    public int sqrt(int num) {
        int low = 1;
        int high = num;
        int result = 1;
        while(low <= high) {
            int mid = low + (high-low)/2;
            long sq = (long) mid * mid;
            if(sq == num) return mid;
            if(sq < num) {
                result = mid;
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }

        return result;
    }
}
