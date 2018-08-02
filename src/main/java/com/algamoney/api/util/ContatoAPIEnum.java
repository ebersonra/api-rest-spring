package com.algamoney.api.util;

public enum ContatoAPIEnum {
	
	NOME("Eberson Ramos"),
	URL("https://github.com/ebersonra"),
	EMAIL("ebersonramos11@hotmail.com"),
	TELEFONE("+5541991558444");
	
	private String infoContato;
	
	private ContatoAPIEnum(String infoContato) {
		this.infoContato=infoContato;
	}

	public String getInfoContato() {
		return infoContato;
	}
	public void setInfoContato(String infoContato) {
		this.infoContato = infoContato;
	}
	
	@Override
	public String toString() {
		return this.infoContato;
	}

}
