package com.algamoney.api.repository.pessoa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.algamoney.api.model.Pessoa;
import com.algamoney.api.repository.filter.PessoaFilter;
import com.algamoney.api.repository.projection.ResumoPessoa;

public interface PessoaRepositoryQuery {

	public Page<Pessoa> filtrar(PessoaFilter pessoaFilter, Pageable pageable);
	public Page<ResumoPessoa> resumir(PessoaFilter pessoaFilter, Pageable pageable);
}
