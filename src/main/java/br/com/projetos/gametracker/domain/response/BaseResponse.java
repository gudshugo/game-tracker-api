package br.com.projetos.gametracker.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BaseResponse {

    @JsonProperty("httpMetaDataInfo")
    private HttpMetaDataInfo httpMetaDataInfo = new HttpMetaDataInfo();

}
