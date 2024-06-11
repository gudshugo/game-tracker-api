package br.com.projetos.gametracker.domain.response.league;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeagueResultSet {

    private String id = "";
    private String name = "";
    private String country = "";

}
