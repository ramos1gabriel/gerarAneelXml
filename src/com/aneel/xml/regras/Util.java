package com.aneel.xml.regras;

import javax.swing.JOptionPane;

public class Util {
	
	private static String regex = "^0+(?!$)";
	
	public static String trataDoubleSimplesDouble(Double db) {
		if(db != null) {
			String str = String.valueOf(db);
			return str.replace(".0", "");
			//return str.replaceFirst(regex, "");
		}
		return "";
	}
	
	public static String trataDoubleCNPJ(Double cnpj) {
		if(cnpj != null) {
			String str = String.valueOf(cnpj);
			return str.replace(".", "").substring(0, 14); //14 digitos
		}
		return "";
	}
	
	public static String trataDoubleData(Double data) {
		if(data != null) {
			String str = String.valueOf(data);
			return str.replace(".", "").substring(0, 8); //8 digitos
		}
		return "";
	}
	
	public static String trataDoubleCPF(Double cpf) {
		if(cpf != null) {
			String str = String.valueOf(cpf);
			return str.replace(".", "").substring(0, 11); //8 digitos
		}
		return "";
	}
	
	public static void trataErroAbaLog(String aba, Exception e) {
		String error = "ERRO na aba "+aba+": "+e.getMessage();
		System.out.println(error);
		JOptionPane.showMessageDialog(null, error);
		e.printStackTrace();
	}
	
	//MOCK
	public static String qtdLinhas(String aba) {
		//return "2";
		return JOptionPane.showInputDialog("Informe a quantidade de linhas para "+aba+":");
	}
	
	public static void msgSucesso(String aba) {
		String sucess = aba+" - OK";
		System.out.println(sucess);
		JOptionPane.showMessageDialog(null, sucess);
	}
}
