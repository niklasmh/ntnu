package eksamen;

/**
 * Created by Niklas on 14.05.2016.
 */
public class Abakule extends Student {

    public Abakule () {
        super();
    }

    @Override
    public void sjekk () {
        System.out.println("Nice");
    }

    public static void main (String[] args) {
        eksamen.Oneliner one = new eksamen.Oneliner();
        one.kont();
        System.out.println(one.favorittTall);
    }
}
