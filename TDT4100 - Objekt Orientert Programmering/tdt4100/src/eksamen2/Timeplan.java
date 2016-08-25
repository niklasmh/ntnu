package eksamen2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Niklas on 15.05.2016.
 */
public class Timeplan implements Iterable<Subject> {

    List<Subject> timeplan = new ArrayList<>();

    public Timeplan (Subject... s) {

        for (Subject emne : s) {
            this.timeplan.add(emne);
        }
    }

    public List<Subject> getTimeplan () {
        return this.timeplan;
    }

    public void sortTimeplan () {
        Collections.sort(this.timeplan);
    }

    public static void main (String[] args) {
        List<Subject> subs = new ArrayList<>();

        subs.add(new Subject("OOP", "TDT", 4100, 7.5, 18));
        subs.add(new Subject("Samf", "SOK", 1234, 15, 15));

        Timeplan tp = new Timeplan(subs.get(0), subs.get(1));

        System.out.println(tp.getTimeplan());
        tp.sortTimeplan();
        System.out.println(tp.getTimeplan());

        Iterator<Subject> it = tp.iterator();

        while (it.hasNext()) {
            Subject s = it.next();

            if (s == subs.get(1)) {
                it.remove();
            }
        }
    }

    @Override
    public Iterator<Subject> iterator() {
        return timeplan.iterator();
    }
}
