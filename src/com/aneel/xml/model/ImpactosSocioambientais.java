package com.aneel.xml.model;

public class ImpactosSocioambientais {
//	<PD_ResultadosSA>
//	<IdSA>
//	<TipoISA></TipoISA>
//	<PossibISA></PossibISA>
//	<TxtISA></TxtISA>
//	</IdSA>
//	</PD_ResultadosSA>

	private String TipoISA;
	private String PossibISA;
	private String TxtISA;
	
	public String getTipoISA() {
		return TipoISA;
	}
	public void setTipoISA(String tipoISA) {
		TipoISA = tipoISA;
	}
	public String getPossibISA() {
		return PossibISA;
	}
	public void setPossibISA(String possibISA) {
		PossibISA = possibISA;
	}
	public String getTxtISA() {
		return TxtISA;
	}
	public void setTxtISA(String txtISA) {
		TxtISA = txtISA;
	}
}
