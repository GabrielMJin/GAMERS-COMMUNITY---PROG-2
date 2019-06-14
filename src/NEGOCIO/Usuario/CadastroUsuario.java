package NEGOCIO.Usuario;

import DADOS.RepositorioUsuarioArray;

public class CadastroUsuario {
	
	private RepositorioUsuarioArray repositorioUsuario;
	
	public CadastroUsuario() {
		this.repositorioUsuario = new RepositorioUsuarioArray(500);
	}
	public void cadastrar(Usuario a) {
		if(a!=null && !this.existe(a.getLogin())) {
			this.repositorioUsuario.cadastrar(a);
		}
	}
	
	public Usuario procurar(String num) {
		return this.repositorioUsuario.procurar(num);
	}
	public boolean existe(String numConta) {
		return this.repositorioUsuario.existe(numConta);
	}
	public void descadastrar(String numConta) {
		Usuario aux = this.repositorioUsuario.procurar(numConta);
		
		if(aux!=null) {
			this.repositorioUsuario.remover(numConta);
		}
		else {
			//conta inexistente
		}
	}
	
	
}
