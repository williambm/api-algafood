package com.algaworks.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.CidadeRepository;

public class BuscaCidadeMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		//Pega no contexto da aplicação uma instancia do Bean CadastroCozinha
		CidadeRepository cidadeRepository = applicationContext.getBean(CidadeRepository.class);
		
		//Captura os objetos cozinha e coloca em um List
		List<Cidade> cidades = cidadeRepository.listar();
		
		for(Cidade cidade:cidades) {
			System.out.printf("\nCidade: %s - Estado: %s\n",cidade.getNome(),cidade.getEstado().getNome());
		}
		
		//Com enhancedFor java 8
		//cozinhas.forEach(cozinha->System.out.println(cozinha.getNome()));
		
	}
}
