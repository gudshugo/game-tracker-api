package br.com.projetos.gametracker.domain.common;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;


@Data
@Document("club")
public class Club {

    @Id
    private String id;
    private String name;
    private Long leagueId;
    private LocalDate foundationDate;
    private String city;
    private String stadiumName;
    private String stadiumCapacity;

}
