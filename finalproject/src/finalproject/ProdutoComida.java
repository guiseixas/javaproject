package finalproject;

public class ProdutoComida extends Produto implements Tipo {
	
	public String type;
	public float peso;

	public ProdutoComida(String id, float preco, int quantidade, float peso) {
		super(id, preco, quantidade, peso, 0);
		this.peso = peso;
		this.type = "Comida";
	}

	public String getType() {
		return type;
	}
	
	public float getPeso() {
		return peso;
	}
	
	public float getMl() {
		return 0;
	}

	public String toString() {
		return "Nome: " + getId() + ", " + "Preço (Unidade): R$ "+ floatFormatado(getPreco()) + ", " + "Quantidade: " + getQuantidade() + ", " + "Peso: "+ floatFormatado(getPeso()) + " g";
	}
	
	public String floatFormatado(float aux) {
        String stringFormatada = String.format("%.02f", aux);
        return stringFormatada;
    }
}
