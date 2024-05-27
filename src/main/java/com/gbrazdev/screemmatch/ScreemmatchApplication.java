package com.gbrazdev.screemmatch;

import com.gbrazdev.screemmatch.models.EpisodeModel;
import com.gbrazdev.screemmatch.models.SeriesModel;
import com.gbrazdev.screemmatch.services.ConsumeDate;
import com.gbrazdev.screemmatch.services.ConvertDate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreemmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreemmatchApplication.class, args);
	}

	public void run (String...args){
		var consumeDate = new ConsumeDate();
		var json = consumeDate.obterDados("http://www.omdbapi.com/?i=tt0773262&apikey=209b8ce7");
		System.out.println(json);
		ConvertDate conversor = new ConvertDate();
		SeriesModel dados = conversor.obterDados(json, SeriesModel.class);
		System.out.println(dados);

		var jsonEp = consumeDate.obterDados("http://www.omdbapi.com/?i=tt0773262&season=1&episode=2&apikey=209b8ce7");
		EpisodeModel epDates = conversor.obterDados(jsonEp, EpisodeModel.class);
		System.out.println(epDates);



	}

}
