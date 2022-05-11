package ee.pw.edu.pl.Sprzedaze;

import java.util.Objects;

public class InputValidation {
    public static boolean validateName(String nazwa){
        return !nazwa.replaceAll("\\s+", "").equals("");
    }

    //TODO validate NIP
}
