package ForTest;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

public class Test {

    public static Map<String, Long> getSalesMap(Reader reader) throws IOException {
        Map<String, Long> resultHashMap = new LinkedHashMap<>();
        Scanner scanner = new Scanner(reader);
        while (scanner.hasNextLine()){
            StringBuilder stringBuilder = new StringBuilder(scanner.nextLine());
            String stringValue = stringBuilder.substring(0,stringBuilder.indexOf(" "));
            Long longValue = new Scanner(stringBuilder.substring(stringBuilder.indexOf(" ") + 1)).nextLong();
            System.out.println(stringValue);
            System.out.println(longValue);
            if (!resultHashMap.containsKey(stringValue)){
                resultHashMap.put(stringValue,longValue);
            } else {
                resultHashMap.replace(stringValue, resultHashMap.get(stringValue), resultHashMap.get(stringValue) + longValue);
            }
        }
        reader.close();
        return resultHashMap;
    }
    public static void main(String[] args) {
        try {
            Reader reader = new FileReader("src//ForTest//f11.txt");
            System.out.println(getSalesMap(reader));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}