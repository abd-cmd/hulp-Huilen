package nl.hu.ict.inno.presentation.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SendVakToOpdracht {

    private String vakId;

    public SendVakToOpdracht(String vakId) {
        this.vakId = vakId;
    }

    public String getVakId() {
        return vakId;
    }
}
