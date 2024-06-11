package br.com.projetos.gametracker.repository;

import br.com.projetos.gametracker.domain.common.League;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LeagueRepository extends MongoRepository<League, String> {}
