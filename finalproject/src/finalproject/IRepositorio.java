package finalproject;

import java.util.ArrayList;

public interface IRepositorio {
	void cadastrarProduto(Produto p) throws ElementoRepetidoException, ArgumentoInvalidoException;
	void removerProduto(String id) throws ArgumentoInvalidoException;
	ArrayList<Produto> searchProduto(String pattern) throws ArgumentoInvalidoException;
}
