package eksamen2;

/**
 * Created by Niklas on 15.05.2016.
 */
public class RobberLangParseException extends IllegalArgumentException {

    public RobberLangParseException (String msg, char illegalChar) {
        super(msg);

        System.out.println("Dette er ikke gyldig: " + illegalChar);
    }
}
