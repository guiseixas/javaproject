package finalproject;
import java.util.ArrayList;

//import exceptions.ElementoRepetidoException;

public class ListaDeCompras implements IRepositorio {
	private ArrayList<Produto> produtos;
	
	public ListaDeCompras(){
		produtos = new ArrayList<Produto>();
	}
	
	public void cadastrarProduto(Produto p) throws ElementoRepetidoException, ArgumentoInvalidoException {
		boolean aux = false;
		for(int i=0; i<produtos.size(); i++) {
			if(produtos.get(i).getId().equals(p.getId())) {
				aux = true;
				break;
			}	
		}
		
		char[] c = p.getId().toCharArray();
		for(int i = 0; i < c.length; i++) {
			if(!Character.isAlphabetic(c[i]) && c[i] != '-'){
				throw new ArgumentoInvalidoException("Passagem de parametro de ID invalida.");
			}
		}
		
		if(aux) { //Ja esta cadastrado.
			throw new ElementoRepetidoException("Ja existe este produto cadastrado.");
		}else {
			produtos.add(p);
			System.out.println("Produto cadastrado com sucesso.");
		}
	}
	
	public void removerProduto(String id) throws ArgumentoInvalidoException {
		ArrayList<Produto> produtosaux = getProdutos();
		boolean aux = false;
		for(Produto p : produtosaux) {
			if(p.getId().equals(id)) {
				aux = true;
				produtosaux.remove(p);
				System.out.println("Produto removido com sucesso.");
				break;
			}
		}
		if(!aux) {
			throw new ArgumentoInvalidoException("O produto com esse ID não foi encontrado na lista de compras.");
		}
	}
	
	public ArrayList<Produto> searchProduto(String pattern) throws ArgumentoInvalidoException {
		ArrayList<Produto> retorno = new ArrayList<Produto>();
		for(int i=0; i<produtos.size(); i++) {
			String comparar = produtos.get(i).getId();
			if(comparar.contains(pattern)) {
				retorno.add(produtos.get(i));
			}
		}
		
		if(retorno.size() == 0) {
			throw new ArgumentoInvalidoException("Nenhum produto encontrado com a chave passada.");
		}
		return retorno;
	}
	
	public void addQuantidade(String id, int quantidade) throws ArgumentoInvalidoException {
		boolean aux = false;
		for(int i=0; i < produtos.size(); i++) {
			if(produtos.get(i).getId().equals(id)) {
				produtos.get(i).addQuantidade(quantidade);
				System.out.println("Quantidade adicionada com sucesso");
				aux = true;
				break;
			}
		}
		if(!aux) {
			throw new ArgumentoInvalidoException("O produto com esse ID não foi encontrado na lista de compras.");
		}
	}
	
	public void rmQuantidade(String id, int quantidade) throws ArgumentoInvalidoException {
		boolean aux = false;
		int qntAuxiliar;
		for(int i=0; i < produtos.size(); i++) {
			if(produtos.get(i).getId().equals(id)) {
				qntAuxiliar = produtos.get(i).getQuantidade();
				produtos.get(i).rmQuantidade(quantidade);
				if(qntAuxiliar > produtos.get(i).getQuantidade()) {
					System.out.println("Quantidade removida com sucesso");
				}
				if(produtos.get(i).getQuantidade() == 0) {
					produtos.remove(i); //se a quantidade chegar à zero, o produto é removido
				}
				aux = true;
				break;
			}
		}
		if(!aux) {
			throw new ArgumentoInvalidoException("O produto com esse ID não foi encontrado na lista de compras.");
		}
	}
	
	public String valorTotal() {
		String total = "";
		float valor = 0;
		for(int i=0; i < produtos.size(); i++) {
			valor = valor + (produtos.get(i).getPreco() * produtos.get(i).getQuantidade());
		}
		
		total = "Valor total: R$ " + floatFormatado(valor);
		return total;
	}
	
	public void limparLista() {
		for(int i=0; i < produtos.size(); i++) {
			if(comparaTipo(i).equals("Comida")) {
				produtos.remove(i);
			}
		}for(int i=0; i < produtos.size(); i++) {
			if(comparaTipo(i).equals("Bebida")) {
				produtos.remove(i);
			}
		}
		System.out.println("Lista limpa com sucesso.");
	}
	
	public boolean exists(String id) { 
		for(int i=0; i < produtos.size(); i++) {
			if(produtos.get(i).getId().equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	public void show() {
		for(int i=0; i<produtos.size(); i++) {
			System.out.println(produtos.get(i));
		}
	}
	
	public String comparaTipo(int index) {
		String resultado = "";
		if(produtos.get(index).getPeso() != 0) {
			resultado = "Comida";
		}else {
			resultado = "Bebida";
		}
		return resultado;
	}
	
	public String toString() {
		String auxiliar = "----------------------------------------------------------------------------";
		auxiliar += "\nLista de Compras:";
		
		auxiliar += "\nComidas: \n";
		for(int i=0; i<produtos.size(); i++) {
			if(comparaTipo(i).equals("Comida")) {
				auxiliar += produtos.get(i) + "\n";
			}
		}
		
		auxiliar += "Bebidas: \n";
		for(int i=0; i < produtos.size(); i++) {
			if(comparaTipo(i).equals("Bebida")) {
				auxiliar += produtos.get(i) + "\n";
			}
		}
		auxiliar += "----------------------------------------------------------------------------";
		return auxiliar;
	}
	
	public String floatFormatado(float aux) {
        String stringFormatada = String.format("%.02f", aux);
        return stringFormatada;
    }

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}
}
