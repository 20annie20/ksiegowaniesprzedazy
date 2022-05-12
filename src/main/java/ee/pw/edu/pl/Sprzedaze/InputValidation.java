package ee.pw.edu.pl.Sprzedaze;

import java.util.Date;
import java.util.Objects;

public class InputValidation {
    public static boolean validateName(String nazwa){
        return !nazwa.replaceAll("\\s+", "").equals("");
    }

    public static boolean validateDate(Date dataWystawienia) {
        return !dataWystawienia.equals(null);
    }

    //TODO validate NIP
}
