package nl.hu.ict.inno.presentation.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AddVakToOpleiding {
    @JsonProperty("id")
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
