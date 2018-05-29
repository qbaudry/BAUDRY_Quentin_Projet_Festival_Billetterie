package Properties;

/**
 *
 * @author tguyot
 */
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class Reader {

    //Retourne la valeur de la variable saisie en paramètre du fichier properties
    public static String readString(String searchedString) {
        Properties pReader = new Properties();
        try {
            pReader.load(Reader.class.getResourceAsStream("Billetterie.properties"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return pReader.getProperty(searchedString);
    }

    public static List<String> readStrings(String searchedString) {
        Properties pReader = new Properties();
        try {
            pReader.load(Reader.class.getResourceAsStream("Billetterie.properties"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return Arrays.asList(pReader.getProperty(searchedString).split(","));
    }
}
