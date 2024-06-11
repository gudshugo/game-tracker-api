package br.com.projetos.gametracker.controller;

import br.com.projetos.gametracker.domain.response.BaseResponse;
import org.springframework.http.ResponseEntity;

public abstract class BaseController {

    protected <T extends BaseResponse> ResponseEntity<T> buildResponse(T response) {

        var statusCode = response.getHttpMetaDataInfo().getHttpStatusCode();
        return ResponseEntity.status(statusCode).body(response);

    }

}
