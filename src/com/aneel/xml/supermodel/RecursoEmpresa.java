package com.aneel.xml.supermodel;

import java.util.ArrayList;
import java.util.List;

public class RecursoEmpresa {
	
	private String CodEmpresa;
	private List<DestRecursos> list;
	
	public String getCodEmpresa() {
		return CodEmpresa;
	}
	
	public void setCodEmpresa(String codEmpresa) {
		CodEmpresa = codEmpresa;
	}
	
    public RecursoEmpresa(){
    	list = new ArrayList<DestRecursos>();
    }

    public void add(DestRecursos empresa){
    	list.add(empresa);
    }
}
