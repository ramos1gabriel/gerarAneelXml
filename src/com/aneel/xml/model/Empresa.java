package com.aneel.xml.model;

public class Empresa {
	private String CodEmpresa;
	private String TipoEmpresa;
	private Equipe Equipe;

	public String getCodEmpresa() {
		return CodEmpresa;
	}

	public void setCodEmpresa(String codEmpresa) {
		CodEmpresa = codEmpresa;
	}

	public String getTipoEmpresa() {
		return TipoEmpresa;
	}

	public void setTipoEmpresa(String tipoEmpresa) {
		TipoEmpresa = tipoEmpresa;
	}
	
	public Equipe getEquipe() {
		return Equipe;
	}
	
	public void setEquipe(Equipe equipe) {
		Equipe = equipe;
	}
}
