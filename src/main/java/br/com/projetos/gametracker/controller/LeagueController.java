package br.com.projetos.gametracker.controller;

import br.com.projetos.gametracker.domain.common.League;
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
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/league")
public class LeagueController extends BaseController {

    private final LeagueService leagueService;

    @Autowired
    public LeagueController(LeagueService leagueService) {
        this.leagueService = leagueService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LeagueResponse> createLeague(@RequestBody @Valid LeagueRequest leagueRequest,
                                                       BindingResult bindingResult) {

        var response = new LeagueResponse();
        var httpInfoResponse = new HttpMetaDataInfo();

        if(bindingResult.hasErrors()) {
            buildValidationFailedResponse(bindingResult, response, httpInfoResponse);
        } else {
            response = leagueService.createLeague(leagueRequest);
            httpInfoResponse.setStatus(StatusMessage.CREATED.getStatus());
            httpInfoResponse.setMessage(StatusMessage.CREATED.getMessage());
            httpInfoResponse.setHttpStatusCode(HttpStatus.CREATED.value());
            response.setHttpMetaDataInfo(httpInfoResponse);
        }

        return buildResponse(response);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LeagueResponse> getAllLeagues(@RequestParam(defaultValue = "0") int page,
                                                        @RequestParam(defaultValue = "2") int size) {
        var response = leagueService.getAllLeagues(page, size);
        buildGetResponse(response);
        return buildResponse(response);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LeagueResponse> getLeagueDetails(@PathVariable String id) {
        var response = leagueService.getLeagueDetails(id);
        buildGetResponse(response);
        return buildResponse(response);
    }

}
