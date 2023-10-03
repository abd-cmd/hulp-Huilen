package nl.hu.inno.humc.monoliet.domain.vak;

import java.time.LocalDate;

public class VakGegevensValideren {

    public static boolean checkVakDatums(LocalDate firstDatum,LocalDate secondDatum){
        if(firstDatum.isAfter(secondDatum)){
            return false;
        }else if(secondDatum.isBefore(firstDatum)){
            return false;
        }else if(firstDatum.equals(secondDatum)){
            return false;
        }
        return true;
    }

    public static boolean checkVakHasNaamAndPeriode(String naam,int periode){
        if (naam.isEmpty()){
            return false;
        }

        if(periode == 0){
            return false;
        }

        return true;
    }
}
