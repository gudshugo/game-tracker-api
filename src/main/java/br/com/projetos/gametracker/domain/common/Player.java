package br.com.projetos.gametracker.domain.common;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("player")
@Data
public class Player {

    @Id
    private String id;
    private String name;
    private String age;
    private String height;
    private String country;
    private String position;
    private String clubId;

}
