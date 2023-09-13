package nl.hu.inno.humc.monoliet.domain;

public class BSA {
    private int minVerplichteStudiePunten;
    private int behaaldeStudiepunten;

    BSA(int minVerplichteStudiePunten) {
        this.minVerplichteStudiePunten = minVerplichteStudiePunten;
        this.behaaldeStudiepunten = 0;
    }
}
