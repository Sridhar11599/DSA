import org.testng.Assert;
import org.testng.annotations.Test;

public class NumberOfSetBits {

    @Test
    public void test() {
        int n = 11;
        int expectedOutput = 3;
        Assert.assertEquals(hammingWeight(n),expectedOutput);
    }

    @Test
    public void test2() {
        int n = 128;
        int expectedOutput = 1;
        Assert.assertEquals(hammingWeight(n),expectedOutput);
    }

    public int hammingWeight(int n) {
        int count = 0;
        while(n > 0) {
            if((n & 1) == 1) count++;

            n = n >> 1;
        }
        return count;
    }
}
