package com.algaworks.algafood.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;

@Service
public class CadastroEstadoService {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	public List<Estado>listar(){
		return estadoRepository.listar();
	}
	
	public Estado buscar (Long estadoId) {
		return estadoRepository.buscar(estadoId);
	}
	
	public Estado salvar (Estado estado) {
		return estadoRepository.salvar(estado);
	}
	
	public void remover (Long estadoId) {
		try {			
			estadoRepository.remover(estadoId);
		} catch (DataIntegrityViolationException e) {	
			throw new EntidadeEmUsoException(
					String.format("O Estado de Código %d está sendo utilizado", estadoId));
		}
	}

}
