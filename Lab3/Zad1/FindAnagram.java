import java.io.IOException;
import java.util.ArrayList;

public class FindAnagram {
    ArrayList<String> anagrams = new ArrayList<>();
    public FindAnagram() {}

    public FindAnagram(String word) {
        countSubWordAnagram(word);
    }

    public int countSubWordAnagram(String word) {
        word=word.toLowerCase().replaceAll("\\s+","");
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i)>122||word.charAt(i)<97){     // od 97 do 122 - małe litery alfabetu w ASCII/Unicode
                throw new IllegalArgumentException("Blad! string zawiera niedozwolone znaki.");
            }
        }
        anagrams = new ArrayList<>();
        int length = 1;
        Word subWordMain = new Word();
        Word subWordComp = new Word();
        while (length < word.length()) {
            for (int i = 0; i + length <= word.length(); i++) {
                subWordMain.setWord(word.substring(i, i + length));
                for (int j = i + 1; j + length <= word.length(); j++) {
                    subWordComp.setWord(word.substring(j, j + length));
                    if (subWordMain.equals(subWordComp))
                        anagrams.add(subWordMain.getWord() + ", " + subWordComp.getWord());
                }
            }
            length++;
        }
        return anagrams.size();
    }

}
