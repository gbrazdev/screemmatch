package com.gbrazdev.screemmatch.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SeriesModel(@JsonAlias("Title")String tile,
                          @JsonAlias("totalSeasons")Integer totalSeasons,
                          @JsonAlias("imdbRating") String rating

                          ) {
}
