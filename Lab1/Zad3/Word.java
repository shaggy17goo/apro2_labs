public class Word{
    public String string;
    int times;
    public Word(String string){
        this.string=string;
        this.times =0;
    }

    public int compareTo1(Word word) {
        return word.string.compareTo(this.string);
    }
    public int compareTo2(Word word) {
        return word.string.length()-this.string.length();
    }
}
