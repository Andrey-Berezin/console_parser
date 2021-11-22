import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Parser[] parsers = new Parser[args.length];
        HashMap<String, Set<String>> resultMap = new HashMap<>();
        for (int i = 0; i < args.length; i++) {
            Parser parser = new Parser(args[i]);
            parsers[i] = parser;
            parser.start();
        }
        for (int i = 0; i < parsers.length; i++) {
            try {
                parsers[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (String key : parsers[i].getMap().keySet()) {
                if (resultMap.containsKey(key)) {
                    resultMap.get(key).addAll(parsers[i].getMap().get(key));
                } else {
                    resultMap.put(key, parsers[i].getMap().get(key));
                }
            }
        }
        Main.generateFiles(resultMap);
        for (Map.Entry entry : resultMap.entrySet()) {
            System.out.println(entry);
        }
    }

    public static void generateFiles(HashMap<String, Set<String>> map) {
        for (String key : map.keySet()) {
            String fileWriteName = String.format("%s.csv", key);
            try (FileWriter fw = new FileWriter(fileWriteName)) {
                String string = String.valueOf(map.get(key));
                fw.write(string.substring(1, string.length() - 1));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
