package eksamen2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Niklas on 15.05.2016.
 */
public class Functional {

    public static void main (String[] args) {
        List<Integer> ints = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            ints.add(i);
        }

        System.out.println(ints.stream().filter(a -> a % 2 == 0).map(a -> a.toString()).collect(Collectors.joining(",", "[", "]")));
        System.out.println(ints.stream().reduce((a, b) -> a + b));
    }
}
