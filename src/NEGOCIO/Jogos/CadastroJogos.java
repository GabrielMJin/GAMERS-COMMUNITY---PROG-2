package NEGOCIO.Jogos;

import DADOS.RepositorioJogosArray;


public class CadastroJogos {
	private RepositorioJogosArray repositorioJogos;
	
	public CadastroJogos() {
		this.repositorioJogos = new RepositorioJogosArray(500);
	}
	
	public void cadastrar(Jogos a) {
		if(a!=null && !this.existe(a.getNome(),a.getTipo())) {
			this.repositorioJogos.cadastrarJogo(a);
		}
	}
	public Jogos procurar(String num,int tipo) {
		return this.repositorioJogos.procurar(num,tipo);
	}
	public boolean existe(String numConta,int tipo) {
		return this.repositorioJogos.existe(numConta,tipo);
	}
	public void descadastrar(String numConta,int tipo) {
		Jogos aux = this.repositorioJogos.procurar(numConta,tipo);
		
		if(aux!=null) {
			this.repositorioJogos.remover(numConta,tipo);
		}
		else {
			//Jogo inexistente
		}
	}
	
}
