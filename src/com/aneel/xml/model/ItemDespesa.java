package com.aneel.xml.model;

/*
<NomeItem></NomeItem>
<JustificaItem></JustificaItem>
<QtdeItem></QtdeItem>

<ValorIndItem></ValorIndItem>
<TipoItem></TipoItem>
<ItemLabE></ItemLabE>
<ItemLabN></ItemLabN>
 */

public class ItemDespesa {
	private String NomeItem;
	private String JustificaItem;
	private String QtdeItem;
	
	private String ValorIndItem;
	private String TipoItem;
	private String ItemLabE;
	private String ItemLabN;
	
	public String getNomeItem() {
		return NomeItem;
	}
	public void setNomeItem(String nomeItem) {
		NomeItem = nomeItem;
	}
	public String getJustificaItem() {
		return JustificaItem;
	}
	public void setJustificaItem(String justificaItem) {
		JustificaItem = justificaItem;
	}
	public String getQtdeItem() {
		return QtdeItem;
	}
	public void setQtdeItem(String qtdeItem) {
		QtdeItem = qtdeItem;
	}
	public String getValorIndItem() {
		return ValorIndItem;
	}
	public void setValorIndItem(String valorIndItem) {
		ValorIndItem = valorIndItem;
	}
	public String getTipoItem() {
		return TipoItem;
	}
	public void setTipoItem(String tipoItem) {
		TipoItem = tipoItem;
	}
	public String getItemLabE() {
		return ItemLabE;
	}
	public void setItemLabE(String itemLabE) {
		ItemLabE = itemLabE;
	}
	public String getItemLabN() {
		return ItemLabN;
	}
	public void setItemLabN(String itemLabN) {
		ItemLabN = itemLabN;
	}
}
