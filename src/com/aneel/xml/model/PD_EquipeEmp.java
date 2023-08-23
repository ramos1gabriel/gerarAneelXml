package com.aneel.xml.model;

import java.util.ArrayList;
import java.util.List;

public class PD_EquipeEmp {
	private List<Empresas> list;
    
    public PD_EquipeEmp(){
    	list = new ArrayList<Empresas>();
    }

    public void add(Empresas empresas){
    	list.add(empresas);
    }
}
