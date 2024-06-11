package br.com.projetos.gametracker.domain.request.league;

import br.com.projetos.gametracker.domain.validation.ValidationMessage;
import br.com.projetos.gametracker.domain.validation.annotation.ValidCountry;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class LeagueRequest {

    @NotNull(message = ValidationMessage.NOT_NULL)
    @NotBlank(message = ValidationMessage.NOT_BLANK)
    private String name;

    @NotNull(message = ValidationMessage.NOT_NULL)
    @NotBlank(message = ValidationMessage.NOT_BLANK)
    @ValidCountry
    private String country;

}

