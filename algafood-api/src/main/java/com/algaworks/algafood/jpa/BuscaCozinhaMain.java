package com.algaworks.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

public class BuscaCozinhaMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		//Pega no contexto da aplicação uma instancia do Bean CadastroCozinha
		CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepository.class);
		
		//Captura os objetos cozinha e coloca em um List
		List<Cozinha> cozinhas = cozinhaRepository.listar();
		
		for(Cozinha cozinha:cozinhas) {
			System.out.println(cozinha.getNome());
		}
		
		//Com enhancedFor java 8
		cozinhas.forEach(cozinha->System.out.println(cozinha.getNome()));
		
	}
}
