import com.sfedu.task1.Stack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    @Test
    void stackLengthShouldEquals3(){
        Stack<Integer> stack = new Stack<>();

        assertTrue(stack.isEmpty());

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.size());
    }

    @Test
    void popShouldReturn3(){
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.pop());
    }

    @Test
    void popShouldThrowsException(){
        Stack<Integer> stack = new Stack<>();

        assertThrows(RuntimeException.class, stack::pop);
    }

    @Test
    void bracketsShouldBeCorrect(){
        assertTrue(isBracketsBalanced("({[]})"));

        assertFalse(isBracketsBalanced("({[}])"));

        assertTrue(isBracketsBalanced("/* begin end */"));

        assertFalse(isBracketsBalanced("/* begin end */ {"));
    }

    boolean isBracketsBalanced(String str) {
        Stack<String> stack = new Stack<>();
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