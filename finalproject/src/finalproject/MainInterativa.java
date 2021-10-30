	package finalproject;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainInterativa {
	public static void main(String[] args) throws ElementoRepetidoException, ArgumentoInvalidoException {
		Scanner s = new Scanner(System.in);
		boolean parar = false;
		ListaDeCompras lista = new ListaDeCompras();
		
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("" 
				+ "'nwpc' = cadastra um novo produto de comida\n"
				+ "'nwpb' = cadastra um novo produto de bebida\n"
				+ "'rmp' = remove um produto existente na lista pelo nome\n"
				+ "'addqnt' = adiciona uma quantidade em um produto existente na lista\n"
				+ "'rmqnt' = remove uma quantidade de um produto existente na lista\n"
				+ "'total' = mostra o valor total dos produtos da lista\n"
				+ "'buscar' = mostra uma lista com os produtos que têm a chave passada no nome\n"
				+ "'limpar' = limpa a lista\n"
				+ "'show' = mostra a lista de compras\n"
				+ "'end' = parar programa");
		System.out.println("----------------------------------------------------------------------------");
		
		float valorc = 0;
		int qntc = 0;
		float peso = 0;
		float valorb = 0;
		int qntb = 0;
		float ml = 0;
		String id = "";
		String nomea = "";
		int qn = 0;
		String nomeb = "";
		int qt = 0;
		String key = "";
		
		while(parar == false) {
			System.out.println("Digite um comando (sem as aspas): ");
			String aux = s.nextLine();
			String separa[] = aux.split(" "); 
						
			switch(separa[0]) {
			case "nwpc":
				if(separa.length == 5) {
					String idc = separa[1];
					// Se o valor for com ponto.
					try {
						valorc = Float.parseFloat(separa[2]);
					}catch(NumberFormatException e) {
						System.err.println("O preço está escrito de forma incorreta. Deve ser passado com ponto.");
						break;
					}
					try {
						qntc = Integer.parseInt(separa[3]);
					}catch(InputMismatchException | NumberFormatException e) {
						System.err.println("A quantidade está escrita de forma incorreta. É para ser um inteiro.");
						break;
					}
					try {
						peso = Float.parseFloat(separa[4]);
					}catch(NumberFormatException e){
						System.err.println("O peso está escrito de forma incorreta. Deve ser passado com ponto.");
						break;
					}
					try {
						Produto prodc = new ProdutoComida(idc, valorc, qntc, peso);
						lista.cadastrarProduto(prodc);
					}catch(Exception e) {
						System.err.println(e.getMessage());
					}
				}else {
					System.err.println("Passou parametros em excesso ou em falta.");
				}
				break;
				
			case "nwpb":
				if(separa.length == 5) {
					String idb = separa[1];
					// Se o valor for com ponto.
					try {
						valorb = Float.parseFloat(separa[2]);
					}catch(NumberFormatException e) {
						System.err.println("O preço está escrito de forma incorreta. Deve ser passado com ponto.");
						break;
					}
					try {
						qntb = Integer.parseInt(separa[3]);
					}catch(InputMismatchException | NumberFormatException e) {
						System.err.println("A quantidade está escrita de forma incorreta. É para ser um inteiro.");
						break;
					}
					try {
						ml = Float.parseFloat(separa[4]);
					}catch(NumberFormatException e) {
						System.err.println("O Ml está escrito de forma incorreta. Deve ser passado com ponto.");
						break;
					}
					try {
						Produto prodb = new ProdutoBebida(idb, valorb, qntb, ml);			
						lista.cadastrarProduto(prodb);
					}catch (Exception e) {
						System.err.println(e.getMessage());
					}
				}else {
					System.err.println("Passou parametros em excesso ou em falta.");
				}
				break;
				
			case "rmp":
				if(separa.length == 2) {
					id = separa[1];
					try {
						lista.removerProduto(id);
					}catch(Exception e) {
						System.err.println(e.getMessage());
					}
				}else {
					System.err.println("Passou parametros em excesso ou em falta.");
				}	
				break;
				
			case "addqnt":
				if(separa.length == 3) {
					nomea = separa[1];
					try {
						qn = Integer.parseInt(separa[2]);
					}catch(InputMismatchException | NumberFormatException e) {
						System.err.println("A quantidade está escrita de forma incorreta. É para ser um inteiro.");
						break;
					}
					
					try {
						lista.addQuantidade(nomea, qn);
					}catch (Exception e) {
						System.err.println(e.getMessage());
					}
				}else {
					System.err.println("Passou parametros em excesso ou em falta.");
				}	
				break;
				
			case "rmqnt":
				if(separa.length == 3) {
					nomeb = separa[1];
					System.out.println("OBS: Se você remover toda a quantidade de um produto, ele sai da lista.");
					
					try {
						qt = Integer.parseInt(separa[2]);
					}catch(InputMismatchException | NumberFormatException e) {
						System.err.println("A quantidade está escrita de forma incorreta. É para ser um inteiro.");
						break;
					}
					
					try {
						lista.rmQuantidade(nomeb, qt);
					}catch (Exception e) {
						System.err.println(e.getMessage());
					}
				}else {
					System.err.println("Passou parametros em excesso ou em falta.");
				}	
				break;
				
			case "total":
				System.out.println(lista.valorTotal());
				break;
				
			case "buscar":
				if(separa.length == 2) {
					key = separa[1];
					try {
						ArrayList<Produto> busca = new ArrayList<Produto>();
						busca = lista.searchProduto(key);
						for(int i=0; i < busca.size(); i++) {
							System.out.println(busca.get(i));
						}
					}catch(Exception e) {
						System.err.println(e.getMessage());
					}
				}else {
					System.err.println("Passou parametros em excesso ou em falta.");
				}
				break;
				
			case "limpar":
				lista.limparLista();
				break;
				
			case "show":
				System.out.println(lista);
				break;
				
			case "end":
				parar = true;
				System.out.println("Voce parou o programa.");
				break;
				
			default :
				System.err.println("Comando '"+ separa[0] +"' invalido.");
				break;
			}
		}			
		s.close();
	}
}