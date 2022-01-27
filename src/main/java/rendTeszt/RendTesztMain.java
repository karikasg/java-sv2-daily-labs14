package rendTeszt;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class RendTesztMain {

    public static void main(String[] args) {
        Random random = new Random();
        List<RendTeszt> list = new ArrayList<>();
        for (int i = 0; i < 20000000; i++) {
            list.add(new RendTeszt(((char) (random.nextInt(26)+65)), random.nextInt(200)) );
        }
        LocalTime time = LocalTime.now();
        list = list.stream().sorted(Comparator.comparing(RendTeszt::getNumber)).sorted(Comparator.comparing(RendTeszt::getText)).toList();
//        list = list.stream().sorted(Comparator.comparing(RendTeszt::getNumber).thenComparing(o -> o.getText())).toList();
        System.out.println(Duration.between(time, LocalTime.now()));
    }
}
