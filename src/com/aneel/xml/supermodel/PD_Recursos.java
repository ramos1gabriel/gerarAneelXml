package com.aneel.xml.supermodel;

import java.util.ArrayList;
import java.util.List;

public class PD_Recursos {
	private List<RecursoEmpresa> list;
    
    public PD_Recursos(){
    	list = new ArrayList<RecursoEmpresa>();
    }

    public void add(RecursoEmpresa empresas){
    	list.add(empresas);
    }
}
