package com.aneel.xml.model;

import java.util.ArrayList;
import java.util.List;

public class DestRecursosExec {
	private String CNPJExec;
	private List<CustoCatContabil> list;
	
	public String getCNPJExec() {
		return CNPJExec;
	}
	
	public void setCNPJExec(String cNPJExec) {
		CNPJExec = cNPJExec;
	}
    
    public DestRecursosExec(){
    	list = new ArrayList<CustoCatContabil>();
    }

    public void add(CustoCatContabil empresa){
    	list.add(empresa);
    }
}
