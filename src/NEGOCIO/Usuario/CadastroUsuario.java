package NEGOCIO.Usuario;

import DADOS.RepositorioUsuarioArray;

public class CadastroUsuario {
	
	public RepositorioUsuarioArray getRepositorioUsuario() {
		return repositorioUsuario;
	}
	public void setRepositorioUsuario(RepositorioUsuarioArray repositorioUsuario) {
		this.repositorioUsuario = repositorioUsuario;
	}
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
	public boolean descadastrar(String numConta) {
		Usuario aux = this.repositorioUsuario.procurar(numConta);
			boolean a = false;
		if(aux!=null) {
			this.repositorioUsuario.remover(numConta);
			a= true;
		}
		else {
			//conta inexistente
		}
		return a;
	}
	
	
}
