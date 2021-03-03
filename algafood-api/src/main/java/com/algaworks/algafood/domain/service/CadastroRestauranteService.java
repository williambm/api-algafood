package com.algaworks.algafood.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {

	@Autowired
	private RestauranteRepository restauranteRepository;

	@Autowired
	private CozinhaRepository cozinhaRepository;

	public List<Restaurante> listar() {
		return restauranteRepository.findAll();
	}

	public Restaurante buscar(Long restauranteId) {
		Optional<Restaurante> restaurante = restauranteRepository.findById(restauranteId);
		if(restaurante.isPresent()) {
			return restaurante.get();
		}
		throw new EntidadeNaoEncontradaException(String.format("Não há restaurante cadastrado com o ID %d", restauranteId));
	}

	public Restaurante salvar(Restaurante restaurante) {
		Long cozinhaId = restaurante.getCozinha().getId();
		Cozinha cozinha = cozinhaRepository.findById(cozinhaId).orElseThrow(()-> new EntidadeNaoEncontradaException(
				String.format("Não existe cadastro de cozinha com o código %d", cozinhaId)));

		restaurante.setCozinha(cozinha);
		return restauranteRepository.save(restaurante);
	}	
	
	public void remover (Long restauranteId) {		
		try {
			restauranteRepository.deleteById(restauranteId);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(String.
					  format("Não existe restaurante com o cadastro %d", restauranteId));
		}
				
		  
		 
	}

}
