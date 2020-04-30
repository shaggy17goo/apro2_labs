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
