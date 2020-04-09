import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.Instant;
import java.util.Random;

public class Main {
    /**
     * funkcja generująca losowy string o długości 10
     */
    public static String generateRandomString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

    /**
     * funkcja generująca losowy klucz std
     */
    public static KeyStd generateRandomKeyStd(){
        Random random = new Random();
        String text1=generateRandomString();
        int a1=random.nextInt(1000), a2=random.nextInt(1000), a3=random.nextInt(1000), a4=random.nextInt(1000);
        double d1=random.nextDouble(), d2=random.nextDouble();
        return new KeyStd(text1,a1,a2,a3,a4,d1,d2);
    }
    /**
     * funkcja generująca losowy klucz tst
     */
    public static KeyTst generateRandomKeyTst(){
        Random random = new Random();
        String text1=generateRandomString();
        int a1=random.nextInt(1000), a2=random.nextInt(1000), a3=random.nextInt(1000), a4=random.nextInt(1000);
        double d1=random.nextDouble(), d2=random.nextDouble();
        return new KeyTst(text1,a1,a2,a3,a4,d1,d2);
    }
    public static void main(String[] args) throws FileNotFoundException {
        HashST hashST = new HashST();
        KeyStd[] stdTab = new KeyStd[1000000];
        KeyTst[] tstTab = new KeyTst[1000000];

        PrintWriter save = new PrintWriter("wyniki.txt");
        for (int l = 0; l <10; l++) {
            //Generowanie kluczyStd
            for (int i = 0; i < 1000000; i++) {
                stdTab[i] = (generateRandomKeyStd());
            }

            //Generowanie kluczyTst
            for (int i = 0; i < 1000000; i++) {
                tstTab[i] = (generateRandomKeyTst());
            }


            //Dodawanie kluczyStd
            long startTimeStd = Instant.now().toEpochMilli();
            for (int i = 0; i < 1000000; i++) {
                hashST.putStd(stdTab[i]);
            }
            long endTimeStd = Instant.now().toEpochMilli();
            long timeElapsedStd = endTimeStd - startTimeStd;

            //wyszukiwanie kluczyStd
            long startTimeStdF = Instant.now().toEpochMilli();
            for (int i = 0; i < 1000000; i++) {
                hashST.putStd(stdTab[i]);
            }
            long endTimeStdF = Instant.now().toEpochMilli();
            long timeElapsedStdF = endTimeStdF - startTimeStdF;

            //Dodawanie kluczyTst
            long startTimeTst = Instant.now().toEpochMilli();
            for (int i = 0; i < 1000000; i++) {
                hashST.putTst(tstTab[i]);
            }
            long endTimeTst = Instant.now().toEpochMilli();
            long timeElapsedTst = endTimeTst - startTimeTst;

            //wyszukiwanie kluczyTst
            long startTimeTstF = Instant.now().toEpochMilli();
            for (int i = 0; i < 1000000; i++) {
                hashST.putTst(tstTab[i]);
            }
            long endTimeTstF = Instant.now().toEpochMilli();
            long timeElapsedTstF = endTimeTstF - startTimeTstF;

            save.println("Czas dodowania z standardowym hashCodem: " + timeElapsedStd);
            save.println("Czas wyszukiwania z standardowym hashCodem: " + timeElapsedStdF);
            save.println("Czas dodawania z testowym hashCodem: " + timeElapsedTst);
            save.println("Czas wyszukiwania z testowym hashCodem: " + timeElapsedTstF);
            save.println();
            //Wniosek:
            //Funkcjie tworzce tablice dzialaja w podobnym czasie, aczkolwiek troche szybsza wydaje sie testowa funkcja hashujaca
            //Podobnie sytuacja wyglda z wyszukiwaniem elementow w tablicach
        }
        save.close();
    }
}
