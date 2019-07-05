package NEGOCIO.Jogos;

import DADOS.RepositorioJogosArray;


public class CadastroJogos {
	private RepositorioJogosArray repositorioJogos;
	
	public CadastroJogos() {
		this.repositorioJogos = new RepositorioJogosArray(500);
	}
	
	public boolean cadastrar(Jogos a) {
		boolean b = false;
		if(a!=null && !this.existe(a.getNome(),a.getTipo())) {
			this.repositorioJogos.cadastrarJogo(a);
			b = true;
		}
		return b;
	}
	public Jogos procurar(String num,int tipo) {
		return this.repositorioJogos.procurar(num,tipo);
	}
	public boolean existe(String numConta,int tipo) {
		return this.repositorioJogos.existe(numConta,tipo);
	}
	public boolean descadastrar(String numConta,int tipo) {
		Jogos aux = this.repositorioJogos.procurar(numConta,tipo);
		boolean a= false;
		if(aux!=null) {
			this.repositorioJogos.remover(numConta,tipo);
			a=true;
		}
		else {
			//Jogo inexistente
		}
		return a;
	}
	
}
