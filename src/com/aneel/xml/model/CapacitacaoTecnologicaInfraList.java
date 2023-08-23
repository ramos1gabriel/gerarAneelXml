package com.aneel.xml.model;

import java.util.ArrayList;
import java.util.List;

public class CapacitacaoTecnologicaInfraList {
	private List<CapacitacaoTecnologicaInfra> list;
    
    public CapacitacaoTecnologicaInfraList(){
    	list = new ArrayList<CapacitacaoTecnologicaInfra>();
    }

    public void add(CapacitacaoTecnologicaInfra etapa){
    	list.add(etapa);
    }
}
