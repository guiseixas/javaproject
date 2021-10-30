package finalproject;

public abstract class Produto {
	private String id;
	private float preco;
	private int quantidade;
	private float peso;
	private float ml;
	
	public Produto(String id, float preco, int quantidade, float peso, float ml) {
		this.id = id;
		this.preco = preco;
		this.quantidade = quantidade;
		this.peso = peso;
		this.ml = ml;
	}
	
	public void addQuantidade(int quantidade) throws ArgumentoInvalidoException { // Exception quantidade menor q zero erro.
		if(quantidade > 0 ) {
			setQuantidade(getQuantidade() + quantidade);
		}
		else {
			throw new ArgumentoInvalidoException("Quantidade invalida a ser adicionada (0 ou menor)");
		}
	}
	
	public void rmQuantidade(int quantidade) throws ArgumentoInvalidoException {
		boolean remover = true;
		if(getQuantidade() <= 0){
			remover = false;
			throw new ArgumentoInvalidoException("A quantidade do produto era zero");
		}
		
		if(getQuantidade() < quantidade) {
			remover = false;
			throw new ArgumentoInvalidoException("Quantidade invalida a ser removida (quantidade maior do que já existe)");
		}
		
		if(quantidade <= 0) {
			remover = false;
			throw new ArgumentoInvalidoException("Quantidade invalida a ser removida (quantidade menor ou igual a zero)");
		}
		
		if(remover) {
			setQuantidade(getQuantidade() - quantidade);
		}
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String toString() {
		return "id: " +id+ ", preco: "+preco+", quantidade: "+quantidade;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getPeso() {
		return peso;
	}

	public float getMl() {
		return ml;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public void setMl(float ml) {
		this.ml = ml;
	}	
	
}
