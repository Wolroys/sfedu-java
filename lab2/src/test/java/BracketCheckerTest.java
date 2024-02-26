import com.sfedu.CustomStack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

public class BracketCheckerTest {

    @Test
    void stackLengthShouldEquals3(){
        CustomStack<Integer> stack = new CustomStack<>();

        assertTrue(stack.isEmpty());

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.size());
    }

    @Test
    void popShouldReturn3(){
        CustomStack<Integer> stack = new CustomStack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.pop());
    }

    @Test
    void popShouldThrowsException(){
        CustomStack<Integer> stack = new CustomStack<>();

        assertThrows(RuntimeException.class, stack::pop);
    }

    @Test
    void allBracketsShouldBeCorrect(){

    }
}
