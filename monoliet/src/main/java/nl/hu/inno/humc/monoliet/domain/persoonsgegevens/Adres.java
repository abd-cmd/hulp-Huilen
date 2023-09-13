package nl.hu.inno.humc.monoliet.domain.persoonsgegevens;

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
            throw new RuntimeException();
        }
        if(!isPostcodeValide(postcode)){
            throw new RuntimeException("Postcode is invalid");
        }

        this.plaats = plaats;
        this.postcode = postcode;
        this.straat = straat;
        this.huisnummer = huisnummer;
    }

    private boolean isPostcodeValide(String postcode){
        Pattern regex = Pattern.compile("^[1-9][0-9]{3} ?(?!sa|sd|ss)[a-z]{2}$");
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
