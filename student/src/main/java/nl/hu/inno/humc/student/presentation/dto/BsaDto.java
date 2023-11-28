package nl.hu.inno.humc.student.presentation.dto;

import nl.hu.inno.humc.student.domain.BSA;

public class BsaDto {
    private int behaaldeEC;
    private int totaalEC;
    private boolean bsaBehaald;

    public BsaDto(int behaaldeEC, int totaalEC, boolean bsaBehaald) {
        this.behaaldeEC = behaaldeEC;
        this.totaalEC = totaalEC;
        this.bsaBehaald = bsaBehaald;
    }

    public BsaDto() {
    }

    public static BsaDto Of(BSA bsa) {
        return new BsaDto(bsa.getBehaaldeStudiepunten(), bsa.getMinVerplichteStudiePunten(), bsa.isBSABehaald());
    }

    public int getBehaaldeEC() {
        return behaaldeEC;
    }

    public int getTotaalEC() {
        return totaalEC;
    }

    public boolean isBsaBehaald() {
        return bsaBehaald;
    }
}
