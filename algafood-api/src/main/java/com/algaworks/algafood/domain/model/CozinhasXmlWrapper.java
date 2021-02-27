package com.algaworks.algafood.domain.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import lombok.Data;
import lombok.NonNull;

/**
 * Classe para fazer o embrulho de uma List de Cozinha e devolver ao
 * CozinhaController, formata para XML
 * 
 * @author william
 *
 */
@JsonRootName("cozinhas")
@Data
public class CozinhasXmlWrapper {

	// Anotação do lombock para dizer que o atributo não pode ser nulo, obrigado a
	// passar no construtor!!!
	@NonNull
	@JacksonXmlElementWrapper(useWrapping = false)
	@JsonProperty("cozinha")
	private List<Cozinha> cozinhas;

}
