package br.com.projetos.gametracker.service;

import br.com.projetos.gametracker.domain.common.League;
import br.com.projetos.gametracker.domain.request.league.LeagueRequest;
import br.com.projetos.gametracker.domain.response.league.LeagueResponse;

import java.util.List;

public interface LeagueService {

    LeagueResponse createLeague(LeagueRequest leagueRequest);

    LeagueResponse getAllLeagues(int page, int size);

}
