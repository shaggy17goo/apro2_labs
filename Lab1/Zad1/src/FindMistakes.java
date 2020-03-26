import java.io.*;
import java.util.Properties;
import java.util.Scanner;
import java.util.Stack;

class FindMistakes {
/**
 * return true when file doesn't contain mistakes
 * return false when file contains mistakes
 */
    public boolean withoutMistakes(String path) throws IOException {
        Stack<String> stack = new Stack<>();
        final Properties props = new Properties();
        props.load(new FileReader("test1.txt"));        // ścieżka do pliku z properties
        final int count = Integer.parseInt(props.getProperty("count"));
        try {
            File xmlFile = new File(path);
            Scanner scan = new Scanner(xmlFile);
            String propertyName;
            String data;        // skan kolejnej lini
            String subData;     // podział data na kolejne znaczniki
            while (scan.hasNextLine()) {
                data = scan.nextLine();
                while (data.contains("<")) {
                    subData = data.substring(data.indexOf('<') + 1, data.indexOf('>'));     //+1 aby pominąć '<'
                    data = data.substring(data.indexOf('>') + 1);                           //+1 aby pominąć '>'
                    for (int i = 1; i <= count; i++) {
                        propertyName = "e" + i;
                        if (subData.charAt(0) != '/') {     //<xyz> znaczniki otwierające
                            if (subData.equals(props.getProperty(propertyName))) {
                                stack.push(subData);
                            }
                        }
                        if (subData.charAt(0) == '/') {     //</xyz> znaczniki zamykające
                            if (subData.substring(1).equals(props.getProperty(propertyName))) {   //sprawdzenie czy pasuje do któregoś z properties
                                if(stack.isEmpty()){return false;}
                                if (subData.substring(1).equals(stack.peek())) {                  //sprawdzenie czy pasuje do tego co chcemy zdjąć
                                    stack.pop();
                                }
                            }
                        }
                    }
                }
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (stack.isEmpty()) {
            System.out.println("OK");
            return true;
        } else {
            System.out.println("NOK");
            return false;
        }
    }
}