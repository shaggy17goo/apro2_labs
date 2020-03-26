import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

import java.io.IOException;

public class FindMistakesTest {
    FindMistakes findMis=new FindMistakes();
    @Test
    public void test() throws IOException {
        assertTrue(findMis.withoutMistakes("test1.xml"));
        assertTrue(findMis.withoutMistakes("test2.xml"));
        assertFalse(findMis.withoutMistakes("test1fail.xml"));
        assertFalse(findMis.withoutMistakes("test2fail.xml"));
        assertFalse(findMis.withoutMistakes("test3fail.xml"));
        assertFalse(findMis.withoutMistakes("test4fail.xml"));
    }
}
