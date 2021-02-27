package com.algaworks.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

public class BuscaRestauranteMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		//Pega no contexto da aplicação uma instancia do Bean CadastroCozinha
		RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);
		
		//Captura os objetos cozinha e coloca em um List
		List<Restaurante> restaurantes = restauranteRepository.listar();
		
		for(Restaurante restaurante:restaurantes) {
			System.out.println(restaurante.getNome());
		}
		
		//Com enhancedFor java 8
		System.out.println("com forEach Java8");
		restaurantes.forEach(restaurante->System.out.printf("\n %s - %f - %s\n",
				restaurante.getNome(),restaurante.getTaxaFrete(),restaurante.getCozinha().getNome()));
		
	}
}
