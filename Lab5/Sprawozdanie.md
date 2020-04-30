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
