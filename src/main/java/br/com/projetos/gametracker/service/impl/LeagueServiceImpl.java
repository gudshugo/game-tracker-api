package br.com.projetos.gametracker.service.impl;

import br.com.projetos.gametracker.domain.common.League;
import br.com.projetos.gametracker.domain.request.league.LeagueRequest;
import br.com.projetos.gametracker.domain.response.Pagination;
import br.com.projetos.gametracker.domain.response.league.LeagueResponse;
import br.com.projetos.gametracker.domain.response.league.LeagueResultSet;
import br.com.projetos.gametracker.repository.LeagueRepository;
import br.com.projetos.gametracker.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeagueServiceImpl implements LeagueService {

    private final LeagueRepository leagueRepository;

    @Autowired
    public LeagueServiceImpl(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }

    @Override
    public LeagueResponse createLeague(LeagueRequest leagueRequest) {

        var leagueResponse = new LeagueResponse();
        var league = new League();

        league.setName(leagueRequest.getName());
        league.setCountry(leagueRequest.getCountry());

        leagueResponse.setLeagueResultSet(buildLeagueResultSetResponse(List.of(league)));
        leagueRepository.save(league);

        return leagueResponse;
    }

    @Override
    public LeagueResponse getAllLeagues(int page, int size) {

        var pageable = PageRequest.of(page, size);
        var pageResult = leagueRepository.findAll(pageable);
        var leagueResponse = new LeagueResponse();

        leagueResponse.setLeagueResultSet(buildLeagueResultSetResponse(pageResult.getContent()));
        leagueResponse.setPagination(new Pagination(page, size, pageResult.getTotalPages(), pageResult.getTotalElements()));

        return leagueResponse;
    }

    private List<LeagueResultSet> buildLeagueResultSetResponse(List<League> leagues){
        return leagues.stream()
                .map(league -> new LeagueResultSet(league.getId(),
                        league.getName(),
                        league.getCountry()))
                .collect(Collectors.toList());
    }

}
