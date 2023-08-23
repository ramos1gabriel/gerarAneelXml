package com.aneel.xml.model;

import java.util.ArrayList;
import java.util.List;

public class Empresas {
	private List<Empresa> list;
    
    public Empresas(){
    	list = new ArrayList<Empresa>();
    }

    public void add(Empresa empresa){
    	list.add(empresa);
    }
}
