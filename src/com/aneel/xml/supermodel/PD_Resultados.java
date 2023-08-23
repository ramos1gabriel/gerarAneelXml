package com.aneel.xml.supermodel;

import java.util.ArrayList;
import java.util.List;

import com.aneel.xml.model.CapacitacaoProfissionalList;
import com.aneel.xml.model.ImpactosEconomicosList;
import com.aneel.xml.model.ImpactosSocioambientaisList;

public class PD_Resultados {
	private CapacitacaoProfissionalList PD_ResultadosCP;
	private List<PD_ResultadosCT> list;
	private ImpactosSocioambientaisList PD_ResultadosSA;
	private ImpactosEconomicosList PD_ResultadosIE;
	
	public CapacitacaoProfissionalList getPD_ResultadosCP() {
		return PD_ResultadosCP;
	}
	
	public void setPD_ResultadosCP(CapacitacaoProfissionalList pD_ResultadosCP) {
		PD_ResultadosCP = pD_ResultadosCP;
	}
	
	public PD_Resultados(){
    	list = new ArrayList<PD_ResultadosCT>();
    }

    public void add(PD_ResultadosCT etapa){
    	list.add(etapa);
    }
	
	public ImpactosSocioambientaisList getPD_ResultadosSA() {
		return PD_ResultadosSA;
	}
	
	public void setPD_ResultadosSA(ImpactosSocioambientaisList pD_ResultadosSA) {
		PD_ResultadosSA = pD_ResultadosSA;
	}
	
	public ImpactosEconomicosList getPD_ResultadosIE() {
		return PD_ResultadosIE;
	}
	
	public void setPD_ResultadosIE(ImpactosEconomicosList pD_ResultadosIE) {
		PD_ResultadosIE = pD_ResultadosIE;
	}
}

/*
<PD_Resultados>
	(PARTE7)
	<PD_ResultadosCT>
		(PARTE8)
		(PARTE9)
	</PD_ResultadosCT>
	(PARTE11)
	(PARTE12)
</PD_Resultados>
*/

//PARTE7_CapacitacaoProfissional.xml
//PARTE8_CapacitacaoTecnologicaTecnica.xml
//PARTE9_CapacitacaoTecnologicaInfra.xml
//PARTE11_ImpactosSocioambientais.xml
//PARTE12_ImpactosEconomicos.xml