import com.sfedu.task1.CustomStack;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {

    @Test
    public void stackLengthShouldEquals3(){
        CustomStack<Integer> stack = new CustomStack<>();

        assertTrue(stack.isEmpty());

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.size());
    }

    @Test
    public void popShouldReturn3(){
        CustomStack<Integer> stack = new CustomStack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        int popEl = stack.pop();

        assertEquals(3, popEl);
    }

    @Test
    public void popShouldThrowsException(){
        CustomStack<Integer> stack = new CustomStack<>();

        assertThrows(RuntimeException.class, stack::pop);
    }

    @Test
    public void bracketsShouldBeCorrect(){
        assertTrue(isBracketsBalanced("({[]})"));

        assertFalse(isBracketsBalanced("({[}])"));

        assertTrue(isBracketsBalanced("/* begin end */"));

        assertFalse(isBracketsBalanced("/* begin end */ {"));
    }

    private boolean isBracketsBalanced(String str) {
        CustomStack<String> stack = new CustomStack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            switch (c) {
                case '(':
                case '{':
                case '[':
                case '<':
                case 'b':
                    stack.push(String.valueOf(c));
                    break;
                case '/':
                    if (i < str.length() - 1 && str.charAt(i + 1) == '*') {
                        stack.push("/*");
                        i++;
                    }
                    break;
                case ')':
                    if (stack.isEmpty() || !stack.pop().equals("(")) return false;
                    break;
                case '}':
                    if (stack.isEmpty() || !stack.pop().equals("{")) return false;
                    break;
                case ']':
                    if (stack.isEmpty() || !stack.pop().equals("[")) return false;
                    break;
                case '>':
                    if (stack.isEmpty() || !stack.pop().equals("<")) return false;
                    break;
                case '*':
                    if (i < str.length() - 1 && str.charAt(i + 1) == '/' && (!stack.isEmpty() &&
                            stack.pop().equals("/*"))) {
                        i++;
                    } else {
                        return false;
                    }
                    break;
                case 'd':
                    if (stack.isEmpty() || !stack.pop().equals("b")) return false;
                    break;
            }
        }
        return stack.isEmpty();
    }
}
