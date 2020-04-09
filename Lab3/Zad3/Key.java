class Key {
    protected String text1;
    protected int a1, a2, a3, a4;
    protected double d1, d2;

    public Key(String text1, int a1, int a2, int a3, int a4, double d1, double d2){
        this.text1=text1;
        this.a1=a1;
        this.a2=a2;
        this.a3=a3;
        this.a4=a4;
        this.d1=d1;
        this.d2=d2;
    }
}

class KeyStd extends Key {
    public KeyStd(String text1, int a1, int a2, int a3, int a4, double d1, double d2) {
        super(text1, a1, a2, a3, a4, d1, d2);
    }

    @Override
    public int hashCode() {
        return super.hashCode()/10;
    }
}

class KeyTst extends Key {
    public KeyTst(String text1, int a1, int a2, int a3, int a4, double d1, double d2) {
        super(text1, a1, a2, a3, a4, d1, d2);
    }

    @Override
    public int hashCode() {
        int hash=1;
        hash=((text1.hashCode() + a1*1000+a2*20000+a3*300000+a4*5000000 + (int)(d1*600) + (int)(d2*30))%(Integer.MAX_VALUE/10));
        if(hash>=0)
            return hash;
        else
            return hash+(Integer.MAX_VALUE/10);
    }
}
