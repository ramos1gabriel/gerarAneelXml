package com.aneel.xml.model;

import java.util.ArrayList;
import java.util.List;

public class CapacitacaoProfissionalList {
	private List<CapacitacaoProfissional> list;
    
    public CapacitacaoProfissionalList(){
    	list = new ArrayList<CapacitacaoProfissional>();
    }

    public void add(CapacitacaoProfissional etapa){
    	list.add(etapa);
    }
}
