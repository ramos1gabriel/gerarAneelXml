package com.aneel.xml.model;

import java.util.ArrayList;
import java.util.List;

public class ImpactosEconomicosList {
	private List<ImpactosEconomicos> list;
    
    public ImpactosEconomicosList(){
    	list = new ArrayList<ImpactosEconomicos>();
    }

    public void add(ImpactosEconomicos etapa){
    	list.add(etapa);
    }
}
