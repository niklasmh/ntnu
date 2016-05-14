package eksamen;

/**
 * Created by Niklas on 14.05.2016.
 */
public class Oneliner extends Student {

    public Oneliner () {
        super();
    }

    @Override
    public void sjekk () {
        if (true) {
            System.out.println("Smooth");
        }

        super.sjekk();
    }

    public static void main (String[] args) {
        Oneliner one = new Oneliner();
        one.kont();
        System.out.println(one.favorittTall);
    }
}
