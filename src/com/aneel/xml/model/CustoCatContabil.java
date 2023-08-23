package com.aneel.xml.model;

import java.util.ArrayList;
import java.util.List;

public class CustoCatContabil {
	private String CategoriaContabil;
	private List<ItemDespesa> list;

	public String getCategoriaContabil() {
		return CategoriaContabil;
	}
	
	public void setCategoriaContabil(String categoriaContabil) {
		CategoriaContabil = categoriaContabil;
	}
	
    public CustoCatContabil(){
    	list = new ArrayList<ItemDespesa>();
    }

    public void add(ItemDespesa etapa){
    	list.add(etapa);
    }
}