package eksamen2;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Niklas on 15.05.2016.
 */
public final class Functional {

    private final double distance;
    private static final int numb = 2;

    public Functional () {
        //this.numb = numb;
        this.distance = 1;
    }

    public Functional (int numb) {
        //this.numb = numb;
        this.distance = 1;
    }

    private List<Integer> func (Integer... n) {


        int c = 0;
        for (int i : n) {
            n[c++] = (int) Math.pow(3, i);
        }

        //List<Integer> list = Stream.of(n).reduce(new ArrayList<Integer>(), (a, b) -> {a.add(b);});
        //ArrayList<Integer> list = Stream.of(n).collect(Collectors.toCollection(ArrayList::new));
        ArrayList list = new ArrayList<>();
        //Stream.of(1,2,3).forEach(System.out::println);
        Arrays.stream(n).forEach(System.out::println);
        System.out.println("test");
        //System.out.println(list.stream().collect(Collectors.joining(",")));

        return Arrays.stream(n).collect(Collectors.toList());
    }


    public static void main (String[] args) {
        List<Integer> ints = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            ints.add(i);
        }

        System.out.println(ints.stream().filter(a -> a % 2 == 0).map(a -> "" + a).collect(Collectors.joining(",", "[", "]")));
        //System.out.println(ints.stream().filter(a -> a % 2 == 0).reduce(new ArrayList<>(), (a, b) -> a.ad));
        System.out.println(ints.stream().reduce(0, (a, b) -> a + b));
        int val = ints.stream().reduce(0, (a, b) -> a + b);
        System.out.println(val);
        ints.stream().forEach(System.out::print);
        System.out.println("\n");

        List<Integer> ns = new ArrayList<>();
        Map<Integer, String> hns = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            ns.add(i);
            hns.put(i, ((char) (65+i)) + "");
        }

        System.out.println(ns);
        Collections.sort(ns, (a, b) -> b - a);
        ns.remove(ns.indexOf(1));
        System.out.println(ns);
        System.out.println(hns);
        System.out.println("noe".indexOf("n"));
        System.out.println("noe".indexOf("k"));

        Functional f = new Functional(1);
        Functional g = new Functional(3);

        System.out.println(System.out.format("f: %d, g: %d\n", numb, numb));

        System.out.println(f.func(ns.toArray(new Integer[ns.size()])));

        ns = f.addInts(ns, 9, 8);
        System.out.println(ns);
        //ns = ns.stream().distinct().collect(Collectors.toList());
        System.out.println(ns);

        System.out.println(ns.stream().filter(a -> a == 9).count());
        System.out.println(ns.stream().filter(a -> a == 9).reduce(1, (a,b) -> a*b));
        System.out.println(ns.stream().min((a, b) -> a - b));
        System.out.println(ns.stream().sorted((a, b) -> a - b).collect(Collectors.toList()));

        System.out.println(ns.subList(1, ns.size()).stream().collect(Collectors.toList()));

        zeroD(1);

        System.out.println("Something".matches("[A-Za-z]+"));

        String str = "1.016km";
        double v = 0;
        String unit = "";

        Pattern p = Pattern.compile("^(\\d*\\.?\\d*)([A-Za-z]*)$");
        Matcher m = p.matcher(str);

        if (m.find()) {
            System.out.println("Found " + m.groupCount() + " matches");

            if (m.group(1).matches(".*\\d.*")) {
                v = Double.valueOf(m.group(1));
            }

            System.out.println(m.group(1) + "->" + v);

            System.out.println(m.group(2));
        } else {
            System.out.println("Could not find any matches");
        }

        BinaryOperator<Integer> bei = (a, b) -> a + b;
        System.out.println(bei.apply(1,2));

    }

    private List<Integer> addInts (List<Integer> ls, Integer... in) {
        Arrays.stream(in).forEach(ls::add);
        return ls;
    }

    private static int zeroD (int zero) throws ArithmeticException {

        try {
            zero = 1/zero;
        } catch (ArithmeticException e) {
            System.out.println("Dette funka ikke så bra, eller hva?");
        } finally {
            System.out.println("Dere er kokko ass..!");
        }

        System.out.println("Det gikk bra");

        return zero;
    }
}
