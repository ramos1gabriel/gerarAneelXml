package com.aneel.xml.metodos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.aneel.xml.constantes.Constantes;
import com.aneel.xml.model.AspectoBaseProjeto;
import com.aneel.xml.model.CapacitacaoProfissional;
import com.aneel.xml.model.CapacitacaoProfissionalList;
import com.aneel.xml.model.CapacitacaoTecnologicaInfra;
import com.aneel.xml.model.CapacitacaoTecnologicaInfraList;
import com.aneel.xml.model.CapacitacaoTecnologicaTecnica;
import com.aneel.xml.model.CapacitacaoTecnologicaTecnicaList;
import com.aneel.xml.model.CustoCatContabil;
import com.aneel.xml.model.DestRecursosEmp;
import com.aneel.xml.model.DestRecursosExec;
import com.aneel.xml.model.Empresa;
import com.aneel.xml.model.Empresas;
import com.aneel.xml.model.Equipe;
import com.aneel.xml.model.EquipeEmpresa;
import com.aneel.xml.model.EquipeExec;
import com.aneel.xml.model.Etapa;
import com.aneel.xml.model.EtapasList;
import com.aneel.xml.model.Executora;
import com.aneel.xml.model.Executoras;
import com.aneel.xml.model.ImpactosEconomicos;
import com.aneel.xml.model.ImpactosEconomicosList;
import com.aneel.xml.model.ImpactosSocioambientais;
import com.aneel.xml.model.ImpactosSocioambientaisList;
import com.aneel.xml.model.ItemDespesa;
import com.aneel.xml.model.PD_EquipeEmp;
import com.aneel.xml.model.PD_EquipeExec;
import com.aneel.xml.regras.TrataListaSuspensa;
import com.aneel.xml.regras.Util;
import com.aneel.xml.supermodel.DestRecursos;
import com.aneel.xml.supermodel.PD_Recursos;
import com.aneel.xml.supermodel.PD_Resultados;
import com.aneel.xml.supermodel.PD_ResultadosCT;
import com.aneel.xml.supermodel.RecursoEmpresa;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;

public class ManipulaExcel {
	
	public static XSSFWorkbook planilha;
	public static XSSFSheet aba;
	public static String caminho = "C:\\temp\\formulario.xlsx";
	public static XStream xStream = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("-_", "_"))); //evitar double underscore
	
	//FIXME TESTE
	private CapacitacaoProfissionalList CapacitacaoProfissional;
	private ImpactosSocioambientaisList ImpactosSocioambientais;
	private ImpactosEconomicosList ImpactosEconomicos;
	private CapacitacaoTecnologicaTecnicaList CapacitacaoTecnologicaTecnica;
	private CapacitacaoTecnologicaInfraList CapacitacaoTecnologicaInfra;
	
	private DestRecursosExec DestRecursosExec;
	private DestRecursosEmp DestRecursosEmp;

	public static void main(String[] args) {
		
		//XSSF => xlsx (excel >= 2012)
		//HSSF => xls (excel <= 2007)
		
		try {
			
			//valida caminho
	        File diretorio = new File(caminho);
	        if(!diretorio.exists()){
	        	JOptionPane.showMessageDialog(null, "ARQUIVO NAO FOI ENCONTRADO NO CAMINHO: "+caminho);
	        	System.exit(0);
	        }
			
			//LER PLANILHA
	        FileInputStream fis = new FileInputStream(caminho);
	        
	        planilha = new XSSFWorkbook(fis);
	        
	        ManipulaExcel mx = new ManipulaExcel();
	        
	        //teste
//	        mx.varreduraTypesCells(6, 8);
	        
	        mx.gerarAspectosBaseProjeto();
	        mx.gerarEquipeProjetoProponente();
	        mx.gerarEquipeProjetoExecutora();
	        
	        mx.gerarEtapasProjeto();
	        mx.gerarOrigemRecursoExecutora();
	        mx.gerarOrigemRecursoProponente();
	        
	        mx.gerarPDRecursosFULL();
	        
	        mx.gerarCapacitacaoProfissional();
	        mx.gerarCapacitacaoTecnologicaTecnica();
	        mx.gerarCapacitacaoTecnologicaInfra();
	        
	        mx.gerarImpactosSocioambientais();
	        mx.gerarImpactosEconomicos();
	        
//	        mx.gerarResultados();
	        
		} catch (Exception e) {
			System.out.println("Erro ao manipular arquivo XLS: "+e.getMessage());
			e.printStackTrace();
		} finally {
			System.out.println("TERMINADO!");
			JOptionPane.showMessageDialog(null, "Arquivos XML gerados no diretorio = C:\\temp\\");
		}
	}
	
	public static XSSFSheet getAba() {
		return aba;
	}
	
	public static void setAba(int num) {
		aba = planilha.getSheetAt(num);
	}
	
	//NAO FUNCIONA!!!
	public static String formatador(Cell celula) {
		DataFormatter df = new DataFormatter();
		return df.formatCellValue(celula);
	}
	
	//metodo nao recomendado pela APACHE POI, pois PERDE A FORMATACAO
	public static String convertString(Cell celula) {
		celula.setCellType(CellType.STRING);
		//System.out.println("[deprecated] utilizando o setCellType..");
		return celula.getStringCellValue();
	}
	//FIM FORMATADORES
	
//	public static XStream xstrReplacer() {
//		XStream xStream = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("-_", "_")));
//		return xStream;
//	}
	
	public void percorreAbas() {
		ArrayList<String> abas = new ArrayList<String>();
		
        for (int i = 0; i < planilha.getNumberOfSheets(); i++) {
        	Sheet sheet = planilha.getSheetAt(i);
            System.out.println(sheet.getSheetName());
            abas.add(sheet.getSheetName());
        }
	}
	
	//funciona mais ou menos..
	public void varreduraTypesCells(int aba, int numcells) {
		setAba(aba);
		for (int i = 0; i < numcells; i++) {
			System.out.println(getAba().getRow(1).getCell(i).getCellType());
		}
	}
	
	public Writer montaEncondig(OutputStream outputStream) {
		Writer writer = null;
		try {
			writer = new OutputStreamWriter(outputStream, Charset.forName("ISO8859-1"));
	        writer.write("<?xml version=\"1.0\" encoding=\"ISO8859-1\" ?>\n");
		} catch (Exception e) {
			System.out.println("ERRO retornaEncondig: "+e.getMessage());
		}
		return writer;
	}
	
	public void gerarAspectosBaseProjeto() {
		try {
	        setAba(0);
	        
	        AspectoBaseProjeto asp = new AspectoBaseProjeto();
	        
	        asp.setCodProjeto(convertString(getAba().getRow(1).getCell(0)));
	        asp.setArquivoPDF(convertString(getAba().getRow(1).getCell(1)));
	        
	        asp.setDataIniODS(convertString(getAba().getRow(1).getCell(2)));
	        asp.setDataFimODS(convertString(getAba().getRow(1).getCell(3)));
	        
	        
	        asp.setProdPrev(TrataListaSuspensa.listaSimNao(convertString(getAba().getRow(1).getCell(4)))); 
	        asp.setProdJust(convertString(getAba().getRow(1).getCell(5)));
	        asp.setProdEspTec(convertString(getAba().getRow(1).getCell(6))); //LISTA
	        
	        asp.setTecPrev(TrataListaSuspensa.listaSimNao(convertString(getAba().getRow(1).getCell(7)))); //LISTA
	        asp.setTecJust(convertString(getAba().getRow(1).getCell(8)));
	        asp.setTecDesc(convertString(getAba().getRow(1).getCell(9)));
	        
	        asp.setAplicPrev(TrataListaSuspensa.listaSimNao(convertString(getAba().getRow(1).getCell(10)))); //LISTA
	        asp.setAplicJust(convertString(getAba().getRow(1).getCell(11)));
	        asp.setAplicFnc(convertString(getAba().getRow(1).getCell(12)));
	        asp.setAplicAbrang(convertString(getAba().getRow(1).getCell(13)));
	        asp.setAplicAmbito(convertString(getAba().getRow(1).getCell(14)));
	        
	        asp.setTxDifTec(convertString(getAba().getRow(1).getCell(15)));
	        
	        //XML
	        File arquivo = new File("C:\\temp\\PARTE1_AspectoBaseProjeto.xml");
	        
//	        XStream xStream = xstrReplacer();
	        xStream.alias("PD_RelFinalBase", AspectoBaseProjeto.class);
	        
	        OutputStream outputStream = new FileOutputStream(arquivo);
	        xStream.toXML(asp, montaEncondig(outputStream));
	        
		} catch (IOException e) {
			Util.trataErroAbaLog(Constantes.ABA_0, e);
		} finally {
			Util.msgSucesso(Constantes.ABA_0);
		}
	}
	
	public void gerarEquipeProjetoProponente() {
		try {
			setAba(1);
			
			Equipe equipe = new Equipe();
			
			Empresa empresa = new Empresa();
			
			//Double codempresa = getAba().getRow(1).getCell(0).getNumericCellValue();
			//empresa.setCodEmpresa(Util.trataDoubleSimplesDouble(codempresa));
			empresa.setCodEmpresa(convertString(getAba().getRow(1).getCell(0)));
			empresa.setTipoEmpresa(TrataListaSuspensa.listaTipoEmpresa(convertString(getAba().getRow(1).getCell(1))));
			
			String resp = Util.qtdLinhas(Constantes.ABA_1);
		    
		    if(!"".equals(resp)){
		        int count = Integer.valueOf(resp);
		        
		        for (int i = 1; i < count+1; i++) {
		        	EquipeEmpresa equipeEmp = new EquipeEmpresa();
		        	
		        	equipeEmp.setNomeMbEqEmp(convertString(getAba().getRow(i).getCell(2)));
		        	equipeEmp.setCpfMbEqEmp(convertString(getAba().getRow(i).getCell(3)));
		        	equipeEmp.setTitulacaoMbEqEmp(TrataListaSuspensa.listaTitulacao(convertString(getAba().getRow(i).getCell(4))));
		        	
		        	equipeEmp.setFuncaoMbEqEmp(TrataListaSuspensa.listaFuncao(convertString(getAba().getRow(i).getCell(5))));
		        	equipeEmp.setHhMbEqEmp(convertString(getAba().getRow(i).getCell(6)));
		        	equipeEmp.setMesMbEqEmp(convertString(getAba().getRow(i).getCell(7)));
		        	
		        	equipeEmp.setHoraMesMbEqEmp(convertString(getAba().getRow(i).getCell(8)));
		        	
		        	equipe.add(equipeEmp);
				}
		        
		        //XML
		        File arquivo = new File("C:\\temp\\PARTE2_EquipeProjetoProponente.xml");
		        
//		        XStream xStream = new XStream();
		        
		        //ANINHADO DE BAIXO PRA CIMA???
//		        <PD_EquipeEmp>
//		        	<Empresas>
//		       		 	<Empresa>
//		        			<Equipe>
//		        				<EquipeEmpresa>
		        
		        
		        empresa.setEquipe(equipe);
		        Empresas empresas = new Empresas();
		        empresas.add(empresa);
		        PD_EquipeEmp pd_equipeemp = new PD_EquipeEmp();
		        pd_equipeemp.add(empresas);
		        
		        xStream.alias("EquipeEmpresa", EquipeEmpresa.class);
		        xStream.alias("Equipe", Equipe.class);
		        xStream.alias("Empresa", Empresa.class);
		        xStream.alias("Empresas", Empresas.class);
		        xStream.alias("PD_EquipeEmp", PD_EquipeEmp.class);
		        
		        xStream.addImplicitCollection(Equipe.class, "list");
		        xStream.addImplicitCollection(Empresas.class, "list");
		        xStream.addImplicitCollection(PD_EquipeEmp.class, "list");
		        
		        OutputStream outputStream = new FileOutputStream(arquivo);
		        xStream.toXML(pd_equipeemp, montaEncondig(outputStream));
		    }
		} catch (IOException e) {
			Util.trataErroAbaLog(Constantes.ABA_1, e);
		} finally {
			Util.msgSucesso(Constantes.ABA_1);
		}
	}
	
	public void gerarEquipeProjetoExecutora() {
		try {
			setAba(2);
			
			Equipe equipe = new Equipe();
			Executora empresa = new Executora();
			
			empresa.setRazaoSocialExec(convertString(getAba().getRow(1).getCell(0)));
			empresa.setUfExec(TrataListaSuspensa.listaUF(convertString(getAba().getRow(1).getCell(1))));
			//Double cnpj = getAba().getRow(1).getCell(2).getNumericCellValue();
			//empresa.setCNPJExec(Util.trataDoubleCNPJ(cnpj));
			empresa.setCNPJExec(convertString(getAba().getRow(1).getCell(2)));
			//System.out.println("cnpj="+empresa.getCNPJExec());
			
			String resp = Util.qtdLinhas(Constantes.ABA_2);
		    
		    if(!"".equals(resp)){
		        int count = Integer.valueOf(resp);
		        
		        for (int i = 1; i < count+1; i++) {
		        	EquipeExec equipeEmp = new EquipeExec();
		        	
		        	equipeEmp.setNomeMbEqExec(convertString(getAba().getRow(i).getCell(3)));
		        	equipeEmp.setBRMbEqExec(TrataListaSuspensa.listaSimNao(convertString(getAba().getRow(i).getCell(4))));
		        	equipeEmp.setDocMbEqExec(convertString(getAba().getRow(i).getCell(5)));
		        	equipeEmp.setTitulacaoMbEqExec(TrataListaSuspensa.listaTitulacao(convertString(getAba().getRow(i).getCell(6))));
		        	
		        	equipeEmp.setFuncaoMbEqExec(TrataListaSuspensa.listaFuncao(convertString(getAba().getRow(i).getCell(7))));
		        	equipeEmp.setHhMbEqExec(convertString(getAba().getRow(i).getCell(8)));
		        	
		        	//Double mes = getAba().getRow(i).getCell(9).getNumericCellValue();
		        	//equipeEmp.setMesMbEqExec(Util.trataDoubleSimplesDouble(mes));
		        	equipeEmp.setMesMbEqExec(convertString(getAba().getRow(i).getCell(9)));
		        	
		        	//Double horames = getAba().getRow(i).getCell(10).getNumericCellValue();
		        	//equipeEmp.setHoraMesMbEqExec(Util.trataDoubleSimplesDouble(horames));
		        	equipeEmp.setMesMbEqExec(convertString(getAba().getRow(i).getCell(10)));
		        	
		        	equipe.add(equipeEmp);
				}
		        
		        //XML
		        File arquivo = new File("C:\\temp\\PARTE3_EquipeProjetoExecutora.xml");
		        
//		        XStream xStream = new XStream();
		        
		        //ANINHADO DE BAIXO PRA CIMA???
//		        <PD_EquipeExec>
//		    		<Executoras>
//						<Executora>
//							<Equipe>
//								<EquipeExec>
		        
		        empresa.setEquipe(equipe);
		        Executoras empresas = new Executoras();
		        empresas.add(empresa);
		        PD_EquipeExec pd_equipeemp = new PD_EquipeExec();
		        pd_equipeemp.add(empresas);
		        
		        xStream.alias("EquipeExec", EquipeExec.class);
		        xStream.alias("Equipe", Equipe.class); //GENERICO
		        xStream.alias("Executora", Executora.class);
		        xStream.alias("Executoras", Executoras.class);
		        xStream.alias("PD_EquipeExec", PD_EquipeExec.class);
		        
		        xStream.addImplicitCollection(Equipe.class, "list");
		        xStream.addImplicitCollection(Executoras.class, "list");
		        xStream.addImplicitCollection(PD_EquipeExec.class, "list");
		        
		        OutputStream outputStream = new FileOutputStream(arquivo);
		        xStream.toXML(pd_equipeemp, montaEncondig(outputStream));
		    }
		} catch (Exception e) {
			Util.trataErroAbaLog(Constantes.ABA_2, e);
		} finally {
			Util.msgSucesso(Constantes.ABA_2);
		}
	}
	
	public void gerarEtapasProjeto() {
		try {
//	        HSSFSheet aba = planilha.getSheetAt(2);
			setAba(3);
	        EtapasList list = new EtapasList();
	        
	        String resp = Util.qtdLinhas(Constantes.ABA_3);
	        
	        if(!"".equals(resp)){
		        int count = Integer.valueOf(resp);
		        for (int i = 1; i < count+1; i++) {
		        	Etapa etapa = new Etapa();
					//Double etapaNDouble = getAba().getRow(i).getCell(0).getNumericCellValue();
					etapa.setEtapaN(convertString(getAba().getRow(i).getCell(0)));
					etapa.setAtividades(convertString(getAba().getRow(i).getCell(1)));
					etapa.setMesExecEtapa(convertString(getAba().getRow(i).getCell(2)));
					list.add(etapa);
				}
		        
		        //XML
		        File arquivo = new File("C:\\temp\\PARTE4_EtapasProjeto.xml");
		        
//		        XStream xStream = new XStream();
		
		        xStream.alias("Etapa", Etapa.class);
		        xStream.alias("PD_Etapas", EtapasList.class);
		        xStream.addImplicitCollection(EtapasList.class, "list");
		        
		        OutputStream outputStream = new FileOutputStream(arquivo);
		        xStream.toXML(list, montaEncondig(outputStream));
	        }
	        
		} catch (IOException e) {
			Util.trataErroAbaLog(Constantes.ABA_3, e);
		} finally {
			Util.msgSucesso(Constantes.ABA_3);
		}
	}
	
	//FIXME INICIO TESTE
	public void gerarOrigemRecursoExecutora() {
		try {
			setAba(4);
			int linha = 1; //controlador de linhas
			DestRecursosExec dre = new DestRecursosExec();
			
	        for (int j = 0; j < 5; j++) {
	        	
	        	String categoria = "";
	        	String sigla_categoria = "";
	        	
	        	switch (j) {
					case 0:
						categoria = "ST - Serviços de Terceiros";
						sigla_categoria = "ST";
						break;
					case 1:
						categoria = "MC - Material de Consumo";
						sigla_categoria = "MC";
						break;
					case 2:
						categoria = "MP - Materiais Permanentes e Equipamentos";
						sigla_categoria = "MP";
						break;
					case 3:
						categoria = "VD - Viagens e Diárias";
						sigla_categoria = "VD";
						break;
					case 4:
						categoria = "OU - Outros";
						sigla_categoria = "OU";
						break;
				}
	        	
	        	dre.setCNPJExec(convertString(getAba().getRow(1).getCell(1))); //fixo?
	        	
				String qtde = JOptionPane.showInputDialog(null , "Informe a quantidade de Itens da Categoria contábil: "+categoria, Constantes.ABA_4, JOptionPane.PLAIN_MESSAGE);
				
				if("".equals(qtde)){
					qtde = "0";
				}
				
				int count = Integer.valueOf(qtde);
					
				if(count > 0) { //nao cria caso nao exista categoria contabil
		        	CustoCatContabil ccc = new CustoCatContabil();
		        	ccc.setCategoriaContabil(sigla_categoria);
		        	
			        for (int i = 1; i < count+1; i++) {
			        	
			        	ItemDespesa item = new ItemDespesa();
			        	
			        	item.setNomeItem(convertString(getAba().getRow(linha).getCell(3)));
			        	item.setJustificaItem(convertString(getAba().getRow(linha).getCell(4)));
			        	item.setQtdeItem(convertString(getAba().getRow(linha).getCell(5)));
			        	
			        	item.setValorIndItem(convertString(getAba().getRow(i).getCell(6)));
			        	item.setTipoItem(TrataListaSuspensa.listaTipoItem(convertString(getAba().getRow(linha).getCell(7))));
			        	item.setItemLabE(TrataListaSuspensa.listaSimNao(convertString(getAba().getRow(linha).getCell(8))));
			        	item.setItemLabN(TrataListaSuspensa.listaSimNao(convertString(getAba().getRow(linha).getCell(9))));
			        	
			        	ccc.add(item);
			        	linha++;
					}
			        
			        dre.add(ccc);
				}
	        }
		        
	        //XML
	        File arquivo = new File("C:\\temp\\PARTE4_OrigemRecursosExecutora.xml");
	        
	        xStream.alias("DestRecursosExec", DestRecursosExec.class);
	        xStream.alias("CustoCatContabil", CustoCatContabil.class);
	        xStream.alias("ItemDespesa", ItemDespesa.class);
	        
	        xStream.addImplicitCollection(CustoCatContabil.class, "list");
	        xStream.addImplicitCollection(DestRecursosExec.class, "list");
	        
	        OutputStream outputStream = new FileOutputStream(arquivo);
	        xStream.toXML(dre, montaEncondig(outputStream));
	        this.DestRecursosExec = dre;
		    
		} catch (Exception e) {
			Util.trataErroAbaLog(Constantes.ABA_4, e);
		} finally {
			Util.msgSucesso(Constantes.ABA_4);
		}
	}
	
	public void gerarOrigemRecursoProponente() {
		try {
			setAba(5);
			int linha = 1; //controlador de linhas
			DestRecursosEmp dre = new DestRecursosEmp();
			
	        for (int j = 0; j < 5; j++) {
	        	
	        	String categoria = "";
	        	String sigla_categoria = "";
	        	
	        	switch (j) {
					case 0:
						categoria = "ST - Serviços de Terceiros";
						sigla_categoria = "ST";
						break;
					case 1:
						categoria = "MC - Material de Consumo";
						sigla_categoria = "MC";
						break;
					case 2:
						categoria = "MP - Materiais Permanentes e Equipamentos";
						sigla_categoria = "MP";
						break;
					case 3:
						categoria = "VD - Viagens e Diárias";
						sigla_categoria = "VD";
						break;
					case 4:
						categoria = "OU - Outros";
						sigla_categoria = "OU";
						break;
				}
	        	
				String qtde = JOptionPane.showInputDialog(null , "Informe a quantidade de Itens da Categoria contábil: "+categoria, Constantes.ABA_5, JOptionPane.PLAIN_MESSAGE);
				
				if("".equals(qtde)){
					qtde = "0";
				}
				
				int count = Integer.valueOf(qtde);
				
				if(count > 0) { //nao cria caso nao exista categoria contabil
		        	CustoCatContabil ccc = new CustoCatContabil();
		        	ccc.setCategoriaContabil(sigla_categoria);
		        	
			        for (int i = 1; i < count+1; i++) {
			        	
			        	ItemDespesa item = new ItemDespesa();
			        	
			        	item.setNomeItem(convertString(getAba().getRow(linha).getCell(3)));
			        	item.setJustificaItem(convertString(getAba().getRow(linha).getCell(4)));
			        	item.setQtdeItem(convertString(getAba().getRow(linha).getCell(5)));
			        	
			        	item.setValorIndItem(convertString(getAba().getRow(i).getCell(6)));
			        	item.setTipoItem(TrataListaSuspensa.listaTipoItem(convertString(getAba().getRow(linha).getCell(7))));
			        	item.setItemLabE(TrataListaSuspensa.listaSimNao(convertString(getAba().getRow(linha).getCell(8))));
			        	item.setItemLabN(TrataListaSuspensa.listaSimNao(convertString(getAba().getRow(linha).getCell(9))));
			        	
			        	ccc.add(item);
			        	linha++;
					}
			        
			        dre.add(ccc);
				}
	        }
		        
	        //XML
	        File arquivo = new File("C:\\temp\\PARTE5_OrigemRecursosProponente.xml");
	        
	        xStream.alias("DestRecursosEmp", DestRecursosEmp.class);
	        xStream.alias("CustoCatContabil", CustoCatContabil.class);
	        xStream.alias("ItemDespesa", ItemDespesa.class);
	        
	        xStream.addImplicitCollection(CustoCatContabil.class, "list");
	        xStream.addImplicitCollection(DestRecursosEmp.class, "list");
	        
	        OutputStream outputStream = new FileOutputStream(arquivo);
	        xStream.toXML(dre, montaEncondig(outputStream));
	        this.DestRecursosEmp = dre;
		    
		} catch (Exception e) {
			Util.trataErroAbaLog(Constantes.ABA_5, e);
		} finally {
			Util.msgSucesso(Constantes.ABA_5);
		}
	}
	
	public void gerarPDRecursosFULL() {
//		executora:
//		st = 1
//		mc = 2
//		mp = 1
//		vd = 1
//		ou = 2
//
//		proponente:
//		st = 3
		try {
			
			PD_Recursos pdr = new PD_Recursos();
			RecursoEmpresa re = new RecursoEmpresa();
			DestRecursos dr = new DestRecursos();
			
			setAba(4);
			re.setCodEmpresa(convertString(getAba().getRow(1).getCell(1))); //fixo linha 1
			
			dr.setDestRecursosEmp(this.DestRecursosEmp);
			dr.setDestRecursosExec(this.DestRecursosExec);
			
			re.add(dr);
			pdr.add(re);
			
			//XML
	        File arquivo = new File("C:\\temp\\PD_Recursos_COMPLETO.xml");
	        
	        xStream.alias("PD_Recursos", PD_Recursos.class);
	        xStream.alias("RecursoEmpresa", RecursoEmpresa.class);
	        xStream.alias("DestRecursos", DestRecursos.class);
	        xStream.addImplicitCollection(PD_Recursos.class, "list");
	        xStream.addImplicitCollection(RecursoEmpresa.class, "list");
	        
	        OutputStream outputStream = new FileOutputStream(arquivo);
	        xStream.toXML(pdr, montaEncondig(outputStream));
    
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			System.out.println("GERAR PD_RECURSOS COMPLETO!");
		}
	}
	//FIXME FIM TESTE
	
	public void gerarCapacitacaoProfissional() {
		try {
//			HSSFSheet aba = planilha.getSheetAt(4);
			setAba(6);
	        CapacitacaoProfissionalList list = new CapacitacaoProfissionalList();
	        
	        String resp = Util.qtdLinhas(Constantes.ABA_6);
	        
	        if(!"".equals(resp)) {
		        int count = Integer.valueOf(resp);
		        for (int i = 1; i < count+1; i++) {
		        	
		        	CapacitacaoProfissional cp = new CapacitacaoProfissional();
					cp.setTipoCP(TrataListaSuspensa.listaTipoProfissional(convertString(getAba().getRow(i).getCell(0))));
					cp.setConclusaoCP(TrataListaSuspensa.listaSimNao(convertString(getAba().getRow(i).getCell(1))));
					
					//Double dataCP = getAba().getRow(i).getCell(2).getNumericCellValue();
					cp.setDataCP(convertString(getAba().getRow(i).getCell(2)));
					
					//Double cpf = getAba().getRow(i).getCell(3).getNumericCellValue();
					cp.setDocMmbEqCP(convertString(getAba().getRow(i).getCell(3)));
					cp.setCNPJInstCP(convertString(getAba().getRow(i).getCell(4)));
					
					cp.setAreaCP(convertString(getAba().getRow(i).getCell(5)));
					cp.setTituloCP(convertString(getAba().getRow(i).getCell(6)));
					cp.setArquivoPDF(convertString(getAba().getRow(i).getCell(7)));

					list.add(cp);
				}

		        //XML
		        File arquivo = new File("C:\\temp\\PARTE7_CapacitacaoProfissional.xml");
		        
//		        XStream xStream = new XStream();
		
		        xStream.alias("IdCP", CapacitacaoProfissional.class);
		        xStream.alias("PD_ResultadosCP", CapacitacaoProfissionalList.class);
		        xStream.addImplicitCollection(CapacitacaoProfissionalList.class, "list");
		        
		        OutputStream outputStream = new FileOutputStream(arquivo);
		        xStream.toXML(list, montaEncondig(outputStream));
		        this.CapacitacaoProfissional = list;
	        }
	        
		} catch (Exception e) {
			Util.trataErroAbaLog(Constantes.ABA_6, e);
		} finally {
			Util.msgSucesso(Constantes.ABA_6);
		}
	}
	
	public void gerarCapacitacaoTecnologicaTecnica() {
		try {
			setAba(7);
			CapacitacaoTecnologicaTecnicaList list = new CapacitacaoTecnologicaTecnicaList();
	        
	        String resp = Util.qtdLinhas(Constantes.ABA_7);
	        
	        if(!"".equals(resp)) {
		        int count = Integer.valueOf(resp);
		        for (int i = 1; i < count+1; i++) {
		        	
		        	CapacitacaoTecnologicaTecnica cp = new CapacitacaoTecnologicaTecnica();
		        	
					cp.setTipoCT_PC(TrataListaSuspensa.listaTecnicoCientifica(convertString(getAba().getRow(i).getCell(0))));
					cp.setConfPubCT_PC(TrataListaSuspensa.listaSimNao(convertString(getAba().getRow(i).getCell(1))));
					cp.setDataCT_PC(convertString(getAba().getRow(i).getCell(2)));
					
					cp.setNomeCT_PC(convertString(getAba().getRow(i).getCell(3)));
					cp.setLinkCT_PC(convertString(getAba().getRow(i).getCell(4)));
					cp.setPaisCT_PC(convertString(getAba().getRow(i).getCell(5)));
					
					cp.setCidadeCT_PC(convertString(getAba().getRow(i).getCell(6)));
					cp.setTituloCT_PC(convertString(getAba().getRow(i).getCell(7)));
					cp.setArquivoPDF(convertString(getAba().getRow(i).getCell(8)));

					list.add(cp);
				}

		        //XML
		        File arquivo = new File("C:\\temp\\PARTE8_CapacitacaoTecnologicaTecnica.xml");
		        
//		        XStream xStream = xstrReplacer();
		        
		        xStream.alias("IdCT_PC", CapacitacaoTecnologicaTecnica.class);
		        xStream.alias("PD_ResultadosCT_PC", CapacitacaoTecnologicaTecnicaList.class);
		        xStream.addImplicitCollection(CapacitacaoTecnologicaTecnicaList.class, "list");
		        
		        OutputStream outputStream = new FileOutputStream(arquivo);
		        xStream.toXML(list, montaEncondig(outputStream));
		        this.CapacitacaoTecnologicaTecnica = list;
	        }
	        
		} catch (Exception e) {
			Util.trataErroAbaLog(Constantes.ABA_7, e);
		} finally {
			Util.msgSucesso(Constantes.ABA_7);
		}
	}
	
	public void gerarCapacitacaoTecnologicaInfra() {
		try {
			setAba(8);
			CapacitacaoTecnologicaInfraList list = new CapacitacaoTecnologicaInfraList();
	        
	        String resp = Util.qtdLinhas(Constantes.ABA_8);
	        
	        if(!"".equals(resp)) {
		        int count = Integer.valueOf(resp);
		        for (int i = 1; i < count+1; i++) {
		        	
		        	CapacitacaoTecnologicaInfra cp = new CapacitacaoTecnologicaInfra();
		        	
					cp.setTipoCT_IE(TrataListaSuspensa.listaInfraEstrutura(convertString(getAba().getRow(i).getCell(0))));
					cp.setCNPJInstBenefCT_IE(convertString(getAba().getRow(i).getCell(1)));
					cp.setNomeLabCT_IE(convertString(getAba().getRow(i).getCell(2)));
					
					cp.setAreaLabCT_IE(convertString(getAba().getRow(i).getCell(3)));
					cp.setApoioLabCT_IE(convertString(getAba().getRow(i).getCell(4)));

					list.add(cp);
				}

		        //XML
		        File arquivo = new File("C:\\temp\\PARTE9_CapacitacaoTecnologicaInfra.xml");
		        
//		        XStream xStream = xstrReplacer();
		        
		        xStream.alias("IdCT_IE", CapacitacaoTecnologicaInfra.class);
		        xStream.alias("PD_ResultadosCT_IE", CapacitacaoTecnologicaInfraList.class);
		        xStream.addImplicitCollection(CapacitacaoTecnologicaInfraList.class, "list");
		        
		        OutputStream outputStream = new FileOutputStream(arquivo);
		        xStream.toXML(list, montaEncondig(outputStream));
		        this.CapacitacaoTecnologicaInfra = list;
	        }
	        
		} catch (Exception e) {
			Util.trataErroAbaLog(Constantes.ABA_8, e);
		} finally {
			Util.msgSucesso(Constantes.ABA_8);
		}
	}
	
	//NAO DESENVOLVIDA ABA: Capacitação Tecnológica Intelec
	
	public void gerarImpactosSocioambientais() {
		try {
			setAba(10);
			ImpactosSocioambientaisList list = new ImpactosSocioambientaisList();
			
			 String resp = Util.qtdLinhas(Constantes.ABA_10);
		        
	        if(!"".equals(resp)) {
	        	int count = Integer.valueOf(resp);
	        	for (int i = 1; i < count+1; i++) {
	        		
		        	ImpactosSocioambientais is = new ImpactosSocioambientais();
					is.setTipoISA(TrataListaSuspensa.listaIncidadorSocioambiental(convertString(getAba().getRow(i).getCell(0))));
					is.setPossibISA(TrataListaSuspensa.listaSimNao(convertString(getAba().getRow(i).getCell(1))));
					is.setTxtISA(convertString(getAba().getRow(i).getCell(2)));

					list.add(is);
				}
	        }
	        
	        //XML
	        File arquivo = new File("C:\\temp\\PARTE11_ImpactosSocioambientais.xml");
	        
//	        XStream xStream = new XStream();
	
	        xStream.alias("IdSA", ImpactosSocioambientais.class);
	        xStream.alias("PD_ResultadosSA", ImpactosSocioambientaisList.class);
	        xStream.addImplicitCollection(ImpactosSocioambientaisList.class, "list");
	        
	        OutputStream outputStream = new FileOutputStream(arquivo);
	        xStream.toXML(list, montaEncondig(outputStream));
	        this.ImpactosSocioambientais = list;
	        
		} catch (Exception e) {
			Util.trataErroAbaLog(Constantes.ABA_10, e);
		} finally {
			Util.msgSucesso(Constantes.ABA_10);
		}
	}
	
	public void gerarImpactosEconomicos() {
		try {
			setAba(11);
			ImpactosEconomicosList list = new ImpactosEconomicosList();
			
			 String resp = Util.qtdLinhas(Constantes.ABA_11);
		        
	        if(!"".equals(resp)) {
	        	int count = Integer.valueOf(resp);
	        	for (int i = 1; i < count+1; i++) {
	        		
	        		ImpactosEconomicos is = new ImpactosEconomicos();
	        		
	        		//nao pegar celula 0
	        		is.setTipoIE(TrataListaSuspensa.listaIndicadorEconomicoFULL(convertString(getAba().getRow(i).getCell(1))));
	        		is.setTxtBenefIE(convertString(getAba().getRow(i).getCell(2)));
	        		is.setUnidBenefIE(convertString(getAba().getRow(i).getCell(3)));
	        		
	        		is.setBaseBenefIE(convertString(getAba().getRow(i).getCell(4)));
	        		is.setPerBenefIE(convertString(getAba().getRow(i).getCell(5)));
	        		is.setVlrBenefIE(convertString(getAba().getRow(i).getCell(6)));

					list.add(is);
				}
	        }
	        
	        //XML
	        File arquivo = new File("C:\\temp\\PARTE12_ImpactosEconomicos.xml");
	        
//	        XStream xStream = new XStream();
	
	        xStream.alias("IdIE", ImpactosEconomicos.class);
	        xStream.alias("PD_ResultadosIE", ImpactosEconomicosList.class);
	        xStream.addImplicitCollection(ImpactosEconomicosList.class, "list");
	        
	        OutputStream outputStream = new FileOutputStream(arquivo);
	        xStream.toXML(list, montaEncondig(outputStream));
	        this.ImpactosEconomicos = list;
	        
		} catch (Exception e) {
			Util.trataErroAbaLog(Constantes.ABA_11, e);
		} finally {
			Util.msgSucesso(Constantes.ABA_11);
		}
	}
	
	//FIXME INICIO TESTE
	public void gerarResultados() {
		try {
			//SETA
			PD_Resultados resultado = new PD_Resultados();
			PD_ResultadosCT ct = new PD_ResultadosCT();
			
			resultado.setPD_ResultadosCP(this.CapacitacaoProfissional);
			resultado.setPD_ResultadosSA(this.ImpactosSocioambientais);
			resultado.setPD_ResultadosIE(this.ImpactosEconomicos);
			
			ct.setPD_ResultadosCT_PC(this.CapacitacaoTecnologicaTecnica);
			ct.setPD_ResultadosCT_IE(this.CapacitacaoTecnologicaInfra);
			
			resultado.add(ct);
			
			//XML
	        File arquivo = new File("C:\\temp\\RESULTADO.xml");
	        
	        xStream.alias("PD_Resultados", PD_Resultados.class);
	        xStream.alias("PD_ResultadosCT", PD_ResultadosCT.class);
	        xStream.addImplicitCollection(PD_Resultados.class, "list");
	        
	        OutputStream outputStream = new FileOutputStream(arquivo);
	        xStream.toXML(resultado, montaEncondig(outputStream));
    
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			System.out.println("GERADO RESULTADO!");
		}
	}
	//FIXME FIM TESTE
}

/*
<PD_Resultados>
	(PARTE7)
	<PD_ResultadosCT>
		(PARTE8)
		(PARTE9)
	</PD_ResultadosCT>
	(PARTE11)
	(PARTE12)
</PD_Resultados>
*/