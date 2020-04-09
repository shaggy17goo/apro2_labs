public class HashST {
     Key[] stdTab = new Key[Integer.MAX_VALUE/10];
     Key[] tstTab = new Key[Integer.MAX_VALUE/10];

    public int putStd(Key key) {
        KeyStd keyy = new KeyStd(key.text1,key.a1,key.a2,key.a3,key.a4,key.d1,key.d2);
        stdTab[keyy.hashCode()] =  key;
        return keyy.hashCode();
    }

    public int putTst(Key key) {
        KeyTst keyy = new KeyTst(key.text1,key.a1,key.a2,key.a3,key.a4,key.d1,key.d2);
        tstTab[keyy.hashCode()] = key;
        return keyy.hashCode();
    }

    public Key getStd(Key key) {
        KeyStd keyy = new KeyStd(key.text1,key.a1,key.a2,key.a3,key.a4,key.d1,key.d2);
        return stdTab[keyy.hashCode()];
    }

    public Key getTst(Key key) {
        KeyTst keyy = new KeyTst(key.text1,key.a1,key.a2,key.a3,key.a4,key.d1,key.d2);
        return tstTab[keyy.hashCode()];
    }
}