package com.aneel.xml.model;

import java.util.ArrayList;
import java.util.List;

public class PD_EquipeExec {
	private List<Executoras> list;
    
    public PD_EquipeExec(){
    	list = new ArrayList<Executoras>();
    }

    public void add(Executoras executoras){
    	list.add(executoras);
    }
}
