package br.com.projetos.gametracker.controller;

import br.com.projetos.gametracker.domain.enumeration.StatusMessage;
import br.com.projetos.gametracker.domain.request.league.LeagueRequest;
import br.com.projetos.gametracker.domain.response.HttpMetaDataInfo;
import br.com.projetos.gametracker.domain.response.league.LeagueResponse;
import br.com.projetos.gametracker.domain.response.league.LeagueResultSet;
import br.com.projetos.gametracker.domain.validation.ErrorDetail;
import br.com.projetos.gametracker.service.LeagueService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/league")
public class LeagueController extends BaseController {

    private final LeagueService leagueService;

    @Autowired
    public LeagueController(LeagueService leagueService) {
        this.leagueService = leagueService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LeagueResponse> create(@RequestBody @Valid LeagueRequest leagueRequest,
                                                 BindingResult bindingResult) {

        var response = new LeagueResponse();
        var httpInfoResponse = new HttpMetaDataInfo();

        if(bindingResult.hasErrors()) {
            buildValidationFailedResponse(bindingResult, response, httpInfoResponse);
        } else {
            var league = leagueService.create(leagueRequest);
            response.setLeagueResultSet(new LeagueResultSet(league.getId(), league.getName()));
            httpInfoResponse.setStatus(StatusMessage.CREATED.getStatus());
            httpInfoResponse.setMessage(StatusMessage.CREATED.getMessage());
            httpInfoResponse.setHttpStatusCode(HttpStatus.CREATED.value());
            response.setHttpMetaDataInfo(httpInfoResponse);
        }

        return buildResponse(response);
    }

    private void buildValidationFailedResponse(BindingResult bindingResult,
                                                    LeagueResponse response,
                                                    HttpMetaDataInfo httpMetadataInfo) {

        List<ErrorDetail> errors = new ArrayList<>();

        for(FieldError error : bindingResult.getFieldErrors()) {
            String field = error.getField();
            String message = error.getDefaultMessage();
            errors.add(new ErrorDetail(field, message));
        }

        httpMetadataInfo.setStatus(StatusMessage.FAILED.getStatus());
        httpMetadataInfo.setMessage(StatusMessage.FAILED.getMessage());
        httpMetadataInfo.setHttpStatusCode(HttpStatus.BAD_REQUEST.value());
        httpMetadataInfo.setErrorDetails(errors);
        response.setHttpMetaDataInfo(httpMetadataInfo);

    }

}
