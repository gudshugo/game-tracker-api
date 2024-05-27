package br.com.projetos.gametracker.domain.response.league;

import br.com.projetos.gametracker.domain.response.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class LeagueResponse extends BaseResponse {

    private String id;
    private String name;

}
