package nl.hu.ict.inno.presentation.dto;

public class AddVakToOpleiding {

    private String vakId;
    private String opleidingId;

    public AddVakToOpleiding(String vakId, String opleidingId) {
        this.vakId = vakId;
        this.opleidingId = opleidingId;
    }

    public String getVakId() {
        return vakId;
    }

    public String getOpleidingId() {
        return opleidingId;
    }
}
