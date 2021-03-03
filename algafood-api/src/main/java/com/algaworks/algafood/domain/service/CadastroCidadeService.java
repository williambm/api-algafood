package com.algaworks.algafood.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.CidadeRepository;

@Service
public class CadastroCidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private CadastroEstadoService cadastroEstadoService;

	public List<Cidade> listar() {
		return cidadeRepository.findAll();
	}

	public Cidade buscar (Long cidadeId) {
		Optional<Cidade> cidade = cidadeRepository.findById(cidadeId);
		
		if(cidade.isEmpty()){ 
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe cadastro de cidade com o código %d", cidadeId)); 
			}
		 return cidade.get();
	}
	
	public Cidade salvar (Cidade cidade) {
		Estado estado = cadastroEstadoService.buscar(cidade.getEstado().getId());
		if(estado ==null) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe cadastro do estado de código %d", cidade.getEstado().getId()));
		}
		return cidadeRepository.save(cidade);		
	}
	
	public void remover (Long cidadeId) {
		try {
			cidadeRepository.deleteById(cidadeId);
			
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe cadastro de cidade com o código %d", cidadeId));
		}		
	}
}
