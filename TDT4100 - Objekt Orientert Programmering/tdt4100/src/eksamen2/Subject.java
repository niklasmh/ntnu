package eksamen2;

/**
 * Created by Niklas on 15.05.2016.
 */
public class Subject implements Comparable<Subject> {

    String name;
    String InstituttKode;
    int fagkode;
    double studiepoeng;
    int antall;

    public Subject (String name, String InstituttKode, int fagkode, double studiepoeng, int antall) {
        this.name = name;
        this.InstituttKode = InstituttKode;
        this.fagkode = fagkode;
        this.studiepoeng = studiepoeng;
        this.antall = antall;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getName () {
        return this.name;
    }

    public void setFagkode (int fagkode) {
        this.fagkode = fagkode;
    }

    public int getFagkode () {
        return this.fagkode;
    }

    public void setInstituttKode (String InstituttKode) {
        this.InstituttKode = InstituttKode;
    }

    public String getInstituttKode () {
        return this.InstituttKode;
    }

    public void setStudiepoeng (int fagkode) {
        this.fagkode = fagkode;
    }

    public int getStudiepoeng () {
        return this.fagkode;
    }

    @Override
    public int compareTo(Subject o) {
        return this.name.compareTo(o.getName());
    }

}
