package finalproject;

public class ProdutoBebida extends Produto implements Tipo {
	
	public String type;
	public float ml;

	public ProdutoBebida(String id, float preco, int quantidade, float ml) {
		super(id, preco, quantidade, 0, ml);
		this.ml = ml;
		this.type = "Bebida";
	}

	public String getType() {
		return type;
	}
	
	public float getPeso() {
		return 0;
	}
	
	public float getMl() {
		return ml;
	}

	public String toString() {
		return "Nome: " + getId() + ", " + "Preço (Unidade): R$ "+ floatFormatado(getPreco()) + ", " + "Quantidade: " + getQuantidade() +", " + "Ml: "+ floatFormatado(getMl()) + " ml";
	}
	
	public String floatFormatado(float aux) {
        String stringFormatada = String.format("%.02f", aux);
        return stringFormatada;
    }
}
