package com.aneel.xml.model;

import java.util.ArrayList;
import java.util.List;

public class DestRecursosEmp {
	private List<CustoCatContabil> list;
    
    public DestRecursosEmp(){
    	list = new ArrayList<CustoCatContabil>();
    }

    public void add(CustoCatContabil empresa){
    	list.add(empresa);
    }
}
