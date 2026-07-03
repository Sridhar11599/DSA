import org.testng.Assert;
import org.testng.annotations.Test;

public class FloorSquareRootOfGivenNumber {


    @Test
    public  void test() {
      int n = 16;
      int expectedOutput = 4;
      Assert.assertEquals(mySqrt(n),expectedOutput);
    }

    public int mySqrt(int x) {
        if(x == 0) return 0;
        if(x<10) {
            for(int i = 1; i<=x; i++) {
                if(i*i == x) {
                    return i;
                }
                if(i*i > x) {
                    return i-1;
                }
            }
        }
        for(int i = 1; i<=x/2; i++) {
            if(i*i == x) {
                return i;
            }
            if(i*i > x) {
                return i-1;
            }
        }
        return -1;
    }
}
