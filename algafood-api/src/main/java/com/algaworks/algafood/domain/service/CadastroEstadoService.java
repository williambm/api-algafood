package com.algaworks.algafood.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;

@Service
public class CadastroEstadoService {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	public List<Estado>listar(){
		return estadoRepository.findAll();
	}
	
	public Estado buscar (Long estadoId) {
		Optional<Estado> estado = estadoRepository.findById(estadoId);
		if(estado.isPresent()) {
			return estado.get();
		}
		throw new EntidadeNaoEncontradaException(String.format("Não existe o estado com o cadastro %d", estadoId));
	}
	
	public Estado salvar (Estado estado) {
		return estadoRepository.save(estado);
	}
	
	public void remover (Long estadoId) {
		try {			
			estadoRepository.deleteById(estadoId);
		} catch (DataIntegrityViolationException e) {	
			throw new EntidadeEmUsoException(
					String.format("O Estado de Código %d está sendo utilizado", estadoId));
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("O Estado de Código %d não existe", estadoId));
		}
	}

}
