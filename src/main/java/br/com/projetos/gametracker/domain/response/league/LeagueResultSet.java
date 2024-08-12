package br.com.projetos.gametracker.domain.response.league;

import br.com.projetos.gametracker.domain.common.Club;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeagueResultSet {

    private String id = "";
    private String name = "";
    private String country = "";

}
