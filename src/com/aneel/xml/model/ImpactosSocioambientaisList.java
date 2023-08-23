package com.aneel.xml.model;

import java.util.ArrayList;
import java.util.List;

public class ImpactosSocioambientaisList {
	private List<ImpactosSocioambientais> list;
    
    public ImpactosSocioambientaisList(){
    	list = new ArrayList<ImpactosSocioambientais>();
    }

    public void add(ImpactosSocioambientais etapa){
    	list.add(etapa);
    }
}
