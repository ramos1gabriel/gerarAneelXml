package com.aneel.xml.model;

import java.util.ArrayList;
import java.util.List;

public class CapacitacaoTecnologicaTecnicaList {
	private List<CapacitacaoTecnologicaTecnica> list;
    
    public CapacitacaoTecnologicaTecnicaList(){
    	list = new ArrayList<CapacitacaoTecnologicaTecnica>();
    }

    public void add(CapacitacaoTecnologicaTecnica etapa){
    	list.add(etapa);
    }
}
