package com.gbrazdev.screemmatch.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SeasonModel(@JsonAlias("Title") String titulo,
                          @JsonAlias("Season") Integer numero,
                          @JsonAlias("imdbRating") String avaliacao,
                          @JsonAlias("Released") String dataLancamento) {
}
