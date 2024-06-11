package br.com.projetos.gametracker.domain.response.league;

import br.com.projetos.gametracker.domain.response.BaseResponse;
import br.com.projetos.gametracker.domain.response.Pagination;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class LeagueResponse extends BaseResponse {

   private List<LeagueResultSet> leagueResultSet = new ArrayList<>();

   @JsonInclude(JsonInclude.Include.NON_NULL)
   private Pagination pagination;

}
