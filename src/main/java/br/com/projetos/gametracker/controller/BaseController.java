package br.com.projetos.gametracker.controller;

import br.com.projetos.gametracker.domain.enumeration.StatusMessage;
import br.com.projetos.gametracker.domain.response.BaseResponse;
import br.com.projetos.gametracker.domain.response.HttpMetaDataInfo;
import br.com.projetos.gametracker.domain.response.league.LeagueResponse;
import br.com.projetos.gametracker.domain.validation.ErrorDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseController {

    protected <T extends BaseResponse> ResponseEntity<T> buildResponse(T response) {

        var statusCode = response.getHttpMetaDataInfo().getHttpStatusCode();
        return ResponseEntity.status(statusCode).body(response);

    }

    protected void buildValidationFailedResponse(BindingResult bindingResult,
                                               LeagueResponse response,
                                               HttpMetaDataInfo httpMetaDataInfo) {

        List<ErrorDetail> errors = new ArrayList<>();

        for(FieldError error : bindingResult.getFieldErrors()) {
            String field = error.getField();
            String message = error.getDefaultMessage();
            errors.add(new ErrorDetail(field, message));
        }

        httpMetaDataInfo.setStatus(StatusMessage.FAILED.getStatus());
        httpMetaDataInfo.setMessage(StatusMessage.FAILED.getMessage());
        httpMetaDataInfo.setHttpStatusCode(HttpStatus.BAD_REQUEST.value());
        httpMetaDataInfo.setErrorDetails(errors);
        response.setHttpMetaDataInfo(httpMetaDataInfo);

    }

    protected void buildGetResponse(LeagueResponse response){

        var httpMetaDataInfo = new HttpMetaDataInfo();
        var resultSet = response.getLeagueResultSet();

        if (resultSet.isEmpty()) {
            httpMetaDataInfo.setStatus(StatusMessage.NO_RESULTS.getStatus());
            httpMetaDataInfo.setMessage(StatusMessage.NO_RESULTS.getMessage());
        } else {
            httpMetaDataInfo.setStatus(StatusMessage.RETRIEVED.getStatus());
            httpMetaDataInfo.setMessage(StatusMessage.RETRIEVED.getMessage());
        }

        httpMetaDataInfo.setHttpStatusCode(HttpStatus.OK.value());
        response.setHttpMetaDataInfo(httpMetaDataInfo);

    }

}
