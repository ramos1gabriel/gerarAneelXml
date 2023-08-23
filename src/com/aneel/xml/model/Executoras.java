package com.aneel.xml.model;

import java.util.ArrayList;
import java.util.List;

public class Executoras {
	private List<Executora> list;
    
    public Executoras(){
    	list = new ArrayList<Executora>();
    }

    public void add(Executora executora){
    	list.add(executora);
    }
}
