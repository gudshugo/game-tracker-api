package br.com.projetos.gametracker.domain.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pagination {

    private int page;
    private int size;
    private int totalPages;
    private long totalElements;

}
