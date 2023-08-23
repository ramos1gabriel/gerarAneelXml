package com.aneel.xml.model;

public class Executora {
	
//	<CNPJExec></CNPJExec>
//	<RazaoSocialExec></RazaoSocialExec>
//	<UfExec></UfExec>
	
	private String CNPJExec;
	private String RazaoSocialExec;
	private String UfExec;
	private Equipe Equipe;
	
	public String getCNPJExec() {
		return CNPJExec;
	}

	public void setCNPJExec(String cNPJExec) {
		CNPJExec = cNPJExec;
	}

	public String getRazaoSocialExec() {
		return RazaoSocialExec;
	}

	public void setRazaoSocialExec(String razaoSocialExec) {
		RazaoSocialExec = razaoSocialExec;
	}

	public String getUfExec() {
		return UfExec;
	}

	public void setUfExec(String ufExec) {
		UfExec = ufExec;
	}

	public Equipe getEquipe() {
		return Equipe;
	}
	
	public void setEquipe(Equipe equipe) {
		Equipe = equipe;
	}
}
