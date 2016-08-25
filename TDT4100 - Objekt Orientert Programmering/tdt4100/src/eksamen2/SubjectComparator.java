package eksamen2;

import java.util.Comparator;

/**
 * Created by Niklas on 15.05.2016.
 */
public class SubjectComparator implements Comparator<Subject> {

    @Override
    public int compare(Subject o1, Subject o2) {
        if (o1.getInstituttKode() == o2.getInstituttKode()) {
            return o1.getFagkode() - o2.getFagkode();
        }

        return o1.getInstituttKode().compareTo(o2.getInstituttKode());
    }
}
