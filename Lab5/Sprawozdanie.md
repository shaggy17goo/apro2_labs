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

*Hasło: N9Qd:7U_2020*


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


