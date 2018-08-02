package com.algamoney.api.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algamoney.api.model.Pessoa;
import com.algamoney.api.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Pessoa atualizar(Long codigo, Pessoa pessoa) {
		
		Pessoa pessoaPesquisada = pessoaPorCodigo(codigo);
		
		BeanUtils.copyProperties(pessoa, pessoaPesquisada, "codigo");
		return pessoaRepository.save(pessoaPesquisada);
	}
	
	public void atualizarPropriedadeAtivo(Long codigo, boolean ativo) {
		
		Pessoa pessoaPesquisada = pessoaPorCodigo(codigo);
		pessoaPesquisada.setAtivo(ativo);
		pessoaRepository.save(pessoaPesquisada);
	}
	
	private Pessoa pessoaPorCodigo(Long codigo) {
		
		Optional<Pessoa> pessoaPesquisada = pessoaRepository.findById(codigo);
		if(!pessoaPesquisada.isPresent()) {
			
			throw new EmptyResultDataAccessException(1);
		}
		return pessoaPesquisada.get();
	}
}
