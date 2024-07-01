package br.com.alura.screanmatch;

import br.com.alura.screanmatch.model.DadosSerie;
import br.com.alura.screanmatch.service.ConsumoAPI;
import br.com.alura.screanmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreanmatchApplication implements CommandLineRunner {
	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoAPI();
		var json = consumoApi.obterDados("https://omdbapi.com/?t=gilmore+girls&apikey=84214e60");
		System.out.println(json);
		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);
	}

	public static void main(String[] args) {
		SpringApplication.run(ScreanmatchApplication.class, args);
	}

}
