import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class IsomorphicString {

    @Test
    public void test() {
        String s = "paper";
        String t = "title";
        Assert.assertTrue(isIsomorphicString(s, t));
    }

    public boolean isIsomorphicString(String s, String t) {
        HashMap<Character,Character> map = new HashMap<>();
        for(int i = 0; i<s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                if(map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else {
                if(map.containsValue(t.charAt(i))) return false;
            }
            map.put(s.charAt(i),t.charAt(i));
        }
        return true;
    }
}
