package br.com.projetos.gametracker.domain.validation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetail {

    private String field = "";
    private String message = "";

}
