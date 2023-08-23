package com.aneel.xml.metodos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

import com.aneel.xml.model.AspectoBaseProjeto;
import com.thoughtworks.xstream.XStream;

public class XMLUtil {
	
	public static void geraXML(String caminho, String alias, Object objeto) {
		
		try {
			
			File arquivo = new File(caminho);
	        
	        XStream xStream = new XStream();
	        xStream.alias(alias, AspectoBaseProjeto.class);
	        
	        OutputStream outputStream = new FileOutputStream(arquivo);
	        Writer writer = new OutputStreamWriter(outputStream, Charset.forName("UTF-8"));
	        //xStream.toXML(asp, outputStream);
	        
	        writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
	        xStream.toXML(objeto, writer);
	        
		} catch (IOException e) {
			System.out.println("Erro ao gerar XML: "+alias+" "+e.getMessage());
		}
	}
}

//CORRECOES
//VALIDAR LINHAS NULAS/VALORES NULOS???
//TRATAR TIPOS "TIPO - DESCRICAO" PARA "TIPO", "N - NAO" PARA "N" (switchcase)