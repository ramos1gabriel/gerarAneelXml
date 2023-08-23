package com.aneel.xml.model;

import java.util.ArrayList;
import java.util.List;

public class EtapasList {
    private List<Etapa> list;
    
    public EtapasList(){
    	list = new ArrayList<Etapa>();
    }

    public void add(Etapa etapa){
    	list.add(etapa);
    }
}
