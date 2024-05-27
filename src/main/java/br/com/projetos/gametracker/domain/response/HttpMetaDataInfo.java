package br.com.projetos.gametracker.domain.response;

import lombok.Data;

@Data
public class HttpInfoResponse {

    private int httpStatusCode;
    private String status;
    private String message;

}
