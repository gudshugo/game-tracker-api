package br.com.projetos.gametracker.domain.common;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("league")
@Data
public class League {

    @Id
    private String id;
    private String name;
    private String country;
    private List<Club> clubs;

}
