package repositorios;

import base.ItemVenda;
import base.Venda;


import exceptions.SemPosicaoParaInserirException;
import exceptions.TamanhoException;

public class RepositorioVendaArray {
	private Venda[] venda;
	private int indice;
	
	public RepositorioVendaArray () {
		this.venda = new Venda[100];
	}
	
	public void inserir (Venda venda) throws SemPosicaoParaInserirException {
		boolean found = false;
		if (this.venda[indice] == null){//se a posi��o esta vaga coloque
			this.venda[indice] = venda;
			found = true;
			indice++;			
		}else {//se n�o estiver procure em todas as posi��es do array se tem posisao livre
			for (int i = 0; i < this.venda.length; i++){
				if (this.venda[i] == null){
					this.venda[indice] = venda;
					found = true;
					indice++;
					break;
				}
			}
		}
		if (!found) {// se nao inserio
			SemPosicaoParaInserirException e = new SemPosicaoParaInserirException();
			throw e;
		}
	}
	
	public void removerVenda (int id) {
		boolean found = false;
		for (int i = 0; i < this.venda.length; i++){
			if (this.venda[i].getId() == id) {
				this.venda[i] = null;
				indice--;
				found = true;
				break;
			}
		}
		if (!found) {//se n�o removeu!!
			NullPointerException e = new NullPointerException();
			throw e;
		}
	}
	
	public void atualizar (Venda venda) throws NullPointerException {
		boolean found = false;
		for (int i = 0; i < this.venda.length; i++){
			if (this.venda[i].getId() == venda.getId()) {
				this.venda[i] = venda;
				found = true;
				break;
			}
		}
		if (!found) {
			NullPointerException e = new NullPointerException();
			throw e;
		}
	}
	
	public Venda procurarVenda (int id) throws NullPointerException {
		for (int i = 0; i < this.venda.length; i++){
			if(this.venda[i].getId() == id) {
				return this.venda[i];
			}
		}
		NullPointerException e = new NullPointerException();
		throw e;
	}
	
	public String[][] todasVendas() throws TamanhoException {
		int i = 0;
		int a = 0;
		String[][] vendas = new String [venda.length][9];
		String itens = null;
		
		while (venda[i] != null){
			
			vendas[i][0] = Integer.toString(venda[i].getId());
			vendas[i][1] = Integer.toString(venda[i].getIdCliente());
			vendas[i][2] = Float.toString(venda[i].getTotal());
			vendas[i][3] = venda[i].getData();
			
			ItemVenda itemVenda[] = new ItemVenda[10];
			while(venda[i].getVendas()[a] != null) {//em quanto existir itens de venda
				itemVenda[a].setIdVenda(venda[i].getVendas()[a].getIdVenda());
				itemVenda[a].setIdProduto(venda[i].getVendas()[a].getIdProduto());
				itemVenda[a].setQuantidade(venda[i].getVendas()[a].getQuantidade());
				
				
				itens += ", " + Integer.toString(itemVenda[a].getId()) + Integer.toString(itemVenda[a].getIdVenda()) 
				+ Integer.toString(itemVenda[a].getIdProduto()) + Integer.toString(itemVenda[a].getQuantidade()) ;
				a++;
			}
			
			vendas[i][4] = itens; 
			
			i++;
		}
		return vendas;
	}	
}
