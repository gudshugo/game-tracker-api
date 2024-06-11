package br.com.projetos.gametracker.domain.response;

import br.com.projetos.gametracker.domain.validation.ErrorDetail;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HttpMetaDataInfo {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int httpStatusCode;

    private String status = "";

    private String message = "";

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ErrorDetail> errorDetails = new ArrayList<>();

}
