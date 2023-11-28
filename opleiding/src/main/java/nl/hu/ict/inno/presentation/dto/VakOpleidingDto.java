package nl.hu.ict.inno.presentation.dto;

public record VakOpleidingDto(
        String opleidingId,
        String vakId
) {
    @Override
    public String opleidingId() {
        return opleidingId;
    }

    @Override
    public String vakId() {
        return vakId;
    }
}
