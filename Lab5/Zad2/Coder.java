//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


public class Coder {
    public Coder() {
    }

    static String code(String var0) {
        StringBuilder var1 = new StringBuilder();

        for(int var2 = 0; var2 < var0.length(); ++var2) { //dla każdego znaku stinga wejściowego
            var1.append((char)(var0.charAt(var2) + 1));     //znak zamienia się na kolejny znak w tablicy kodowej i dodawany jest do nowego stringa (var1)
        }

        return var1.toString(); //zwrócenie powstałego stringa
    }
}
