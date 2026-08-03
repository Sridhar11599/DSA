import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Stack;

public class BalancedParanthesis {

    @Test
    public void test1() {
        String s = "()";
        Assert.assertEquals(isValidParanthesis(s),true);
    }


    public boolean isValidParanthesis(String s) {
        Stack<Character> stk = new Stack<>();

        for(int i = 0; i<s.length(); i++) {

            if(stk.empty()) {
                char ch = s.charAt(i);
                if(ch == ')' || ch== ']' || ch == '}') {
                    return false;
                }
                stk.push(s.charAt(i));
            } else {
                char ch = s.charAt(i);
                switch(ch) {
                    case ')' :
                        if(stk.peek() == '(') stk.pop();
                        else stk.push(ch);
                        break;
                    case ']':
                        if(stk.peek() == '[') {
                            stk.pop();
                        }
                        else {
                            stk.push(ch);
                        }
                        break;

                    case '}':
                        if(stk.peek() == '{') {
                            stk.pop();
                        }
                        else {
                            stk.push(ch);
                        }
                        break;
                    default :
                        stk.push(ch);
                        break;
                }
            }
        }
        return stk.empty();
    }
}
