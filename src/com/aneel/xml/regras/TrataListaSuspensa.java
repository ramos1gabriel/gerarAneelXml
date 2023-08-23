package com.aneel.xml.regras;

public class TrataListaSuspensa {
	
	public static String listaSimNao(String str) {
		switch (str.trim()) {
			case "N - Não":
				return "N";
			case "S - Sim":
				return "S";
			default:
				return "";
		}
	}
	
	public static String listaTipoProfissional(String str) {
		switch (str.trim()) {
			case "PD - Pós-Doutorado (Stricto Sensu)":
				return "PD";
			case "DO - Doutorado (Strictu Sensu)":
				return "DO";
			case "ME - Mestrado (Strictu Sensu)":
				return "ME";
			case "ES - Especialzação (Lato Sensu)":
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
			case "TE - Técnico":
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
			case "AT - Auxiliar Técnico":
				return "AT";
			case "AB - Auxiliar Técnico Bolsista":
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
			case "AP - Amapá":
				return "AP";
			case "BA - Bahia":
				return "BA";
			case "CE - Ceará":
				return "CE";
			case "DF - Distrito Federal":
				return "DF";
			case "ES - Espírito Santo":
				return "ES";
			case "GO - Goiás":
				return "GO";
			case "MA - Maranhão":
				return "MA";
			case "MT - Mato Grosso":
				return "MT";
			case "MS - Mato Grosso do Sul":
				return "MS";
			case "MG - Minas Gerais":
				return "MG";
			case "PA - Pará":
				return "PA";
			case "PB - Paraíba":
				return "PB";
			case "PR - Paraná":
				return "PR";
			case "PE - Pernambuco":
				return "PE";
			case "PI - Piauí":
				return "PI";
			case "RJ - Rio de Janeiro":
				return "RJ";
			case "RN - Rio Grande do Norte":
				return "RN";
			case "RS - Rio Grande do Sul":
				return "RS";
			case "RO - Rondônia":
				return "RO";
			case "RR - Roraima":
				return "RR";
			case "SC - Santa Catarina":
				return "SC";
			case "SP - São Paulo":
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
			case "PN - Periódico Nacional":
				return "PN";
			case "PI - Periódico Internacional":
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
			case "LNS - Laboratório Novo em Instituição de Ensino Superior":
				return "LNS";
			case "LES - Laboratório Existente em Instituição de Ensino Superior":
				return "LES";
			case "LNP - Laboratório Novo em Instituição de Pesquisa":
				return "LNP";
			case "LEP - Laboratório Existente em Instituição de pesquisa":
				return "LEP";
			case "LNE - Laboratório Novo em Empresa de Energia Elétrica":
				return "LNE";
			case "LEE - Laboratório Existente em Empresa de Energia Elétrica":
				return "LEE";
			default:
				return "";
		}
	}
	
	public static String listaIncidadorSocioambiental(String str) {
		switch (str.trim()) {
			case "ISA1 – Possibilidade de impactos ambientais (água, ar ou solo)":
				return "ISA1";
			case "ISA2 – Possibilidade de diversificação da matriz energética":
				return "ISA2";
			case "ISA3 – Possibilidade de desenvolvimento de nova atividade socioeconômica (lazer, turismo, pesca, agricultura, etc)":
				return "ISA3";
			case "ISA4 – Possibilidade de impactos na segurança ou na qualidade de vida da comunidade":
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
			case "PR1 - Redução de homem-hora":
				return "PR1";
			case "PR2 - Redução de insumos":
				return "PR2";
			case "PR3 - Redução de tempo":
				return "PR3";
			case "PRX - Outro":
				return "PRX";
				//
			case "QF1 - Redução de DEC, FEC e TMA":
				return "QF1";
			case "QF2 - Redução de VTCDs e outros distúrbios":
				return "QF2";
			case "QF3 - Redução do índice de reclamações":
				return "QF3";
			case "QFX - Outro":
				return "QFX";
				//
			case "GA1 - Postergação de investimento":
				return "GA1";
			case "GA2 - Investimento evitado":
				return "GA2";
			case "GA3 - Redução de roubos e furtos":
				return "GA3";
			case "GAX - Outro":
				return "GAX";
				//
			case "NT1 - Redução de Inadimplência":
				return "NT1";
			case "NT2 - Redução de fraudes e desvios":
				return "NT2";
			case "NT3 - Redução de erros de medição":
				return "NT3";
			case "NT4 - Redução de perdas indenizatórias":
				return "NT4";
			case "NTX - Outro":
				return "NTX";
				//
			case "ME1 - Redução do custo de energia":
				return "ME1";
			case "ME2 - Redução nos erros de previsão":
				return "ME2";
			case "MEX - Outro":
				return "MEX";
				//
			case "EE1  - Aumento da demanda disponível (oferta)":
				return "EE1";
			case "EE2 - Aumento da energia disponível (oferta)":
				return "EE2";
			case "EE3 - Redução de demanda (uso final)":
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
			case "ST - Serviços de Terceiros":
				return "ST";
			case "MC - Material de Consumo":
				return "MC";
			case "MP - Materiais Permanentes e Equipamentos":
				return "MP";
			case "VD - Viagens e Diárias":
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