import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Parser extends Thread {

    private String fileName;
    private HashMap<String, Set<String>> map = new HashMap<>();

    public Parser(String fileName) {
        this.fileName = fileName;
    }

    public HashMap<String, Set<String>> getMap() {
        return map;
    }

    @Override
    public void run() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            String[] titles = bufferedReader.readLine().split(";");
            HashSet<String>[] setList = new HashSet[titles.length];
            for (int i = 0; i < titles.length; i++) {
                setList[i] = new HashSet<>();
                map.put(titles[i], setList[i]);
            }
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(";");
                for (int i = 0; i < titles.length; i++) {
                    setList[i].add(data[i]);
                    map.replace(titles[i], setList[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
