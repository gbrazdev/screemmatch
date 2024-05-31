package com.gbrazdev.screemmatch.main;

import com.gbrazdev.screemmatch.models.Episode;
import com.gbrazdev.screemmatch.models.EpisodeModel;
import com.gbrazdev.screemmatch.models.SeasonModel;
import com.gbrazdev.screemmatch.models.SeriesModel;
import com.gbrazdev.screemmatch.services.ConsumeDate;
import com.gbrazdev.screemmatch.services.ConvertDate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private Scanner read = new Scanner(System.in);
    private ConsumeDate consume = new ConsumeDate();
    private ConvertDate conversor = new ConvertDate();

    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=209b8ce7";

    public void showMenu() {
        System.out.println("Digite o nome da série para a busca");
        var nomeSerie = read.nextLine().replace(" ", "+");
        var json = consume.obterDados(ENDERECO + nomeSerie + API_KEY);
        System.out.println(ENDERECO + nomeSerie + API_KEY);
        SeriesModel dados = conversor.obterDados(json, SeriesModel.class);
        System.out.println(dados);
        //"https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c"

        List<SeasonModel> seasons = new ArrayList<>();
        for (int i = 1; i <= dados.totalSeasons(); i++) {
            json = consume.obterDados("https://www.omdbapi.com/?i=tt0773262&season=" + i + "&apikey=209b8ce7");
            SeasonModel seasonDates = conversor.obterDados(json, SeasonModel.class);
            seasons.add(seasonDates);

        }
        seasons.forEach(s -> s.episodes().forEach(e -> System.out.println(e.title())));

        List<EpisodeModel> dadosEpisodes = seasons.stream()
                .flatMap(t -> t.episodes().stream())
                .toList();

        System.out.println("\n Top 5 episódios");
        dadosEpisodes.stream()
                .filter(e -> !e.rating().equalsIgnoreCase("N/A"))
                .sorted(Comparator.comparing(EpisodeModel::rating).reversed())
                .limit(5)
                .forEach(System.out::println);

        List<Episode> episodios = seasons.stream()
                .flatMap(s -> s.episodes().stream()
                        .map(d -> new Episode(s.number(), d))
                ).toList();

        episodios.forEach(System.out::println);


    }
}
