package br.com.alura.Screenmatch.dto;

import br.com.alura.Screenmatch.model.Categoria;

public record SerieDTO(long id,
                       String titulo,
                       Integer totalTemporadas,
                       Double avaliacao,
                       Categoria genero,
                       String atores,
                       String poster,
                       String sinopse) {
}
