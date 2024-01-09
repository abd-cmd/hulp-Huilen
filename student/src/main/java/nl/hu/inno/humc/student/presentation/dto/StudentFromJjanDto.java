package nl.hu.inno.humc.student.presentation.dto;

public class StudentFromJjanDto {

        private Long studentNummer;
        private String achternaam;
        private String voornaam;

        public StudentFromJjanDto(Long studentNummer, String achternaam, String voornaam) {
            this.studentNummer = studentNummer;
            this.achternaam = achternaam;
            this.voornaam = voornaam;
        }

        public StudentFromJjanDto() {
        }

        public Long getStudentNummer() {
            return studentNummer;
        }

        public String getAchternaam() {
            return achternaam;
        }

        public String getVoornaam() {
            return voornaam;
        }

}
