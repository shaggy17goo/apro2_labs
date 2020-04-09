import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindAnagramTest {
    FindAnagram test1 = new FindAnagram();

    @Test
    void isAnagram() {
        assertEquals((new Word("")), new Word(""));
        assertEquals((new Word("a")), new Word("a"));
        assertEquals((new Word("ab")), new Word("ba"));
        assertEquals((new Word("aba")), new Word("aba"));
        assertEquals((new Word("michal")), new Word("Milach"));
        assertEquals((new Word("przykladowe")), new Word("przekladowy"));
        assertEquals((new Word("George Bush")), new Word("He bugs Gore"));
        assertEquals((new Word("I am Lord Voldemort")), new Word("Tom Marvolo Riddle"));
    }

    @Test
    void countSubWordAnagram() {
        assertTrue(0 == test1.countSubWordAnagram(""));
        assertTrue(4 == test1.countSubWordAnagram("kkk"));
        assertTrue(2 == test1.countSubWordAnagram("aba"));


        assertTrue(12 == test1.countSubWordAnagram("Ala ma Kota"));
        System.out.println("anagramy sposrod substringow w stringu ''Ala ma Kota'': (" + test1.anagrams.size() + ")");
        for (int i = 0; i < test1.anagrams.size(); i++) {
            System.out.println(test1.anagrams.get(i));
        }

        System.out.println();
        assertTrue(9 == test1.countSubWordAnagram("alibaba"));
        System.out.println("anagramy sposrod substringow w stringu ''alibaba'': (" + test1.anagrams.size() + ")");
        for (int i = 0; i < test1.anagrams.size(); i++) {
            System.out.println(test1.anagrams.get(i));
        }
    }

    @Test
    void exceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> test1.countSubWordAnagram("dobry+"));
        assertThrows(IllegalArgumentException.class, () -> test1.countSubWordAnagram("Sie,Mma"));
        assertThrows(IllegalArgumentException.class, () -> test1.countSubWordAnagram("masŁko"));

    }
}