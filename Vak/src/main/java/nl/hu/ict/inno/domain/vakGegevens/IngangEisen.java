package nl.hu.ict.inno.domain.vakGegevens;

import jakarta.persistence.Embeddable;

import java.util.Objects;

public class IngangEisen {

    private int EC;
    private boolean vrijstelling;

    public IngangEisen() {

    }

    public IngangEisen(int EC, Boolean vrijstelling) {
        this.EC = EC;
        this.vrijstelling = vrijstelling;
        this.ValidateStudentIngangEisen(EC,vrijstelling);
    }

    public int getEC() {
        return EC;
    }

    public void setEC(int EC) {
        this.EC = EC;
    }

    public boolean getVrijstelling() {
        return vrijstelling;
    }

    public void setVrijstelling(boolean vrijstelling) {
        this.vrijstelling = vrijstelling;
    }

    public boolean ValidateStudentIngangEisen(int StudentEC,boolean vrijstelling){
        if(StudentEC <= EC && vrijstelling){
            return true;
        }

        return EC == StudentEC || StudentEC > EC;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IngangEisen that = (IngangEisen) o;
        return EC == that.EC;
    }

    @Override
    public int hashCode() {
        return Objects.hash(EC);
    }
}
