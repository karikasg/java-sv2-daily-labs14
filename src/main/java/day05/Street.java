package day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Street {

    Map<String, List<Integer>> street = new HashMap<>();

    public void listStreet(Path path) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(path)) {
            String[] elements;
            String line;
            while ((line = br.readLine()) != null) {
                elements = line.split(" ");
                String strt = elements[0];
                int number = Integer.parseInt(elements[1]);
                insertNewHouse(strt, number);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("File beolvasási hiba", ioe);
        }
        street.entrySet().stream().forEach(o -> System.out.println(o.getKey() + " " + o.getValue()));
    }

    public void insertNewHouse(String strt, int number) {
        if (!street.containsKey(strt)) {
            street.put(strt, new ArrayList<>());
            street.get(strt).add(-number + 2);
        } else {
            street.get(strt).add(street.get(strt).stream().filter(o -> o % 2 == number).max(Comparator.comparingInt(o -> o)).orElse(-number) + 2);
        }
    }

    public static void main(String[] args) {
        Street streets = new Street();
        streets.listStreet(Path.of("src/main/resources/streets.txt"));
    }
}