package br.com.projetos.gametracker.domain.enumeration;

public enum MessageStatus {

    CREATED("CREATED", "Resource has been created successfully."),
    FAILED("FAILED", "A problem has occurred.");

    private final String status;
    private final String message;

    MessageStatus(String status, String message){
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
