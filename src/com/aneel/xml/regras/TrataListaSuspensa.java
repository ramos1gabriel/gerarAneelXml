package com.aneel.xml.regras;

public class TrataListaSuspensa {
	
	public static String listaSimNao(String str) {
		switch (str.trim()) {
			case "N - N�o":
				return "N";
			case "S - Sim":
				return "S";
			default:
				return "";
		}
	}
	
	public static String listaTipoProfissional(String str) {
		switch (str.trim()) {
			case "PD - P�s-Doutorado (Stricto Sensu)":
				return "PD";
			case "DO - Doutorado (Strictu Sensu)":
				return "DO";
			case "ME - Mestrado (Strictu Sensu)":
				return "ME";
			case "ES - Especialza��o (Lato Sensu)":
				return "ES";
			default:
				return "";
		}
	}

	public static String listaTipoEmpresa(String str) {
		switch (str.trim()) {
			case "P - Proponente":
				return "P";
			case "C - Cooperada":
				return "C";
			default:
				return "";
		}
	}
	
	public static String listaTitulacao(String str) {
		switch (str.trim()) {
			case "DO - Doutor":
				return "DO";
			case "ME - Mestre":
				return "ME";
			case "ES - Especialista":
				return "ES";
			case "SU - Superior":
				return "SU";
			case "TE - T�cnico":
				return "TE";
			default:
				return "";
		}
	}
	
	public static String listaFuncao(String str) {
		switch (str.trim()) {
			case "CO - Coordenador":
				return "CO";
			case "PE - Pesquisador":
				return "PE";
			case "AT - Auxiliar T�cnico":
				return "AT";
			case "AB - Auxiliar T�cnico Bolsista":
				return "AB";
			case "AA - Auxiliar Administrativo":
				return "AA";
			default:
				return "";
		}
	}
	
	public static String listaUF(String str) {
		switch (str.trim()) {
			case "AC - Acre":
				return "AC";
			case "AL - Alagoas":
				return "AL";
			case "AM - Amazonas":
				return "AM";
			case "AP - Amap�":
				return "AP";
			case "BA - Bahia":
				return "BA";
			case "CE - Cear�":
				return "CE";
			case "DF - Distrito Federal":
				return "DF";
			case "ES - Esp�rito Santo":
				return "ES";
			case "GO - Goi�s":
				return "GO";
			case "MA - Maranh�o":
				return "MA";
			case "MT - Mato Grosso":
				return "MT";
			case "MS - Mato Grosso do Sul":
				return "MS";
			case "MG - Minas Gerais":
				return "MG";
			case "PA - Par�":
				return "PA";
			case "PB - Para�ba":
				return "PB";
			case "PR - Paran�":
				return "PR";
			case "PE - Pernambuco":
				return "PE";
			case "PI - Piau�":
				return "PI";
			case "RJ - Rio de Janeiro":
				return "RJ";
			case "RN - Rio Grande do Norte":
				return "RN";
			case "RS - Rio Grande do Sul":
				return "RS";
			case "RO - Rond�nia":
				return "RO";
			case "RR - Roraima":
				return "RR";
			case "SC - Santa Catarina":
				return "SC";
			case "SP - S�o Paulo":
				return "SP";
			case "SE - Sergipe":
				return "SE";
			case "TO - Tocantins":
				return "TO";
			default:
				return "";
		}
	}
	
	public static String listaTecnicoCientifica(String str) {
		switch (str.trim()) {
			case "PN - Peri�dico Nacional":
				return "PN";
			case "PI - Peri�dico Internacional":
				return "PI";
			case "AN - Anais de evento Nacional":
				return "AN";
			case "AI - Anais de evento internacional":
				return "AI";
			default:
				return "";
		}
	}
	
	public static String listaInfraEstrutura(String str) {
		switch (str.trim()) {
			case "LNS - Laborat�rio Novo em Institui��o de Ensino Superior":
				return "LNS";
			case "LES - Laborat�rio Existente em Institui��o de Ensino Superior":
				return "LES";
			case "LNP - Laborat�rio Novo em Institui��o de Pesquisa":
				return "LNP";
			case "LEP - Laborat�rio Existente em Institui��o de pesquisa":
				return "LEP";
			case "LNE - Laborat�rio Novo em Empresa de Energia El�trica":
				return "LNE";
			case "LEE - Laborat�rio Existente em Empresa de Energia El�trica":
				return "LEE";
			default:
				return "";
		}
	}
	
	public static String listaIncidadorSocioambiental(String str) {
		switch (str.trim()) {
			case "ISA1 � Possibilidade de impactos ambientais (�gua, ar ou solo)":
				return "ISA1";
			case "ISA2 � Possibilidade de diversifica��o da matriz energ�tica":
				return "ISA2";
			case "ISA3 � Possibilidade de desenvolvimento de nova atividade socioecon�mica (lazer, turismo, pesca, agricultura, etc)":
				return "ISA3";
			case "ISA4 � Possibilidade de impactos na seguran�a ou na qualidade de vida da comunidade":
				return "ISA4";
			default:
				return "";
		}
	}
	
	//
	//
	//
	//

	//cornojob
	public static String listaIndicadorEconomicoFULL(String str) {
		switch (str.trim()) {
			case "PR1 - Redu��o de homem-hora":
				return "PR1";
			case "PR2 - Redu��o de insumos":
				return "PR2";
			case "PR3 - Redu��o de tempo":
				return "PR3";
			case "PRX - Outro":
				return "PRX";
				//
			case "QF1 - Redu��o de DEC, FEC e TMA":
				return "QF1";
			case "QF2 - Redu��o de VTCDs e outros dist�rbios":
				return "QF2";
			case "QF3 - Redu��o do �ndice de reclama��es":
				return "QF3";
			case "QFX - Outro":
				return "QFX";
				//
			case "GA1 - Posterga��o de investimento":
				return "GA1";
			case "GA2 - Investimento evitado":
				return "GA2";
			case "GA3 - Redu��o de roubos e furtos":
				return "GA3";
			case "GAX - Outro":
				return "GAX";
				//
			case "NT1 - Redu��o de Inadimpl�ncia":
				return "NT1";
			case "NT2 - Redu��o de fraudes e desvios":
				return "NT2";
			case "NT3 - Redu��o de erros de medi��o":
				return "NT3";
			case "NT4 - Redu��o de perdas indenizat�rias":
				return "NT4";
			case "NTX - Outro":
				return "NTX";
				//
			case "ME1 - Redu��o do custo de energia":
				return "ME1";
			case "ME2 - Redu��o nos erros de previs�o":
				return "ME2";
			case "MEX - Outro":
				return "MEX";
				//
			case "EE1  - Aumento da demanda dispon�vel (oferta)":
				return "EE1";
			case "EE2 - Aumento da energia dispon�vel (oferta)":
				return "EE2";
			case "EE3 - Redu��o de demanda (uso final)":
				return "EE3";
			case "EE4 - Energia economizada (uso final)":
				return "EE4";
			case "EEX - Outro":
				return "EEX";
			default:
				return "";
		}
	}
	
	public static String listaCategoriaContabil(String str) {
		
		switch (str.trim()) {
			case "ST - Servi�os de Terceiros":
				return "ST";
			case "MC - Material de Consumo":
				return "MC";
			case "MP - Materiais Permanentes e Equipamentos":
				return "MP";
			case "VD - Viagens e Di�rias":
				return "VD";
			case "OU - Outros":
				return "OU";
			default:
				return "";
		}
	}
	
	public static String listaTipoItem(String str) {
		
		switch (str.trim()) {
			case "N - Nacional":
				return "N";
			case "I - Internacional":
				return "I";
			default:
				return "";
		}
	}
}