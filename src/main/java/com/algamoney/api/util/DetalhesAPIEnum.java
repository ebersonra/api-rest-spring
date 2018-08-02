package com.algamoney.api.util;

public enum DetalhesAPIEnum {

	TITULO("API-Alagamoney"),
	DESCRICAO("API desenvolvida no curso de Spring Boot."),
	VERSAO("1.0"),
	TERMOS_DE_SERVICO("Termo de uso: Deve ser usada para estudos do curso Spring Boot"),
	LICENCA("Licença Livre - Open Source"),
	LICENCA_URL("http://www.algaworks.com");
	
	private String detalhe;
	
	private DetalhesAPIEnum(String detalhe) {
		this.detalhe = detalhe;
	}

	public String getDetalhe() {
		return detalhe;
	}
	public void setDetalhe(String detalhe) {
		this.detalhe = detalhe;
	}
	
	@Override
	public String toString() {
		return this.detalhe;
	}
	
}
