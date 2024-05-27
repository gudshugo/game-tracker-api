package br.com.projetos.gametracker.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String age;
    private String height;
    private String country;
    private String position;

    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;

}
