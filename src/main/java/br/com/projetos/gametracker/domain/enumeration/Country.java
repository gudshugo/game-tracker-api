package br.com.projetos.gametracker.domain.enumeration;

public enum Country {

    BRA("BRA", "Brazil"),
    ARG("ARG", "Argentina"),
    GER("GER", "Germany");

    private final String code;
    private final String description;

    Country(String code, String description){
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static boolean isValidCountry(String code) {
        for(Country country : Country.values()){
            if(country.getCode().equals(code)){
                return true;
            }
        }
        return false;
    }

}
