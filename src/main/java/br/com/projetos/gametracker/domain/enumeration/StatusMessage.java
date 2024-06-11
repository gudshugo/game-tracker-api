package br.com.projetos.gametracker.domain.enumeration;

public enum StatusMessage {

    CREATED("CREATED", "Resource has been created successfully."),
    FAILED("FAILED", "A problem has occurred."),
    RETRIEVED("RETRIEVED", "Resource (s) retrieved successfully."),
    NO_RESULTS("NO_RESULTS", "No results found.");

    private final String status;
    private final String message;

    StatusMessage(String status, String message){
        this.status = status;
        this.message = message;
    }

    public String getStatus(){
        return status;
    }

    public String getMessage(){
        return message;
    }

}
