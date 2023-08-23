package com.aneel.xml.model;

import java.util.ArrayList;
import java.util.List;

public class Equipe {
	private List<EquipeModelo> list;
    
    public Equipe(){
    	list = new ArrayList<EquipeModelo>();
    }

    public void add(EquipeModelo equipeempresa){
    	list.add(equipeempresa);
    }
}
