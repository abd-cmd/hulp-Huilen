package nl.hu.inno.humc.monoliet.domain.student.persoonsgegevens;

import nl.hu.inno.humc.monoliet.domain.student.exceptions.InvalidPostcodeException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Adres {

    private String plaats;
    private String postcode;
    private String straat;
    private String huisnummer;

    protected Adres(){}

    public Adres(String plaats, String postcode, String straat, String huisnummer){

        // Check of string null of leeg, of alleen uit spaties bestaat
        if(plaats.isBlank() || postcode.isBlank()|| straat.isBlank()|| huisnummer.isBlank()) {
            throw new IllegalArgumentException("Adres waardes mogen niet leeg zijn");
        }
        if(!isPostcodeValide(postcode)){
            throw new InvalidPostcodeException("Ongeldige postcode: " + postcode);
        }

        this.plaats = plaats;
        this.postcode = postcode;
        this.straat = straat;
        this.huisnummer = huisnummer;
    }

    private boolean isPostcodeValide(String postcode){
        Pattern regex = Pattern.compile("^[1-9][0-9]{3}?[a-zA-Z]{2}$");
        Matcher matcher = regex.matcher(postcode);
        return matcher.matches();
    }



    public String getPlaats() {
        return plaats;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getStraat() {
        return straat;
    }

    public String getHuisnummer() {
        return huisnummer;
    }
}
