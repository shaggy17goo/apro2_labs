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

