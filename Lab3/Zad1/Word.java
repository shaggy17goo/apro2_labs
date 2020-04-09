import java.util.Objects;

public class Word {
    private String word;

    public Word(String word){
        this.word=word.toLowerCase().replaceAll("\\s+",""); //pozostawione na potrzeby testów, trafiają tu już poprawne stringi
    }
    public Word(){}

    /**
    @return  true if anagram
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word wordTwo=(Word) o;
        if(this.hashCode()!=wordTwo.hashCode()) return false;
        int tab[] = new int[26];
        boolean is = true;
        for (int i = 0; i < this.word.length(); i++)
            tab[this.word.charAt(i)-97]++;          // -97 aby wpisywać do tablicy na początkowych indeksach
        for (int i = 0; i < wordTwo.word.length(); i++)
            tab[wordTwo.word.charAt(i)-97]--;
        for (int i = 0; i <tab.length; i++) {
            if (tab[i] != 0) {
                is = false;
                break;
            }
        }
        return is;
    }

    @Override
    public int hashCode() {
        int hash=0;
        for (int i = 0; i < this.word.length() ; i++) {
            hash+=this.word.charAt(i);
        }
        return hash;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }
}
